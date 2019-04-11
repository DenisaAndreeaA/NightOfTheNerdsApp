package fhict.org.nightofthenerds.UI.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Domain.RouteType;
import fhict.org.nightofthenerds.UI.Domain.User;
import fhict.org.nightofthenerds.UI.Fragments.BadgesFragment;
import fhict.org.nightofthenerds.UI.Fragments.CheckinCheckoutFragment;
import fhict.org.nightofthenerds.UI.Logic.FirebaseUserDataService;
import fhict.org.nightofthenerds.UI.Logic.UserInstanceGetter;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private RouteType routeType;
    private NavigationView navigationView;
    private Fragment activeFragment;

    private DatabaseReference mUserObjectRef;
    private ValueEventListener mUserObjectRefListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int routeNumber = Integer.valueOf(extras.getString("route_type"));

            switch(routeNumber){
                case 0: routeType = RouteType.SOCIAL; break;
                case 1: routeType = RouteType.MIXED; break;
                case 2: routeType = RouteType.CREATIVE; break;
                case 3: routeType = RouteType.TECH; break;
                default: routeType  = RouteType.MIXED; break;
            }
        }


        String uid = FirebaseAuth.getInstance().getUid();
        mUserObjectRef = FirebaseDatabase.getInstance().getReference("nightOfTheNerds")
                .child("user").child(uid);

        //Navigation and Toolbar Setup
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                            Fragment fragment = null;
                            Class fragmentClass = null;

                            switch(menuItem.getItemId()) {
                                case R.id.nav_badges:{
                                    fragmentClass = BadgesFragment.class;
                                    break;
                                }
                                case R.id.nav_checkin_checkout: {
                                    fragmentClass = CheckinCheckoutFragment.class;
                                    break;
                                }
                                case R.id.nav_stands: {

                                    break;
                                }
                            }

                            if(!activeFragment.equals(fragment)){{

                                try {
                                    fragment = (Fragment) fragmentClass.newInstance();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                changeFragment(fragment,true);
                                menuItem.setChecked(true);
                                setTitle(menuItem.getTitle());
                            }
                        }
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        TextView tvUserName = navigationView.getHeaderView(0).findViewById(R.id.tv_nav_username);

        String username;
        if(account != null){
            username = account.getDisplayName();
        }
        else{
            username = "Nerd";
        }
        tvUserName.setText(username);

        changeFragment(new BadgesFragment(), true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ArrayList<String> userIds = new ArrayList<>();

        DatabaseReference mUsersRef = FirebaseDatabase.getInstance().getReference("nightOfTheNerds").child("user");
        mUsersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    userIds.add(child.getKey().toString());
                }

                FirebaseUserDataService firebaseUserDataService = new FirebaseUserDataService(getApplicationContext());
                firebaseUserDataService.postNewUser(routeType, userIds);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mUserObjectRef.addValueEventListener( mUserObjectRefListener =  new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                UserInstanceGetter.setUser(user);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mUserObjectRef.removeEventListener(mUserObjectRefListener);
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        if(addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();

        activeFragment = fragment;
        syncNavigationWithFragment();
    }

    private void syncNavigationWithFragment(){
        Fragment current = activeFragment;
        if(current instanceof BadgesFragment){
            navigationView.setCheckedItem(R.id.nav_badges);
        }
        else if(current instanceof CheckinCheckoutFragment){
            navigationView.setCheckedItem(R.id.nav_checkin_checkout);
        }
//        else if(current instanceof StandFragment){
//            navigationView.setCheckedItem(R.id.nav_stands);
//        }
    }


}

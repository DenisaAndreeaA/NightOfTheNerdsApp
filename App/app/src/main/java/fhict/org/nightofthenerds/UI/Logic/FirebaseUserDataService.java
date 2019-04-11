package fhict.org.nightofthenerds.UI.Logic;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Domain.RouteType;
import fhict.org.nightofthenerds.UI.Domain.User;

public class FirebaseUserDataService {

    private DatabaseReference mUserRef;
    private Context context;

    public FirebaseUserDataService(Context context) {
        this.context = context;
    }

    public void postNewUser(RouteType routeType, ArrayList<String> userIds) {
        boolean noAccount = true;
        String uid = FirebaseAuth.getInstance().getUid();

        if(!userIds.isEmpty()){
            for(String id : userIds){
                if(uid.equals(id)){
                    noAccount = false;
                }
            }
        }

        if(noAccount){
                mUserRef = FirebaseDatabase.getInstance().getReference("nightOfTheNerds").child("user").child(uid);
                User user = new User(routeType);
                mUserRef.setValue(user);
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences("shared_preferences", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("route_selected", true);
        editor.apply();
    }

    public void postUserCompletedStand(String standId){
        String uid = FirebaseAuth.getInstance().getUid();
        mUserRef = FirebaseDatabase.getInstance().getReference("nightOfTheNerds").child("user").child(uid);
        User user = UserInstanceGetter.getUser();
        user.completedStands.add("STAND50000");

        mUserRef.updateChildren(user.toMap());
    }

}

package fhict.org.nightofthenerds.UI.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UnknownFormatConversionException;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Adapters.RouteStandListAdapter;
import fhict.org.nightofthenerds.UI.Domain.RouteStandDTO;
import fhict.org.nightofthenerds.UI.Domain.RouteType;

public class RouteActivity extends AppCompatActivity implements View.OnClickListener {

    private RouteActivity instance;

    private RecyclerView rvRoutes;
    private List<RouteStandDTO> routes = new ArrayList<>(); //for testing without firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        instance = this;

        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", 0);
        if(sharedPreferences.getBoolean("route_selected", false)){
            startMainActivity(null);
        }

        TextView titleTV = (TextView)findViewById(R.id.tvRoutesTitle);
        Typeface arcade_font = Typeface.createFromAsset(getAssets(), "fonts/PressStart2P_Regular.ttf");
        titleTV.setTypeface(arcade_font);

        rvRoutes = findViewById(R.id.routeList);

        routes.add(new RouteStandDTO(1, "<society route>", getResources().getColor(R.color.route1Background), BitmapFactory.decodeResource(getResources(), R.drawable.social_route_plastic), RouteStandDTO.ROUTE));
        routes.add(new RouteStandDTO(2, "<additional route>", getResources().getColor(R.color.route2Background), BitmapFactory.decodeResource(getResources(), R.drawable.mixed_route_kunnen), RouteStandDTO.ROUTE));
        routes.add(new RouteStandDTO(3, "<creative route>", getResources().getColor(R.color.route3Background), BitmapFactory.decodeResource(getResources(), R.drawable.creative_route_dans), RouteStandDTO.ROUTE));
        routes.add(new RouteStandDTO(4, "<tech route>", getResources().getColor(R.color.route4Background), BitmapFactory.decodeResource(getResources(), R.drawable.tech_route_raceauto), RouteStandDTO.ROUTE));
    }

    @Override
    protected void onResume() {
        super.onResume();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvRoutes.setLayoutManager(llm);

        //set the height of the items when the recyclerview is drawn
        rvRoutes.getViewTreeObserver().addOnGlobalLayoutListener(recyclerViewDrawnListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    ViewTreeObserver.OnGlobalLayoutListener recyclerViewDrawnListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            final float scale = instance.getResources().getDisplayMetrics().density;
            RouteStandListAdapter rslAdapter = new RouteStandListAdapter(instance, routes, (int) (100 * scale + 0.5f), true);
            rvRoutes.setAdapter(rslAdapter);

            rvRoutes.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    };


    @Override
    public void onClick(View v) {
        String itemPosition = String.valueOf(rvRoutes.getChildLayoutPosition(v));
        startMainActivity(itemPosition);

    }

    private void startMainActivity(String routeType){
        Intent intent = new Intent(this, MainActivity.class);
        if(routeType != null){
            intent.putExtra("route_type", routeType);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }



}

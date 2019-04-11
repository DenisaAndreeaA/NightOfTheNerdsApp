package fhict.org.nightofthenerds.UI.Activities;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Adapters.RouteStandListAdapter;
import fhict.org.nightofthenerds.UI.Domain.RouteStandDTO;

public class StandActivity extends AppCompatActivity implements View.OnClickListener{

    private StandActivity instance;

    private RecyclerView rvStands;
    private List<RouteStandDTO> stands = new ArrayList<>(); //for testing without firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand);
        instance = this;

        rvStands = (RecyclerView) findViewById(R.id.standList);

        stands.add(new RouteStandDTO(1,"Hello world", getResources().getColor(R.color.stand1Background), BitmapFactory.decodeResource(getResources(), R.drawable.stand1), RouteStandDTO.STAND_ODD));
        stands.add(new RouteStandDTO(2,"Hello world", getResources().getColor(R.color.stand2Background), BitmapFactory.decodeResource(getResources(), R.drawable.stand2), RouteStandDTO.STAND_EVEN));
        stands.add(new RouteStandDTO(3,"Hello world", getResources().getColor(R.color.stand3Background), BitmapFactory.decodeResource(getResources(), R.drawable.stand3), RouteStandDTO.STAND_ODD));
        stands.add(new RouteStandDTO(4,"Hello world", getResources().getColor(R.color.stand4Background), BitmapFactory.decodeResource(getResources(), R.drawable.stand4), RouteStandDTO.STAND_EVEN));
    }

    @Override
    protected void onResume() {
        super.onResume();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvStands.setLayoutManager(llm);

        //set the height of the items when the recyclerview is drawn
        rvStands.getViewTreeObserver().addOnGlobalLayoutListener(recyclerViewDrawnListener);
    }

    ViewTreeObserver.OnGlobalLayoutListener recyclerViewDrawnListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            final float scale = instance.getResources().getDisplayMetrics().density;
            RouteStandListAdapter rslAdapter = new RouteStandListAdapter(instance, stands, (int) (100 * scale + 0.5f), true);
            rvStands.setAdapter(rslAdapter);

            rvStands.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    };

    @Override
    public void onClick(View v) {

    }
}

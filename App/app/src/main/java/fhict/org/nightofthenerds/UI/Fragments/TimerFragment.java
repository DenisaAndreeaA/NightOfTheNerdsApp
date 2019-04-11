package fhict.org.nightofthenerds.UI.Fragments;


import android.graphics.BitmapFactory;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Domain.StandDTO;

public class TimerFragment extends Fragment {

    private Integer standId;

    private Long MILLIS_DURATION = 60L * 1000 * 3;
    private Long COUNT_DOWN_INTERVAL = 1000L;

    private List<StandDTO> stands = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //add all the stands
        //society route
        stands.add(new StandDTO(0, "Precious Plastic", getResources().getString(R.string.info_preciousplastic), BitmapFactory.decodeResource(getResources(), R.drawable.social_route_plastic)));
        stands.add(new StandDTO(1, "Emotion Whisperer", getResources().getString(R.string.info_emotionwisperer), BitmapFactory.decodeResource(getResources(), R.drawable.emotiefluisteraar)));
        stands.add(new StandDTO(2, "Future Food Formula", getResources().getString(R.string.info_futurefood), BitmapFactory.decodeResource(getResources(), R.drawable.future_food_formula)));
        stands.add(new StandDTO(3, "Food Game", getResources().getString(R.string.info_foodgame), BitmapFactory.decodeResource(getResources(), R.drawable.food_game)));

        //additional route
        stands.add(new StandDTO(4, "Kunnen we dit maken?", getResources().getString(R.string.info_kunnenweditmaken), BitmapFactory.decodeResource(getResources(), R.drawable.mixed_route_kunnen)));
        stands.add(new StandDTO(5, "Nieuwe Meubels in AR", getResources().getString(R.string.info_meubelAR), BitmapFactory.decodeResource(getResources(), R.drawable.meubels_ar)));
        stands.add(new StandDTO(6, "Refubyshment", getResources().getString(R.string.info_refubyshment), BitmapFactory.decodeResource(getResources(), R.drawable.refubyshment)));
        stands.add(new StandDTO(7, "Games testen in het UX Lab", getResources().getString(R.string.info_gamesUXlab), BitmapFactory.decodeResource(getResources(), R.drawable.gamelab)));

        //creative route
        stands.add(new StandDTO(8, "Dans en animatie combineren", getResources().getString(R.string.info_dansenanimatie), BitmapFactory.decodeResource(getResources(), R.drawable.creative_route_dans)));
        stands.add(new StandDTO(9, "Virtuele Mode", getResources().getString(R.string.info_virtuelemode), BitmapFactory.decodeResource(getResources(), R.drawable.virtuele_mode)));
        stands.add(new StandDTO(10, "Hey Bracelet", getResources().getString(R.string.info_heybracelet), BitmapFactory.decodeResource(getResources(), R.drawable.heybracelet)));
        stands.add(new StandDTO(11, "Smell of Data", getResources().getString(R.string.info_smellofdata), BitmapFactory.decodeResource(getResources(), R.drawable.smell_of_data)));

        //tech route
        stands.add(new StandDTO(12, "De Racebolide van URE", getResources().getString(R.string.info_racebolideURE), BitmapFactory.decodeResource(getResources(), R.drawable.tech_route_raceauto)));
        stands.add(new StandDTO(13, "CyberSecuirity", getResources().getString(R.string.info_cybersecuirity), BitmapFactory.decodeResource(getResources(), R.drawable.cybersecurity_fontys)));
        stands.add(new StandDTO(14, "Robot team Pi/Robot Estelle", getResources().getString(R.string.info_robotpi), BitmapFactory.decodeResource(getResources(), R.drawable.robotestelle)));
        stands.add(new StandDTO(15, "Exoskelet", getResources().getString(R.string.info_exoskelet), BitmapFactory.decodeResource(getResources(), R.drawable.exoskelet)));


        try {
            standId = getArguments().getInt("stand_id");
        }catch (Exception e){
            standId = -1;
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_timer, container, false);
        final TextView tvTimer = rootView.findViewById(R.id.tv_timer);
        final Button btnClaimBadge = rootView.findViewById(R.id.btn_claim_badge);
        TextView tvTitle = rootView.findViewById(R.id.tv_stand_title);
        TextView tvInfo = rootView.findViewById(R.id.tv_stand_info);
        ImageView ivStand = rootView.findViewById(R.id.iv_stand_info);
        btnClaimBadge.setVisibility(View.INVISIBLE);

        if(standId < 0)
        {
            //error
        }

        //get stand info wth standId
        for(StandDTO stand : stands)
        {
            if(stand.getId() == standId)
            {
                //set stand image and text
                ivStand.setImageBitmap(stand.getImage());
                tvTitle.setText(stand.getTitle());
                tvInfo.setText(stand.getInfo());
            }
        }

        //start time
        CountDownTimer countDownTimer = new CountDownTimer(MILLIS_DURATION, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(Long.toString(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                btnClaimBadge.setVisibility(View.VISIBLE);
            }
        }.start(); 

        return rootView;
    }
}

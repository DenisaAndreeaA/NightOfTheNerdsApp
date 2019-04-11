package fhict.org.nightofthenerds.UI.Fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Activities.MainActivity;

public class CheckinCheckoutFragment extends Fragment {

    Button QrscanButton;
    View rootView;
    public CheckinCheckoutFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                          @Nullable Bundle savedInstanceState) {
     rootView = inflater.inflate(R.layout.fragment_check_in_check_out, container, false);
     QrscanButton = (Button)rootView.findViewById(R.id.BtScan);
     return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        QrscanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareAndSwitchFragment();
            }
        });
    }
    private void prepareAndSwitchFragment(){
        QRscanFragment qRscanFragment = new QRscanFragment();
        ((MainActivity)getActivity()).changeFragment(qRscanFragment, false);
    }
}

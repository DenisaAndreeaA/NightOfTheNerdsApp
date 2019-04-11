package fhict.org.nightofthenerds.UI.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Activities.MainActivity;
//import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK;
import static android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT;

public class QRscanFragment extends Fragment {
   // private ZXingScannerView scannerView;
    private static final int MY_REQUEST_CAMERA = 0;
    public QRscanFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentIntegrator scannerIntegrator;
        scannerIntegrator = IntentIntegrator.forSupportFragment(this);
        scannerIntegrator.setPrompt("Scan barcode");
        scannerIntegrator.setCameraId(CAMERA_FACING_BACK);
        scannerIntegrator.setBeepEnabled(false);
        scannerIntegrator.setOrientationLocked(true);
        scannerIntegrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {

            } else {
                Integer output = Integer.valueOf(result.getContents());
                prepareAndSwitchFragment(output);
            }
        }
    }

    private void prepareAndSwitchFragment(int standId){
        TimerFragment timerFragment = new TimerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("stand_id", standId);


        ((MainActivity)getActivity()).changeFragment(timerFragment, false);
    }



}

package fhict.org.nightofthenerds.UI;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.webkit.JavascriptInterface;

import java.util.ArrayList;
import java.util.List;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Activities.MainActivity;
import fhict.org.nightofthenerds.UI.Fragments.CheckinCheckoutFragment;

/**
 * Created by denis on 6/1/2018.
 */

public class OnClickBadge {


//    private FragmentManager fm;
//    private Fragment f;
//
//    public OnClickBadge(FragmentManager fragmentManager, Fragment fragment) {
//        fm = fragmentManager;
//        f = fragment;
//
//    }

    private MainActivity mainActivity;

    public OnClickBadge(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @JavascriptInterface
    public void changeFragment(){
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Class fragmentClass = CheckinCheckoutFragment.class;
                Fragment fragment = null;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                mainActivity.changeFragment(fragment, false);
            }
        });

    }
}

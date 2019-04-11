package fhict.org.nightofthenerds.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import fhict.org.nightofthenerds.R;

/**
 * Created by denis on 5/25/2018.
 */

public class BadgeReceivedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_badge_received, container, false);
        if(getArguments() != null){
            String badgeId = this.getArguments().getString("badge_id");
            ImageView iv_badge = rootview.findViewById(R.id.iv_badge_received);
            try {
                setImageViewPicture(badgeId, iv_badge);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rootview;
    }

    private void setImageViewPicture(String imageId, ImageView imageView){
        String resourceName = "badge_" + imageId;
        Integer imgId = getResources().getIdentifier(resourceName, "drawable", getContext().getPackageName());
        imageView.setImageResource(imgId);
    }
}

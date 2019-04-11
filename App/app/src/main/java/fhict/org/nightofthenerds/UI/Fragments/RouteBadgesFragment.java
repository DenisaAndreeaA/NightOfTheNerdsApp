package fhict.org.nightofthenerds.UI.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Activities.MainActivity;
import fhict.org.nightofthenerds.UI.BadgeList;
import fhict.org.nightofthenerds.UI.Domain.BadgeDTO;
import fhict.org.nightofthenerds.UI.OnClickBadge;


public class RouteBadgesFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_route_badges, container, false);
        WebView wvBadges = view.findViewById(R.id.wvBadges);
        wvBadges.getSettings().setJavaScriptEnabled(true);

        wvBadges.loadUrl("file:///android_asset/badges.html");

        BadgeList<BadgeDTO> badges = new BadgeList<>();
        badges.add(new BadgeDTO(1, false));
        badges.add(new BadgeDTO(2, true));
        badges.add(new BadgeDTO(3, false));
        badges.add(new BadgeDTO(4, true));
        badges.add(new BadgeDTO(5, false));
        wvBadges.addJavascriptInterface(badges, "badgeList");


        wvBadges.addJavascriptInterface(new OnClickBadge((MainActivity) getActivity()), "badgeClick");

        return view;
    }
}

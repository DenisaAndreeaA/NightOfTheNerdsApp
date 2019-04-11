package fhict.org.nightofthenerds.UI.Fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fhict.org.nightofthenerds.UI.Adapters.ViewPagerAdapter;
import fhict.org.nightofthenerds.R;


public class BadgesFragment extends Fragment {
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_badges, container, false);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        ViewPager badge_viewpager = view.findViewById(R.id.badge_viewpager);
        tabLayout = view.findViewById(R.id.pagerNav);
        tabLayout.setupWithViewPager(badge_viewpager);
        badge_viewpager.setAdapter(adapter);

        return view;
    }
}

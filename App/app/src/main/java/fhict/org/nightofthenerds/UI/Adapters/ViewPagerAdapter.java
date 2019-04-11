package fhict.org.nightofthenerds.UI.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fhict.org.nightofthenerds.UI.Fragments.OtherBadgesFragment;
import fhict.org.nightofthenerds.UI.Fragments.RouteBadgesFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    // Tab Titles
    private String tabtitles[] = new String[] { "Route", "Other" };
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open FragmentTab1.java
            case 0:
                RouteBadgesFragment fragmenttab1 = new RouteBadgesFragment();
                return fragmenttab1;

            // Open FragmentTab2.java
            case 1:
                OtherBadgesFragment fragmenttab2 = new OtherBadgesFragment();
                return fragmenttab2;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}

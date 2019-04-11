package fhict.org.nightofthenerds.UI.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fhict.org.nightofthenerds.R;


public class OtherBadgesFragment extends Fragment {
    String[] badgenames = new String[] {
            "Racebolide",
            "Cybersecuirity",
            "Robot Pi/Robot Estelle",
            "Exoskelet",
            "Dans en animatie combineren",
            "Virtuele Mode",
            "Hey Bracelet",
            "Smell of Data",
            "Precious Plastic",
            "Emotion Whisperer",
            "Future Food Formula",
            "Food Game",
            "Kunnen we dit maken?",
            "Nieuwe meubels in AR",
            "Refurbyshment",
            "Games testen in het UX lab"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_other_badges, container, false);
        updateList(view);
        return view;
    }

    private void updateList(View view)
    {
        List<HashMap<String, String>> aList = new ArrayList<>();

        for(int i=0;i<badgenames.length;i++){
            HashMap<String, String> hm = new HashMap();
            hm.put("txt", badgenames[i]);
            hm.put("badge", Integer.toString(R.drawable.ic_android) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "badge","txt" };

        // Ids of views in listview_layout
        int[] to = { R.id.badge,R.id.badgename};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getContext(), aList, R.layout.badge_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView badgeListView = view.findViewById(R.id.badgeListView);

        // Setting the adapter to the listView
        badgeListView.setAdapter(adapter);
    }
}

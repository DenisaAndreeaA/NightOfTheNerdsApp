package fhict.org.nightofthenerds.UI.Domain;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    public ArrayList<String> completedStands;

    public RouteType routeType;

    public User() {
        //Default empty constructor
    }

    public User(RouteType routeType){
        this.routeType = routeType;
        completedStands = new ArrayList<>();
    }

    public User(String stand){
        completedStands = new ArrayList<>();
        completedStands.add(stand);
    }

    public boolean addCompleteStand(String standId){
        for(String id : completedStands){
            if(id == standId){
                return false;
            }
        }
        completedStands.add(standId);
        return true;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("completedStands", completedStands);
        result.put("routeType", routeType);
        return result;
    }
}

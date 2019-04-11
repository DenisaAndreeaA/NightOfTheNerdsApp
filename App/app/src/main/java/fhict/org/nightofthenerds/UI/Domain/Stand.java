package fhict.org.nightofthenerds.UI.Domain;

import java.util.ArrayList;

public class Stand {

    public String standId;

    public ArrayList<User> checkedInUsers;

    public Stand(String standId, ArrayList<User> checkedInUsers) {
        this.standId = standId;
        this.checkedInUsers = checkedInUsers;
    }

    public Stand() {
        //Default constructor
    }
}

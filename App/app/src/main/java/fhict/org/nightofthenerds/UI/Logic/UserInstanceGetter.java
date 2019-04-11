package fhict.org.nightofthenerds.UI.Logic;

import com.google.firebase.auth.FirebaseAuth;

import fhict.org.nightofthenerds.UI.Domain.User;

public class UserInstanceGetter {
    private static User user;

    public static User getUser(){
        if(user == null){
            user = new User(FirebaseAuth.getInstance().getUid());
        }
        return user;
    }

    public static void setUser(User newUser){
        user = newUser;
    }
}

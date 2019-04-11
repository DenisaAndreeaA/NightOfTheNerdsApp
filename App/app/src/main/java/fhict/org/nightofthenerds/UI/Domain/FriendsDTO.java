package fhict.org.nightofthenerds.UI.Domain;

import android.graphics.Bitmap;
import android.widget.Button;

/**
 * Created by denis on 5/31/2018.
 */

public class FriendsDTO {
    private int id;
    private String textName;
    private String textBadges;
    private Bitmap image;

    private int textBackgroundColor;


    public FriendsDTO(int id, String textName, String textBadges, Bitmap image, int textBackgroundColor) {
        this.id = id;
        this.textName = textName;
        this.textBadges = textBadges;
        this.image = image;
        this.textBackgroundColor = textBackgroundColor;
    }

    public int getId() {
        return id;
    }


    public String getTextName() {
        return textName;
    }

    public String getTextBadges() {
        return textBadges;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getTextBackgroundColor() {
        return textBackgroundColor;
    }
}

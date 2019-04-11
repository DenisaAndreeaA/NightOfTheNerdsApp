package fhict.org.nightofthenerds.UI.Domain;

import android.graphics.Bitmap;
import android.graphics.Color;

public class RouteStandDTO {

    public final static int ROUTE = 0, STAND_ODD = 1, STAND_EVEN = 2;

    private int id;
    private String text;
    private Bitmap image;
    private int textBackgroundColor;

    private int routeOrStand;

    public RouteStandDTO(int id, String text, int textBackgroundColor, Bitmap image, int routeOrStand) {
        this.id = id;
        this.text = text;
        this.textBackgroundColor = textBackgroundColor;
        this.image = image;
        this.routeOrStand = routeOrStand;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getTextBackgroundColor() {
        return textBackgroundColor;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getRouteOrStand() {
        return this.routeOrStand;
    }
}

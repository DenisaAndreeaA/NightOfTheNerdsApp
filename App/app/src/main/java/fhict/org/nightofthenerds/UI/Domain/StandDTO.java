package fhict.org.nightofthenerds.UI.Domain;

import android.graphics.Bitmap;

public class StandDTO {
    private int id;
    private String title;
    private String info;
    private Bitmap image;

    public StandDTO(int id, String title, String info, Bitmap image)
    {
        this.id = id;
        this.title = title;
        this.info = info;
        this.image = image;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getInfo()
    {
        return info;
    }

    public Bitmap getImage()
    {
        return image;
    }
}

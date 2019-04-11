package fhict.org.nightofthenerds.UI.Domain;

import android.webkit.JavascriptInterface;

/**
 * Created by denis on 6/1/2018.
 */

public class BadgeDTO {
    @JavascriptInterface
    public int getBadgeID() {
        return badgeID;
    }

    @JavascriptInterface
    public boolean isBadgeEnable() {
        return badgeEnable;
    }

    private int badgeID;
    private boolean badgeEnable;

    public BadgeDTO(int badgeID, boolean badgeEnable) {
        this.badgeID = badgeID;
        this.badgeEnable = badgeEnable;
    }

}

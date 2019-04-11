package fhict.org.nightofthenerds.UI.ViewHolders;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fhict.org.nightofthenerds.R;

/**
 * Created by denis on 5/31/2018.
 */

public class BattleFriendsListViewHolder extends RecyclerView.ViewHolder {

    private TextView tvFriendName;
    private TextView tvBadgesNumber;
    private AppCompatImageView ivFriendProfileImage;


    public BattleFriendsListViewHolder(View itemView) {
        super(itemView);
        tvBadgesNumber = itemView.findViewById(R.id.tvBadgesNumber);
        tvFriendName = itemView.findViewById(R.id.tvFriendName);
        ivFriendProfileImage = itemView.findViewById(R.id.ivFriendProfileImage);
    }


    public TextView getTvFriendName() {
        return tvFriendName;
    }

    public TextView getTvBadgesNumber() {
        return tvBadgesNumber;
    }

    public AppCompatImageView getIvFriendProfileImage() {
        return ivFriendProfileImage;
    }



}

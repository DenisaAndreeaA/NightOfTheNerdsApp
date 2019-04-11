package fhict.org.nightofthenerds.UI.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Domain.FriendsDTO;
import fhict.org.nightofthenerds.UI.Domain.RouteStandDTO;
import fhict.org.nightofthenerds.UI.ViewHolders.BattleFriendsListViewHolder;
import fhict.org.nightofthenerds.UI.ViewHolders.RouteStandListViewHolder;

/**
 * Created by denis on 5/31/2018.
 */

public class FriendsAdapter extends RecyclerView.Adapter<BattleFriendsListViewHolder>{


    private final List<FriendsDTO> friends;
    private final View.OnClickListener context;

    public FriendsAdapter(View.OnClickListener context, List<FriendsDTO> friends) {
        this.context = context;
        this.friends = friends;
    }


    @NonNull
    @Override
    public BattleFriendsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.friends_list, parent, false);

        int height = parent.getMeasuredHeight() / getItemCount();
        view.setLayoutParams(new RecyclerView.LayoutParams(parent.getWidth(), height));
        view.setOnClickListener(context);
        return new BattleFriendsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BattleFriendsListViewHolder holder, int position) {
        FriendsDTO friendsDto = friends.get(position);
        holder.getTvBadgesNumber().setText(friendsDto.getTextBadges());
        holder.getTvFriendName().setText(friendsDto.getTextName());
        holder.getTvFriendName().setBackgroundColor(friendsDto.getTextBackgroundColor());
        holder.getTvBadgesNumber().setBackgroundColor(friendsDto.getTextBackgroundColor());
        holder.getIvFriendProfileImage().setImageBitmap(friendsDto.getImage());

    }



    @Override
    public int getItemCount() {
        return friends.size();
    }
}

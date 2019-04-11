package fhict.org.nightofthenerds.UI.ViewHolders;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fhict.org.nightofthenerds.R;

public class RouteStandListViewHolder extends RecyclerView.ViewHolder {

    private TextView tvRouteStandTitle;
    private AppCompatImageView ivRouteStandImage;

    public RouteStandListViewHolder(View itemView) {
        super(itemView);
        tvRouteStandTitle = itemView.findViewById(R.id.tvRouteStandTitle);
        ivRouteStandImage = itemView.findViewById(R.id.ivRouteStandImage);
    }

    public TextView getTvRouteStandTitle() {
        return tvRouteStandTitle;
    }

    public AppCompatImageView getIvRouteStandImage() {
        return ivRouteStandImage;
    }
}

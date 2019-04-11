package fhict.org.nightofthenerds.UI.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fhict.org.nightofthenerds.R;
import fhict.org.nightofthenerds.UI.Domain.RouteStandDTO;
import fhict.org.nightofthenerds.UI.ViewHolders.RouteStandListViewHolder;

public class RouteStandListAdapter extends RecyclerView.Adapter<RouteStandListViewHolder>{

    private final List<RouteStandDTO> routeStands;
    private final View.OnClickListener onClickListener;
    private final boolean tryToFit;
    private int rowHeight;


    public RouteStandListAdapter(View.OnClickListener onClickListener, List<RouteStandDTO> routeStands, int rowHeight, boolean tryToFit) {
        this.onClickListener = onClickListener;
        this.routeStands = routeStands;
        this.rowHeight = rowHeight;
        this.tryToFit = tryToFit;
    }

    @Override
    public int getItemViewType(int position) {
        RouteStandDTO rsDto = routeStands.get(position);
        return rsDto.getRouteOrStand();
    }

    @NonNull
    @Override
    public RouteStandListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;

        switch (viewType) {
            case RouteStandDTO.ROUTE: {
                view = inflater.inflate(R.layout.route_list, parent, false);
                break;
            }
            case RouteStandDTO.STAND_ODD: {
                view = inflater.inflate(R.layout.stands_list_odd, parent, false);
                break;
            }
            default: {
                view = inflater.inflate(R.layout.stands_list, parent, false);
                break;
            }
        }

        if(tryToFit && getItemCount() < 6) {
            rowHeight = parent.getMeasuredHeight() / getItemCount();
        }
        view.setLayoutParams(new RecyclerView.LayoutParams(parent.getWidth(), rowHeight));
        view.setOnClickListener(onClickListener);
        return new RouteStandListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteStandListViewHolder holder, int position) {
        RouteStandDTO rsDto = routeStands.get(position);
        holder.getTvRouteStandTitle().setText(rsDto.getText());
        holder.getTvRouteStandTitle().setBackgroundColor(rsDto.getTextBackgroundColor());
        holder.getIvRouteStandImage().setImageBitmap(rsDto.getImage());
    }

    @Override
    public int getItemCount() {
        return routeStands.size();
    }
}

package re.out.sarobmed.sarobmed.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import re.out.sarobmed.sarobmed.HelperModels.ShipActor;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.R;

public class ShipActorAdapter extends RecyclerView.Adapter<ShipActorAdapter.ViewHolder> {

    private List<ShipActor> shipActorsList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView hull;
        TextView flag;
        ImageView delete;

        public ViewHolder(View view) {
            super(view);
            hull = view.findViewById(R.id.rc_shipDialog_hull);
            flag = view.findViewById(R.id.rc_shipDialog_flag);
            delete = view.findViewById(R.id.rc_shipDialog_delete);
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Ship Actor Removed!", Toast.LENGTH_SHORT).show();
            shipActorsList.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
        }
    }


    public ShipActorAdapter(List<ShipActor> shipActors, Context context) {
        this.shipActorsList = shipActors;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rc_shipactor, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ShipActor actor = shipActorsList.get(position);

        holder.hull.setText(actor.getHullNumber());
        holder.flag.setText(actor.getFlag());

    }

    @Override
    public int getItemCount() {
        return shipActorsList.size();
    }
}


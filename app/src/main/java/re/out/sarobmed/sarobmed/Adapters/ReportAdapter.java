package re.out.sarobmed.sarobmed.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.R;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {

    private List<ReportMinimal> reportMinimalList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        TextView location;
        ConstraintLayout layout;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.rc_report_title);
            date = view.findViewById(R.id.rc_report_date);
            location = view.findViewById(R.id.rc_report_location);
            layout = view.findViewById(R.id.rc_report_layout);
        }
    }


    public ReportAdapter(List<ReportMinimal> reportMinimalList, Context context) {
        this.reportMinimalList = reportMinimalList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rc_report, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ReportMinimal report = reportMinimalList.get(position);

        if(report.getShortTitle() != null && !report.getShortTitle().isEmpty()){
            holder.title.setText(report.getShortTitle());
        }else{
            holder.title.setText(context.getString(R.string.short_title_not_set));
        }
        if(report.getLocationDescription() != null && report.getLocationDescription().size() > 0){
            holder.location.setText(report.getLocationDescription().get(0));
        }else{
            holder.location.setText(context.getString(R.string.location_not_set));
        }

        if(report.getDateOfMission() != null){
            Date dateOfMission = report.getDateOfMission();
            SimpleDateFormat spf= new SimpleDateFormat("dd/MMM/yyyy");
            spf.setTimeZone(TimeZone.getTimeZone("UTC"));
            String date = spf.format(dateOfMission);
            holder.date.setText(date);
        }

    }

    @Override
    public long getItemId(int position) {
        return reportMinimalList.get(position).getUID();
    }

    @Override
    public int getItemCount() {
        return reportMinimalList.size();
    }

    public void swap(List<ReportMinimal> newData){
        if(newData != null){
            reportMinimalList.clear();
            reportMinimalList.addAll(newData);
            notifyDataSetChanged();
        }
    }
}


package re.out.sarobmed.sarobmed.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import androidx.annotation.NonNull;
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

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.rc_report_title);
            date = view.findViewById(R.id.rc_report_date);
            location = view.findViewById(R.id.rc_report_location);
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

        if(report.getShortTitle() != null){
            holder.title.setText(report.getShortTitle());
        }
        if(report.getLocationDescription() != null){
            holder.location.setText(report.getLocationDescription().get(0));
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


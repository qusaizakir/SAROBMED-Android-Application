package re.out.sarobmed.sarobmed.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {

    private List<Report> reportList;

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


    public ReportAdapter(List<Report> reportList) {
        this.reportList = reportList;
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
        final Report report = reportList.get(position);

        holder.title.setText(report.getReporterDetails().getOrganisation());
        holder.location.setText(report.getReporterDetails().getReporter());
        holder.date.setText(report.getReporterDetails().getReporter());
    }

    @Override
    public long getItemId(int position) {
        return reportList.get(position).getUID();
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }
}


package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.Activities.EditFormActivity;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;

public class EditFormReporterDetailsFragment extends FormReporterDetailsFragment {

    private Context context;
    private Report report;

    public EditFormReporterDetailsFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        report = ((EditFormActivity)context).reportToEdit;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        fillReports();
    }

    private void fillReports(){
        super.reporter.setText(report.getReporter());
        super.organisation.setText(report.getOrganisation());
    }

    @Override
    public void saveToReport(){
        report.setReporter(reporter.getText().toString());
        report.setOrganisation(organisation.getText().toString());

        ((EditFormActivity)context).updateReport();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }
}

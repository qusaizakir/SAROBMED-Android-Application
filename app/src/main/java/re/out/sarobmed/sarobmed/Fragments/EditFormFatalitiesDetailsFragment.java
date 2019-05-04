package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.Activities.EditFormActivity;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;

public class EditFormFatalitiesDetailsFragment extends FormFatalitiesDetailsFragment{

    private Context context;
    private Report report;

    public EditFormFatalitiesDetailsFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        report = ((EditFormActivity)context).reportToEdit;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        fillReports();
    }

    private void fillReports(){
        super.totConfirmDead.setText(report.getTotConfirmDead() + "");
        super.totEstimateDeadMissing.setText(report.getTotEstimateDeadMissing() + "");
        super.deadPrior.setText(report.getDeadPrior()+ "");
        super.deadDuring.setText(report.getDeadDuring()+ "");
        super.deadAfter.setText(report.getDeadAfter()+ "");
    }

    @Override
    public void saveToReport(){
        int totConfirmDeadInt =0;
        try{
            totConfirmDeadInt = Integer.parseInt(totConfirmDead.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }

        int totEstimateDeadMissingInt =0;
        try{
            totEstimateDeadMissingInt = Integer.parseInt(totEstimateDeadMissing.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }

        int deadPriorInt =0;
        try{
            deadPriorInt = Integer.parseInt(deadPrior.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }

        int deadDuringInt =0;
        try{
            deadDuringInt = Integer.parseInt(deadDuring.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }

        int deadAfterInt =0;
        try{
            deadAfterInt = Integer.parseInt(deadAfter.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }

        report.setTotConfirmDead(totConfirmDeadInt);
        report.setTotEstimateDeadMissing(totEstimateDeadMissingInt);
        report.setDeadPrior(deadPriorInt);
        report.setDeadDuring(deadDuringInt);
        report.setDeadAfter(deadAfterInt);

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

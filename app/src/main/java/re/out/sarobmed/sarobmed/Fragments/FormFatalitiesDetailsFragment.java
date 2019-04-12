package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;

public class FormFatalitiesDetailsFragment extends Fragment {

    private FormFatalitiesDetailsListener mListener;
    private Context context;
    private EditText totConfirmDead;
    private EditText totEstimateDeadMissing;
    private EditText deadPrior;
    private EditText deadDuring;
    private EditText deadAfter;

    public FormFatalitiesDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form_fatalities_details, container, false);
        setHasOptionsMenu(true);
        mListener.setupFormFatalitiesToolbar();
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        totConfirmDead = v.findViewById(R.id.edit_totConfirmDead);
        totEstimateDeadMissing = v.findViewById(R.id.edit_totEstimateDeadMissing);
        deadPrior = v.findViewById(R.id.edit_deadPrior);
        deadDuring = v.findViewById(R.id.edit_deadDuring);
        deadAfter = v.findViewById(R.id.edit_deadAfter);
    }

    public void saveToReport(){
        Report report = ((AddFormActivity)context).report;

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

        ((AddFormActivity)context).updateReport();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof FormFatalitiesDetailsListener) {
            mListener = (FormFatalitiesDetailsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FormFatalitiesDetailsListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface FormFatalitiesDetailsListener {
        void setupFormFatalitiesToolbar();
    }
}

package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.HelperModels.SetAutoComplete;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;


public class FormReporterDetailsFragment extends Fragment {

    private Context context;
    private FormReporterDetailsListener mListener;

    protected EditText reporter;
    protected AutoCompleteTextView organisation;

    public FormReporterDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form_reporter_details, container, false);

        setHasOptionsMenu(true);
        mListener.setupFormReporterToolbar();
        initViews(v);
        setupAutoComplete();

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                ((AppCompatActivity)context).onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void saveToReport() {
        Report report = ((AddFormActivity)context).report;

        report.setReporter(reporter.getText().toString());
        report.setOrganisation(organisation.getText().toString());

        ((AddFormActivity)context).updateReport();
    }

    private void initViews(View v) {
        reporter = v.findViewById(R.id.edit_reporter);
        organisation = v.findViewById(R.id.edit_organisation);

    }

    private void setupAutoComplete() {
        SetAutoComplete organisationAuto = new SetAutoComplete(organisation, R.array.organisation, context);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof FormReporterDetailsListener) {
            mListener = (FormReporterDetailsListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface FormReporterDetailsListener {
        void setupFormReporterToolbar();
    }
}

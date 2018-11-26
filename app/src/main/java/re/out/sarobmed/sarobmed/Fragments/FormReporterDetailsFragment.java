package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;


public class FormReporterDetailsFragment extends Fragment {

    private Context context;
    private FormReporterDetailsListener mListener;

    private EditText editReporter;
    private AutoCompleteTextView editOrganisation;

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
        setupEditTexts();

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

        report.setReporter(editReporter.getText().toString());
        report.setOrganisation(editOrganisation.getText().toString());

        ((AddFormActivity)context).updateReport();
    }

    private void initViews(View v) {
        editReporter = v.findViewById(R.id.edit_reporter);
        editOrganisation = v.findViewById(R.id.edit_organisation);

    }

    private void setupEditTexts() {

        String[] organisationArray = getResources().getStringArray(R.array.organisation);
        ArrayAdapter<String> editOrganisationAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_dropdown_item_1line, organisationArray);
        editOrganisation.setAdapter(editOrganisationAdapter);

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

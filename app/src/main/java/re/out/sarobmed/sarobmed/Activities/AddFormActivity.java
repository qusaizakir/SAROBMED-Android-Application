package re.out.sarobmed.sarobmed.Activities;


import android.os.Bundle;
import android.util.Log;

import com.google.android.material.appbar.AppBarLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import re.out.sarobmed.sarobmed.Fragments.FormIncidentDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.FormPickerFragment;
import re.out.sarobmed.sarobmed.Fragments.FormReporterDetailsFragment;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;
import re.out.sarobmed.sarobmed.ViewModels.AddFormViewModel;

public class AddFormActivity extends AppCompatActivity implements
        FormPickerFragment.FormPickerFragmentListener, FormReporterDetailsFragment.FormReporterDetailsListener,
        FormIncidentDetailsFragment.FormIncidentDetailsListener {

    //Final Static Variables to identify Fragments
    public final static int PICKER = 2;
    public final static int REPORTER = 0;
    public final static int LOCATION = 1;
    public final static int INCIDENT = 3;
    public Report report = new Report();

    //Variable for fragment management
    final FragmentManager fm = getSupportFragmentManager();
    final FormPickerFragment formPickerFragment = new FormPickerFragment();
    final FormReporterDetailsFragment formReporterDetailsFragment = new FormReporterDetailsFragment();
    final FormIncidentDetailsFragment formIncidentDetailsFragment = new FormIncidentDetailsFragment();

    //Variables for views
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    AddFormViewModel model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);

        //Initialise all views
        initViews();
        setupToolbar();

        //Set initial fragment as the pickerFragement
        fm.beginTransaction().add(R.id.addform_container, formPickerFragment, "sync").commit();

        model = ViewModelProviders.of(this).get(AddFormViewModel.class);
        //Set UID as current epoch time
        report.setUID(System.currentTimeMillis());
        model.insertReport(report);

    }

    @Override
    public void onBackPressed() {
        if(formReporterDetailsFragment.isVisible()){
            formReporterDetailsFragment.saveToReport();
        }
        if(formIncidentDetailsFragment.isVisible()){
            formIncidentDetailsFragment.saveToReport();
        }

        //TODO ADD the rest of fragements here as well
        super.onBackPressed();
    }

    private void initViews() {
        appBarLayout = findViewById(R.id.addform_appbarlayout);
        toolbar = findViewById(R.id.addform_toolbar);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

    }

    public void updateReport(){
        Log.d("SAVETOREPORTUID", report.getUID() + "");
        Log.d("SAVETOREPORTreporter", report.getReporter());
        Log.d("SAVETOREPORTorgan", report.getOrganisation());
        model.updateReport(report);
    }

    @Override
    public void openFragment(int fragment) {

        switch(fragment){
            case REPORTER:
                fm.beginTransaction().replace(R.id.addform_container, formReporterDetailsFragment).addToBackStack(null).commit();
                break;
            case LOCATION:
                //fm.beginTransaction().replace(R.id.addform_container, formReporterDetailsFragment).commit();
                break;
            case INCIDENT:
                fm.beginTransaction().replace(R.id.addform_container, formIncidentDetailsFragment).addToBackStack(null).commit();
                break;
        }

    }

    @Override
    public void setupFormPickerToolbar() {
            if(getSupportActionBar() != null){
                getSupportActionBar().setTitle(getString(R.string.form_picker_title));
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24px);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

    @Override
    public void setupFormReporterToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.reporter_details_title));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setupFormIncidentToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.incident_details_title));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}

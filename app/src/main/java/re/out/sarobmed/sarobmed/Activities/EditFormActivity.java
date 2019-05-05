package re.out.sarobmed.sarobmed.Activities;


import android.os.Bundle;
import android.util.Log;

import com.google.android.material.appbar.AppBarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import re.out.sarobmed.sarobmed.Fragments.EditFormActorDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.EditFormFatalitiesDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.EditFormReporterDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.FormActorDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.FormFatalitiesDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.FormIncidentDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.FormLocationDetailsFragment;
import re.out.sarobmed.sarobmed.Fragments.FormPickerFragment;
import re.out.sarobmed.sarobmed.Fragments.FormReporterDetailsFragment;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;
import re.out.sarobmed.sarobmed.ViewModels.AddFormViewModel;

public class EditFormActivity extends AppCompatActivity implements
        FormPickerFragment.FormPickerFragmentListener, FormReporterDetailsFragment.FormReporterDetailsListener,
        FormIncidentDetailsFragment.FormIncidentDetailsListener, FormLocationDetailsFragment.FormLocationDetailsListener,
        FormActorDetailsFragment.FormActorDetailsListener, FormFatalitiesDetailsFragment.FormFatalitiesDetailsListener {

    //Final Static Variables to identify Fragments
    public final static int REPORTER = 0;
    public final static int LOCATION = 1;
    public final static int INCIDENT = 3;
    public final static int ACTOR = 4;
    public final static int FATALITIES = 5;
    public Report reportToEdit;
    private long UID;

    //Variable for fragment management
    final FragmentManager fm = getSupportFragmentManager();
    final FormPickerFragment formPickerFragment = new FormPickerFragment();
    final EditFormReporterDetailsFragment editFormReporterDetailsFragment = new EditFormReporterDetailsFragment();
    final FormIncidentDetailsFragment formIncidentDetailsFragment = new FormIncidentDetailsFragment();
    final FormLocationDetailsFragment formLocationDetailsFragment = new FormLocationDetailsFragment();
    final EditFormActorDetailsFragment editFormActorDetailsFragment = new EditFormActorDetailsFragment();
    final EditFormFatalitiesDetailsFragment editFormFatalitiesDetailsFragment = new EditFormFatalitiesDetailsFragment();

    //Variables for views
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    AddFormViewModel model;

    private boolean exit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        UID = getIntent().getLongExtra("UID", -1);
        Log.d("UID OF REPORT", UID + "");


        //Initialise all views
        initViews();
        setupToolbar();

        //Set initial fragment as the pickerFragement
        fm.beginTransaction().add(R.id.addform_container, formPickerFragment, "sync").commit();

        model = ViewModelProviders.of(this).get(AddFormViewModel.class);
        createObservers();

    }

    private void createObservers() {
        model.getReportByID(UID).observe(this, new Observer<Report>() {
            @Override
            public void onChanged(Report report) {
                if(report != null){
                    reportToEdit = report;
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(formPickerFragment.isVisible()){
            if(exit){
                finish();
            }else {
                //exitConfirmDialog();
            }
        }else if(editFormReporterDetailsFragment.isVisible()){
            editFormReporterDetailsFragment.saveToReport();
            super.onBackPressed();
        }else if(formIncidentDetailsFragment.isVisible()){
            formIncidentDetailsFragment.saveToReport();
            super.onBackPressed();
        }else if(formLocationDetailsFragment.isVisible()){
            formLocationDetailsFragment.saveToReport();
            super.onBackPressed();
        }else if(editFormActorDetailsFragment.isVisible()){
            editFormActorDetailsFragment.saveToReport();
            super.onBackPressed();
        }else if(editFormFatalitiesDetailsFragment.isVisible()){
            editFormFatalitiesDetailsFragment.saveToReport();
            super.onBackPressed();
        }

    }

    private void initViews() {
        appBarLayout = findViewById(R.id.addform_appbarlayout);
        toolbar = findViewById(R.id.addform_toolbar);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

    }

    public void updateReport(){

        model.updateReport(reportToEdit);
    }

    @Override
    public void openFragment(int fragment) {

        switch(fragment){
            case REPORTER:
                fm.beginTransaction().replace(R.id.addform_container, editFormReporterDetailsFragment).addToBackStack(null).commit();
                break;
            case LOCATION:
                //fm.beginTransaction().replace(R.id.addform_container, formLocationDetailsFragment).addToBackStack(null).commit();
                break;
            case INCIDENT:
                //fm.beginTransaction().replace(R.id.addform_container, formIncidentDetailsFragment).addToBackStack(null).commit();
                break;
            case ACTOR:
                fm.beginTransaction().replace(R.id.addform_container, editFormActorDetailsFragment).addToBackStack(null).commit();
                break;
            case FATALITIES:
                fm.beginTransaction().replace(R.id.addform_container, editFormFatalitiesDetailsFragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void setupFormPickerToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.edit_sar_title));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
            //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24px);
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

    @Override
    public void setupFormLocationToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.location_details_title));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setupFormActorToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.actor_details));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setupFormFatalitiesToolbar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.fatalities_details));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}

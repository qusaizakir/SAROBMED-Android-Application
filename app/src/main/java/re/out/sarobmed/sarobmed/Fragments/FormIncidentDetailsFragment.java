package re.out.sarobmed.sarobmed.Fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.HelperModels.SetAutoComplete;
import re.out.sarobmed.sarobmed.HelperModels.SetDate;
import re.out.sarobmed.sarobmed.HelperModels.SetTime;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;


public class FormIncidentDetailsFragment extends Fragment {

    private Context context;
    private FormIncidentDetailsListener mListener;

    private EditText shortTitle;

    private EditText dateOfMisson;
    private SetDate dateOfMissionDate;
    private EditText timeOfFirstInfoGet;
    private SetTime timeOfFirstInfoGetTime;
    private EditText startTimeOfFirstSighting;
    private SetTime startTimeOfFirstSightingTime;
    private EditText endTimeOfMission;
    private SetTime endTimeOfMissionTime;

    private EditText missionDesc;
    private AutoCompleteTextView SARAsset;
    private EditText migrantNoOfBoats;
    private EditText migrantTypeOfBoats;
    private EditText migrantConditionOfBoats;
    private EditText migrantBoatIdentifiers;
    private EditText migrantNoOfPeoplePerBoat;
    private EditText seaAndWeatherConditions;
    private EditText otherVesselsInVicinity;


    public FormIncidentDetailsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form_incident_details, container, false);
        setHasOptionsMenu(true);
        mListener.setupFormIncidentToolbar();
        initViews(v);
        setUpTimeAndDate();
        setUpAutoComplete();
        return v;
    }

    private void setUpTimeAndDate() {
        timeOfFirstInfoGetTime = new SetTime(timeOfFirstInfoGet, this.context);
        dateOfMissionDate = new SetDate(dateOfMisson, this.context);
        startTimeOfFirstSightingTime = new SetTime(startTimeOfFirstSighting, this.context);
        endTimeOfMissionTime = new SetTime(endTimeOfMission, this.context);
    }

    private void setUpAutoComplete() {
        SetAutoComplete SARAssetAuto = new SetAutoComplete(SARAsset, R.array.sarAsset, this.context);
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

    private void initViews(View v) {
        shortTitle = v.findViewById(R.id.edit_shortTitle);
        dateOfMisson = v.findViewById(R.id.edit_dateOfMission);
        timeOfFirstInfoGet = v.findViewById(R.id.edit_timeOfFirstInfoGet);
        startTimeOfFirstSighting = v.findViewById(R.id.edit_startTimeOfFirstSighting);
        endTimeOfMission = v.findViewById(R.id.edit_endTimeOfMission);
        missionDesc = v.findViewById(R.id.edit_missionDesc);
        SARAsset = v.findViewById(R.id.edit_SARAsset);
        migrantNoOfBoats = v.findViewById(R.id.edit_migrantNoOfBoats);
        migrantTypeOfBoats = v.findViewById(R.id.edit_migrantTypeOfBoats);
        migrantConditionOfBoats = v.findViewById(R.id.edit_migrantConditionOfBoats);
        migrantBoatIdentifiers = v.findViewById(R.id.edit_migrantBoatIdentifiers);
        migrantNoOfPeoplePerBoat = v.findViewById(R.id.edit_migrantNoOfPeoplePerBoat);
        seaAndWeatherConditions = v.findViewById(R.id.edit_seaAndWeatherConditions);
        otherVesselsInVicinity = v.findViewById(R.id.edit_otherVesselsInVicinity);
    }

    public void saveToReport() {
        Report report = ((AddFormActivity)context).report;

        report.setShortTitle(shortTitle.getText().toString());
        report.setDateOfMission(dateOfMissionDate.getCalendarDate());
        report.setTimeOfFirstInfoGet(timeOfFirstInfoGetTime.getCalendarDate());
        report.setStartTimeOfFirstSighting(startTimeOfFirstSightingTime.getCalendarDate());
        report.setEndTimeOfMission(endTimeOfMissionTime.getCalendarDate());
        report.setMissionDesc(missionDesc.getText().toString());
        report.setSARAsset(SARAsset.getText().toString());
        report.setMigrantNoOfBoats(Integer.parseInt(migrantNoOfBoats.getText().toString()));
        report.setMigrantTypeOfBoats(migrantTypeOfBoats.getText().toString());
        report.setMigrantConditionOfBoats(migrantConditionOfBoats.getText().toString());
        report.setMigrantBoatIdentifiers(migrantBoatIdentifiers.getText().toString());
        report.setMigrantNoOfPeoplePerBoat(Integer.parseInt(migrantNoOfPeoplePerBoat.getText().toString()));
        report.setSeaAndWeatherConditions(seaAndWeatherConditions.getText().toString());
        report.setOtherVesselsInVicinity(otherVesselsInVicinity.getText().toString());

        ((AddFormActivity)context).updateReport();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof FormIncidentDetailsListener) {
            mListener = (FormIncidentDetailsListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface FormIncidentDetailsListener {
        void setupFormIncidentToolbar();
    }
}

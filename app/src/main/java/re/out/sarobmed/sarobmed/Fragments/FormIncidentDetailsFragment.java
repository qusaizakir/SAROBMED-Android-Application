package re.out.sarobmed.sarobmed.Fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import re.out.sarobmed.sarobmed.HelperModels.DialogCheckbox;
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
    private AutoCompleteTextView sourceOFFirstInfo;

    private EditText mediaOfCommunication;
    private DialogCheckbox mediaOfCommunicationDialog;
    private EditText meansOfBoatDetection;
    private DialogCheckbox meansOfBoatDetectionDialog;
    private EditText supportingEvidence;
    private DialogCheckbox supportingEvidenceDialog;

    private EditText coordOnScene;
    private EditText coordOverall;
    private EditText coordOrdersToSARVessel;

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
        setUpDialogs();
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
        SetAutoComplete SourceOFFirstInfo = new SetAutoComplete(sourceOFFirstInfo, R.array.sourceFirstInfo, this.context);
    }

    private void setUpDialogs() {
        String mediaOfCommTitle = getResources().getString(R.string.edit_mediaOfCommunication_hint);
        mediaOfCommunicationDialog = new DialogCheckbox(mediaOfCommunication,mediaOfCommTitle, R.array.mediaOfComm, this.context);

        String meansOfBoatTitle = context.getResources().getString(R.string.edit_meansOfBoatDetection_hint);
        meansOfBoatDetectionDialog = new DialogCheckbox(meansOfBoatDetection, meansOfBoatTitle, R.array.meansOfBoatDetection, this.context);

        String supportTitle = context.getResources().getString(R.string.edit_supportingEvidence_hint);
        supportingEvidenceDialog = new DialogCheckbox(supportingEvidence, supportTitle, R.array.supportingEvidence, this.context);
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
        sourceOFFirstInfo = v.findViewById(R.id.edit_sourceOfFirstInfo);
        mediaOfCommunication = v.findViewById(R.id.edit_mediaOfCommunication);
        meansOfBoatDetection = v.findViewById(R.id.edit_meansOfBoatDetection);
        coordOnScene = v.findViewById(R.id.edit_coordOnScene);
        coordOverall = v.findViewById(R.id.edit_coordOverall);
        coordOrdersToSARVessel = v.findViewById(R.id.edit_coordOrderToSARVessel);
        supportingEvidence = v.findViewById(R.id.edit_supportingEvidence);

    }

    public void saveToReport() {
        Report report = ((AddFormActivity)context).report;

        //Parse Int
        int migNo=0;
        try{
            migNo = Integer.parseInt(migrantNoOfBoats.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }
        report.setMigrantNoOfBoats(migNo);
        //Parse Int
        int migPer=0;
        try{
            migPer = Integer.parseInt(migrantNoOfPeoplePerBoat.getText().toString());
        }catch (NumberFormatException e){
            //Not a number
        }
        report.setMigrantNoOfPeoplePerBoat(migPer);

        report.setShortTitle(shortTitle.getText().toString());
        report.setDateOfMission(dateOfMissionDate.getCalendarDate());
        report.setTimeOfFirstInfoGet(timeOfFirstInfoGetTime.getCalendarDate());
        report.setStartTimeOfFirstSighting(startTimeOfFirstSightingTime.getCalendarDate());
        report.setEndTimeOfMission(endTimeOfMissionTime.getCalendarDate());
        report.setMissionDesc(missionDesc.getText().toString());
        report.setSARAsset(SARAsset.getText().toString());
        report.setMigrantTypeOfBoats(migrantTypeOfBoats.getText().toString());
        report.setMigrantConditionOfBoats(migrantConditionOfBoats.getText().toString());
        report.setMigrantBoatIdentifiers(migrantBoatIdentifiers.getText().toString());
        report.setSeaAndWeatherConditions(seaAndWeatherConditions.getText().toString());
        report.setOtherVesselsInVicinity(otherVesselsInVicinity.getText().toString());
        report.setSourceOfFirstInfo(sourceOFFirstInfo.getText().toString());
        report.setMediaOfCommunication(mediaOfCommunicationDialog.getResults());
        report.setMeansOfBoatDetection(meansOfBoatDetectionDialog.getResults());
        report.setCoordOnScene(coordOnScene.getText().toString());
        report.setCoordOverall(coordOverall.getText().toString());
        report.setCoordOrdersToSARVessel(coordOrdersToSARVessel.getText().toString());
        report.setSupportingEvidence(supportingEvidenceDialog.getResults());

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

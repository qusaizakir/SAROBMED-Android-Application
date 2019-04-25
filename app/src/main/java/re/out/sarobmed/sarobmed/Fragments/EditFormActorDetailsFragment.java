package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.Activities.EditFormActivity;
import re.out.sarobmed.sarobmed.HelperModels.AssetDialogCheckbox;
import re.out.sarobmed.sarobmed.HelperModels.DialogCheckbox;
import re.out.sarobmed.sarobmed.HelperModels.InterferenceDialogCheckbox;
import re.out.sarobmed.sarobmed.HelperModels.ShipActorDialog;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;


public class EditFormActorDetailsFragment extends FormActorDetailsFragment {

    private Context context;

    private EditText shipActors;
    private ShipActorDialog shipActorDialog;
    private EditText assetActors;
    private AssetDialogCheckbox assetDialogCheckbox;
    private EditText intimidation;
    private DialogCheckbox intimidationDialog;
    private EditText interference;
    private InterferenceDialogCheckbox interferenceDialog;
    private EditText actionAgainstSurvivors;
    private DialogCheckbox actionAgainstSurvivorsDialog;
    private EditText actionAgainstNGO;
    private DialogCheckbox actionAgainstNGODialog;

    private Report report;

    public EditFormActorDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        report = ((EditFormActivity)context).reportToEdit;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //fillReport();
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    protected void setupDialogs(){
        super.shipActorDialog = new ShipActorDialog(super.shipActors, context, report.getShipActors());
        super.assetDialogCheckbox = new AssetDialogCheckbox(super.assetActors, getString(R.string.byassetActors), R.array.assetActors, this.context, report.getAssetActors());
        super.intimidationDialog = new DialogCheckbox(super.intimidation, getString(R.string.intimidation), R.array.intimidation, this.context, report.getIntimidation());
        super.interferenceDialog = new InterferenceDialogCheckbox(super.interference, getString(R.string.direct_interference_with_rescue), this.context, report.getInterference());
        super.actionAgainstSurvivorsDialog = new DialogCheckbox(super.actionAgainstSurvivors, getString(R.string.action_against_survivors), R.array.actionSurvivors, this.context, report.getActionAgainstSurvivors());
        super.actionAgainstNGODialog = new DialogCheckbox(super.actionAgainstNGO, getString(R.string.action_against_ngo_s), R.array.actionNGO, this.context, report.getActionAgainstNGO());
    }

    @Override
    public void saveToReport(){
        Report report = ((EditFormActivity)context).reportToEdit;
        report.setShipActors(super.shipActorDialog.getResults());
        report.setAssetActors(super.assetDialogCheckbox.getResults());
        report.setIntimidation(super.intimidationDialog.getResults());
        report.setInterference(super.interferenceDialog.getResults());
        report.setActionAgainstSurvivors(super.actionAgainstSurvivorsDialog.getResults());
        report.setActionAgainstNGO(super.actionAgainstNGODialog.getResults());
        ((EditFormActivity)context).updateReport();
    }
}

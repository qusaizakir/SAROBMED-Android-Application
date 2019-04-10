package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.HelperModels.AssetDialogCheckbox;
import re.out.sarobmed.sarobmed.HelperModels.DialogCheckbox;
import re.out.sarobmed.sarobmed.HelperModels.InterferenceDialogCheckbox;
import re.out.sarobmed.sarobmed.HelperModels.ShipActorDialog;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;


public class FormActorDetailsFragment extends Fragment {

    private Context context;
    private FormActorDetailsListener mListener;

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

    public FormActorDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form_actor_details, container, false);
        setHasOptionsMenu(true);
        mListener.setupFormActorToolbar();
        initViews(v);
        setupDialogs();
        return v;
    }

    private void setupDialogs() {
        shipActorDialog = new ShipActorDialog(shipActors, context);
        assetDialogCheckbox = new AssetDialogCheckbox(assetActors, getString(R.string.byassetActors), R.array.assetActors, this.context);
        intimidationDialog = new DialogCheckbox(intimidation, getString(R.string.intimidation), R.array.intimidation, this.context);
        interferenceDialog = new InterferenceDialogCheckbox(interference, getString(R.string.direct_interference_with_rescue), this.context);
        actionAgainstSurvivorsDialog = new DialogCheckbox(actionAgainstSurvivors, getString(R.string.action_against_survivors), R.array.actionSurvivors, this.context);
        actionAgainstNGODialog = new DialogCheckbox(actionAgainstNGO, getString(R.string.action_against_ngo_s), R.array.actionNGO, this.context);
    }

    private void initViews(View v) {
        shipActors = v.findViewById(R.id.edit_shipActors);
        assetActors = v.findViewById(R.id.edit_assetActors);
        intimidation = v.findViewById(R.id.edit_intimidation);
        interference = v.findViewById(R.id.edit_interference);
        actionAgainstSurvivors = v.findViewById(R.id.edit_actionAgainstSurvivors);
        actionAgainstNGO = v.findViewById(R.id.edit_actionAgainstNGO);
    }

    public void saveToReport() {
        Report report = ((AddFormActivity)context).report;
        report.setShipActors(shipActorDialog.getResults());
        report.setAssetActors(assetDialogCheckbox.getResults());
        report.setIntimidation(intimidationDialog.getResults());
        report.setInterference(interferenceDialog.getResults());
        report.setActionAgainstSurvivors(actionAgainstSurvivorsDialog.getResults());
        report.setActionAgainstNGO(actionAgainstNGODialog.getResults());
        ((AddFormActivity)context).updateReport();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof FormActorDetailsListener) {
            mListener = (FormActorDetailsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FormActorDetailsListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface FormActorDetailsListener {
        void setupFormActorToolbar();
    }
}

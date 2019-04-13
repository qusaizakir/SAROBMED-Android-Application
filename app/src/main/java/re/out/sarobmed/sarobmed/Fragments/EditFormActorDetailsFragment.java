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
        fillReport();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void fillReport() {
        super.shipActorDialog.setResults(report.getShipActors());
    }

}

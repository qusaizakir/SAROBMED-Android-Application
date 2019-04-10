package re.out.sarobmed.sarobmed.HelperModels;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import re.out.sarobmed.sarobmed.R;

public class AssetDialogCheckbox implements View.OnClickListener{

    private EditText editText;
    private String[] array;
    Context context;
    EditText other;
    CheckBox otherBox;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    ArrayList<CheckBox> checkboxes;
    ArrayList<AssetActor> results;
    String title;

    CheckBox euWarshipBox;
    EditText euWarshipEdit;
    CheckBox euAircraftBox;
    EditText euAircraftEdit;
    CheckBox eunaVesselBox;
    EditText eunaVesselEdit;
    CheckBox eunoAircraftBox;
    EditText eunoAircraftEdit;
    CheckBox frontexVesselBox;
    EditText frontexVesselEdit;
    CheckBox frontexAircraftBox;
    EditText frontexAircraftEdit;
    CheckBox natoVesselBox;
    EditText natoVesselEdit;
    CheckBox natoAircraftBox;
    EditText natoAircraftEdit;
    CheckBox otherNGOBox;
    EditText otherNGOEdit;
    CheckBox cargoShipBox;
    EditText cargoShipEdit;
    ArrayList<CheckBox> assetBoxes;
    ArrayList<EditText> assetEdit;


    public AssetDialogCheckbox(EditText editText, String title, int arrayID, Context context){
        this.editText = editText;
        this.context = context;
        this.editText.setOnClickListener(this);
        this.array = context.getResources().getStringArray(arrayID);
        this.dialogBuilder = new AlertDialog.Builder(context);
        this.checkboxes = new ArrayList<>();
        this.results = new ArrayList<>();
        this.title = title;
        fillCheckboxes();
        createDialog();
    }

    private void fillCheckboxes() {
        for(String anArray : array) {
            CheckBox cb = new CheckBox(context.getApplicationContext());
            cb.setText(anArray);
            checkboxes.add(cb);
        }
    }

    private void createDialog(){
        LayoutInflater inflater = ((AppCompatActivity)context).getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.asset_dialog_checkbox, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle(title);

        //Add buttons
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                addToList();
                changeEditText();
            }
        });

        initView(dialogView);
        handleOtherCheckBox();

        //Dynamically add checkboxes for all items in the array
        LinearLayout ll = dialogView.findViewById(R.id.dialog_linearLayout);
        for(CheckBox cb: checkboxes){
            ll.addView(cb, 0);
        }

        alertDialog = dialogBuilder.create();

    }

    private void initView(View v) {
        other = v.findViewById(R.id.edit_other);
        otherBox = v.findViewById(R.id.other_checkbox);
        euWarshipBox = v.findViewById(R.id.checkbox_euWarship);
        euWarshipEdit = v.findViewById(R.id.edit_euWarship);
        euAircraftBox = v.findViewById(R.id.checkbox_euAirship);
        euAircraftEdit = v.findViewById(R.id.edit_euAirship);
        eunaVesselBox = v.findViewById(R.id.checkbox_eunaVessel);
        eunaVesselEdit = v.findViewById(R.id.edit_eunaVessel);
        eunoAircraftBox = v.findViewById(R.id.checkbox_eunaAircraft);
        eunoAircraftEdit = v.findViewById(R.id.edit_eunaAircraft);
        frontexVesselBox = v.findViewById(R.id.checkbox_frontexVessel);
        frontexVesselEdit = v.findViewById(R.id.edit_frontexVessel);
        frontexAircraftBox = v.findViewById(R.id.checkbox_frontexAircraft);
        frontexAircraftEdit = v.findViewById(R.id.edit_frontexAircraft);
        natoVesselBox = v.findViewById(R.id.checkbox_natoVessel);
        natoVesselEdit = v.findViewById(R.id.edit_natoVessel);
        natoAircraftBox = v.findViewById(R.id.checkbox_natoAircraft);
        natoAircraftEdit = v.findViewById(R.id.edit_natoAircraft);
        otherNGOBox = v.findViewById(R.id.checkbox_otherNGO);
        otherNGOEdit = v.findViewById(R.id.edit_otherNGO);
        cargoShipBox = v.findViewById(R.id.checkbox_cargoShip);
        cargoShipEdit = v.findViewById(R.id.edit_cargoShip);

        assetBoxes = new ArrayList<>();
        assetBoxes.add(euWarshipBox);
        assetBoxes.add(euAircraftBox);
        assetBoxes.add(eunaVesselBox);
        assetBoxes.add(eunoAircraftBox);
        assetBoxes.add(frontexVesselBox);
        assetBoxes.add(frontexAircraftBox);
        assetBoxes.add(natoVesselBox);
        assetBoxes.add(natoAircraftBox);
        assetBoxes.add(otherNGOBox);
        assetBoxes.add(cargoShipBox);

        assetEdit = new ArrayList<>();
        assetEdit.add(euWarshipEdit);
        assetEdit.add(euAircraftEdit);
        assetEdit.add(eunaVesselEdit);
        assetEdit.add(eunoAircraftEdit);
        assetEdit.add(frontexVesselEdit);
        assetEdit.add(frontexAircraftEdit);
        assetEdit.add(natoVesselEdit);
        assetEdit.add(natoAircraftEdit);
        assetEdit.add(otherNGOEdit);
        assetEdit.add(cargoShipEdit);
    }

    @Override
    public void onClick(View v) {
        alertDialog.show();
    }

    private void changeEditText() {
        editText.setText(results.size() + " Assets selected");
    }

    private void addToList() {
        results = new ArrayList<>();
        for(CheckBox cb: checkboxes){
            if(cb.isChecked()){
                results.add(new AssetActor(cb.getText().toString()));
            }
        }

        if(otherBox.isChecked()){
            if(!other.getText().toString().trim().isEmpty()){
                results.add(new AssetActor("Other", other.getText().toString()));
            }
        }

        for(int i=0; i<assetBoxes.size(); i++){
            if(assetBoxes.get(i).isChecked()){
                results.add(new AssetActor(assetBoxes.get(i).getText().toString(), assetEdit.get(i).getText().toString()));
            }
        }
    }

    private void handleOtherCheckBox(){
        other.setEnabled(false);
        otherBox.setChecked(false);

        otherBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    other.setEnabled(true);
                }else{
                    other.setEnabled(false);
                }
            }
        });


        for(int i=0; i<assetBoxes.size(); i++){
            final int finalI = i;
            assetBoxes.get(i).setChecked(false);
            assetEdit.get(i).setEnabled(false);
            assetBoxes.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        assetEdit.get(finalI).setEnabled(true);
                    }else{
                        assetEdit.get(finalI).setEnabled(false);
                    }
                }
            });
        }
    }

    public ArrayList<AssetActor> getResults(){
        return results;
    }


}

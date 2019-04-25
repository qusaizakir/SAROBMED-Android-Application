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

public class InterferenceDialogCheckbox implements View.OnClickListener{

    private EditText editText;
    Context context;
    EditText other;
    CheckBox otherBox;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    ArrayList<CheckBox> checkboxes;
    ArrayList<InterferenceOptions> results;
    String title;

    CheckBox noneuBoardingBox;
    EditText noneuBoardingEdit;
    CheckBox blockEUBox;
    EditText blockEUEdit;
    CheckBox blockNoneuBox;
    EditText blockNoneuEdit;
    CheckBox stayawayEuBox;
    EditText stayawayEuEdit;
    CheckBox stayawayNoneuBox;
    EditText stayawayNoneuEdit;
    CheckBox standdownEUBox;
    EditText standdownEUEdit;
    CheckBox standdownnoneuuBox;
    EditText standdownnoneuEdit;
    ArrayList<CheckBox> interBoxes;
    ArrayList<EditText> interEdit;


    public InterferenceDialogCheckbox(EditText editText, String title, Context context){
        this.editText = editText;
        this.context = context;
        this.editText.setOnClickListener(this);
        this.dialogBuilder = new AlertDialog.Builder(context);
        this.checkboxes = new ArrayList<>();
        this.results = new ArrayList<>();
        this.title = title;
        createDialog();
    }

    public InterferenceDialogCheckbox(EditText editText, String title, Context context, ArrayList<InterferenceOptions> results){
        this.editText = editText;
        this.context = context;
        this.editText.setOnClickListener(this);
        this.dialogBuilder = new AlertDialog.Builder(context);
        this.checkboxes = new ArrayList<>();
        this.results = results;
        this.title = title;
        createDialog();
    }

    private void createDialog(){
        LayoutInflater inflater = ((AppCompatActivity)context).getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.interference_dialog_checkbox, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle(title);

        initView(dialogView);
        handleOtherCheckBox();

        fillList();

        //Add buttons
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                addToList();
                changeEditText();
            }
        });



        alertDialog = dialogBuilder.create();

    }

    private void fillList(){

        for(int j=0; j<results.size(); j++){
            if(results.get(j).getInterference().equals("Other")){
                other.setText(results.get(j).getActor());
                otherBox.setChecked(true);
            }
        }

        for(int i=0; i<interBoxes.size(); i++){
            for(int j = 0; j < results.size(); j++){
                if(interBoxes.get(i).getText().toString().isEmpty()){
                    if(interBoxes.get(i).getTag().toString().equals(results.get(j).getInterference())){
                        interBoxes.get(i).setChecked(true);
                        interEdit.get(i).setText(results.get(j).getActor());
                    }
                }
            }
        }

    }

    private void initView(View v) {
        other = v.findViewById(R.id.edit_other);
        otherBox = v.findViewById(R.id.other_checkbox);
        noneuBoardingBox = v.findViewById(R.id.checkbox_noneuBoarding);
        noneuBoardingEdit = v.findViewById(R.id.edit_noneuBoarding);
        blockEUBox = v.findViewById(R.id.checkbox_blockEu);
        blockEUEdit = v.findViewById(R.id.edit_blockEu);
        blockNoneuBox = v.findViewById(R.id.checkbox_blockNoneu);
        blockNoneuEdit = v.findViewById(R.id.edit_blockNoneu);
        stayawayEuBox = v.findViewById(R.id.checkbox_stayawayEu);
        stayawayEuEdit = v.findViewById(R.id.edit_stayawayEu);
        stayawayNoneuBox = v.findViewById(R.id.checkbox_stayawayNoneu);
        stayawayNoneuEdit = v.findViewById(R.id.edit_stayawayNoneu);
        standdownEUBox = v.findViewById(R.id.checkbox_standdownEU);
        standdownEUEdit = v.findViewById(R.id.edit_standdownEU);
        standdownnoneuuBox = v.findViewById(R.id.checkbox_standdownnoneu);
        standdownnoneuEdit = v.findViewById(R.id.edit_standdownnoneu);

        interBoxes = new ArrayList<>();
        noneuBoardingBox.setTag(R.string.noneuBoarding);
        blockEUBox.setTag(R.string.blockEu);
        blockNoneuBox.setTag(R.string.blockNoneu);
        stayawayEuBox.setTag(R.string.stayawayEu);
        stayawayNoneuBox.setTag(R.string.stayawayNoneu);
        standdownEUBox.setTag(R.string.standdownEU);
        standdownnoneuuBox.setTag(R.string.stayawayNoneu);
        interBoxes.add(noneuBoardingBox);
        interBoxes.add(blockEUBox);
        interBoxes.add(blockNoneuBox);
        interBoxes.add(stayawayEuBox);
        interBoxes.add(stayawayNoneuBox);
        interBoxes.add(standdownEUBox);
        interBoxes.add(standdownnoneuuBox);
        interEdit = new ArrayList<>();
        interEdit.add(noneuBoardingEdit);
        interEdit.add(blockEUEdit);
        interEdit.add(blockNoneuEdit);
        interEdit.add(stayawayEuEdit);
        interEdit.add(stayawayNoneuEdit);
        interEdit.add(standdownEUEdit);
        interEdit.add(standdownnoneuEdit);

    }

    @Override
    public void onClick(View v) {
        alertDialog.show();
    }

    private void changeEditText() {
        editText.setText(results.size() + " Types of interference");
    }

    private void addToList() {
        results = new ArrayList<>();

        if(otherBox.isChecked()){
            if(!other.getText().toString().trim().isEmpty()){
                results.add(new InterferenceOptions("Other", other.getText().toString()));
            }
        }

        for(int i = 0; i< interBoxes.size(); i++){
            if(interBoxes.get(i).isChecked()){
                results.add(new InterferenceOptions(interBoxes.get(i).getTag().toString(), interEdit.get(i).getText().toString()));
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


        for(int i = 0; i< interBoxes.size(); i++){
            final int finalI = i;
            interBoxes.get(i).setChecked(false);
            interEdit.get(i).setEnabled(false);
            interBoxes.get(i).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        interEdit.get(finalI).setEnabled(true);
                    }else{
                        interEdit.get(finalI).setEnabled(false);
                    }
                }
            });
        }
    }

    public ArrayList<InterferenceOptions> getResults(){
        return results;
    }
}

package re.out.sarobmed.sarobmed.HelperModels;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
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

public class DialogCheckbox implements View.OnClickListener{

    EditText editText;
    String[] array;
    Context context;
    EditText other;
    CheckBox otherBox;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    ArrayList<CheckBox> checkboxes;
    ArrayList<String> results;
    String title;

    public DialogCheckbox(EditText editText, String title, int arrayID, Context context){
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
        View dialogView = inflater.inflate(R.layout.dialog_checkbox, null);
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


        other = dialogView.findViewById(R.id.edit_other);
        otherBox = dialogView.findViewById(R.id.other_checkbox);
        handleOtherCheckBox();

        //Dynamically add checkboxes for all items in the array
        LinearLayout ll = dialogView.findViewById(R.id.dialog_linearLayout);
        for(CheckBox cb: checkboxes){
            ll.addView(cb, 0);
        }

        alertDialog = dialogBuilder.create();

    }

    @Override
    public void onClick(View v) {
        alertDialog.show();
    }

    private void changeEditText() {
        StringBuilder sb = new StringBuilder();
        Log.d("RESULTSSIZE", results.size() + "");
        for(String s: results){
            sb.append(s);
            sb.append(" ");

        }
        editText.setText(sb.toString());
    }

    private void addToList() {
        results = new ArrayList<>();
        for(CheckBox cb: checkboxes){
            if(cb.isChecked()){
                results.add(cb.getText().toString());
            }
        }

        if(otherBox.isChecked()){
            if(!other.getText().toString().trim().isEmpty()){
                results.add(other.getText().toString());
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
    }

    public ArrayList<String> getResults(){
        return results;
    }


}

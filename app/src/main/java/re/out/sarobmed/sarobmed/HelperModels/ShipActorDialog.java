package re.out.sarobmed.sarobmed.HelperModels;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import re.out.sarobmed.sarobmed.Adapters.ShipActorAdapter;
import re.out.sarobmed.sarobmed.R;

import static androidx.recyclerview.widget.RecyclerView.VERTICAL;

public class ShipActorDialog implements View.OnClickListener {

    private Context context;
    private EditText shipActorEditText;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog alertDialog;
    private ArrayList<ShipActor> results;

    private RecyclerView recyclerView;
    private EditText hullNumberEditText;
    private EditText flagEditText;
    private Button addShipActorButton;
    private ShipActorAdapter adapter;


    public ShipActorDialog(EditText editText, Context context){
        this.shipActorEditText = editText;
        this.context = context;
        this.results = new ArrayList<>();
        this.dialogBuilder = new AlertDialog.Builder(context);
        this.shipActorEditText.setOnClickListener(this);
        createDialog();
    }

    private void createDialog() {
        LayoutInflater inflater = ((AppCompatActivity)context).getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_shipactor, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setTitle(context.getString(R.string.edit_shipActor_dialogTitle));

        setupRecyclerView(dialogView);
        hullNumberEditText = dialogView.findViewById(R.id.edit_dialog_hullNumber);
        flagEditText = dialogView.findViewById(R.id.edit_dialog_flag);
        addShipActorButton = dialogView.findViewById(R.id.edit_dialog_addShipActor);
        addShipActorButton.setOnClickListener(this);

        //Add buttons
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //TODO add shipActor results array to save to database
                changeEditText();

            }
        });

        alertDialog = dialogBuilder.create();
    }

    private void changeEditText() {
        shipActorEditText.setText(results.size() + " Actors");
    }


    private void setupRecyclerView(View v) {
        recyclerView = v.findViewById(R.id.edit_dialog_shipActorRecyclerView);
        adapter = new ShipActorAdapter(results,context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, VERTICAL, false));
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.edit_shipActors:
                alertDialog.show();
                break;
            case R.id.edit_dialog_addShipActor:
                String hull = hullNumberEditText.getText().toString();
                String flag = flagEditText.getText().toString();
                int position = adapter.getItemCount();

                results.add(position, new ShipActor(hull, flag));
                adapter.notifyItemInserted(position);
                break;
        }
    }

    public ArrayList<ShipActor> getResults() {
        return results;
    }

    public void setResults(ArrayList<ShipActor> results) {
        this.results = results;
    }
}

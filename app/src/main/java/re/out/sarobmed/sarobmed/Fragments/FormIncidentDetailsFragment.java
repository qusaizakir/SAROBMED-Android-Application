package re.out.sarobmed.sarobmed.Fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.Activities.AddFormActivity;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;


public class FormIncidentDetailsFragment extends Fragment {

    private Context context;
    private FormIncidentDetailsListener mListener;
    private EditText shortTitle;
    private EditText dateOfMisson;
    final Calendar dateOfMissionCalendar = Calendar.getInstance();


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
        setUpDateOfMission();
        return v;
    }

    private void setUpDateOfMission() {

        final DatePickerDialog.OnDateSetListener dateOfMissionDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                dateOfMissionCalendar.set(Calendar.YEAR, year);
                dateOfMissionCalendar.set(Calendar.MONTH, monthOfYear);
                dateOfMissionCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
                dateOfMisson.setText(sdf.format(dateOfMissionCalendar.getTime()));
            }

        };

        dateOfMisson.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, dateOfMissionDate, dateOfMissionCalendar
                        .get(Calendar.YEAR), dateOfMissionCalendar.get(Calendar.MONTH),
                        dateOfMissionCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
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
    }

    public void saveToReport() {
        Report report = ((AddFormActivity)context).report;

        report.setShortTitle(shortTitle.getText().toString());
        report.setDateOfMission(dateOfMissionCalendar.getTime());

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

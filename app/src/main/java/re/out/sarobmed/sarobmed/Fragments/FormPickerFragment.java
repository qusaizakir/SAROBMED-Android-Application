package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.R;

import static re.out.sarobmed.sarobmed.Activities.AddFormActivity.INCIDENT;
import static re.out.sarobmed.sarobmed.Activities.AddFormActivity.LOCATION;
import static re.out.sarobmed.sarobmed.Activities.AddFormActivity.REPORTER;

public class FormPickerFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private FormPickerFragmentListener mListener;
    private CardView reporterDetailsCard;
    private CardView locationDetailsCard;
    private CardView incidentDetailsCard;

    public FormPickerFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form_picker, container, false);

        setHasOptionsMenu(true);
        mListener.setupFormPickerToolbar();
        initViews(v);
        return v;
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
        reporterDetailsCard = v.findViewById(R.id.card_reporter_details);
        locationDetailsCard = v.findViewById(R.id.card_location_details);
        incidentDetailsCard = v.findViewById(R.id.card_incident_details);

        reporterDetailsCard.setOnClickListener(this);
        locationDetailsCard.setOnClickListener(this);
        incidentDetailsCard.setOnClickListener(this);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof FormPickerFragmentListener) {
            mListener = (FormPickerFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FormPickerFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.card_reporter_details:
                mListener.openFragment(REPORTER);
                break;
            case R.id.card_location_details:
                mListener.openFragment(LOCATION);
                break;
            case R.id.card_incident_details:
                mListener.openFragment(INCIDENT);
        }
    }

    public interface FormPickerFragmentListener {
        void openFragment(int fragment);
        void setupFormPickerToolbar();
    }
}

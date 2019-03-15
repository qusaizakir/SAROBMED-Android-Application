package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.HelperModels.ShipActorDialog;
import re.out.sarobmed.sarobmed.R;


public class FormActorDetailsFragment extends Fragment {

    private Context context;
    private FormActorDetailsListener mListener;

    private ShipActorDialog shipActorDialog;
    private EditText shipActors;

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
        setupShipActors();
        return v;
    }

    private void initViews(View v) {
        shipActors = v.findViewById(R.id.edit_shipActors);
    }

    private void setupShipActors() {
        shipActorDialog = new ShipActorDialog(shipActors, context);
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

package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import re.out.sarobmed.sarobmed.R;

public class UnsyncedReportsFragment extends Fragment {

    private UnsyncedReportsFragmentCallbackInterface mListener;

    public UnsyncedReportsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_unsynced_reports, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View v) {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof UnsyncedReportsFragmentCallbackInterface) {
            mListener = (UnsyncedReportsFragmentCallbackInterface) context;
        } else {
            //throw new RuntimeException(context.toString() + " must implement SyncedReportsFragmentCallbackInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface UnsyncedReportsFragmentCallbackInterface {

    }
}

package re.out.sarobmed.sarobmed.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import re.out.sarobmed.sarobmed.Adapters.ReportAdapter;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.R;


public class IncompleteReportsFragment extends Fragment {

    private Context context;
    private IncompleteReportsFragmentCallbackInterface mListener;
    private RecyclerView recyclerView;
    private ReportAdapter reportAdapter;
    private List<Report> reportList;

    public IncompleteReportsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_incomplete_reports, container, false);
        initViews(v);
        setupRecyclerview();
        return v;
    }

    private void initViews(View v) {
        recyclerView = v.findViewById(R.id.incomplete_recyclerview);
    }

    private void setupRecyclerview() {
        reportAdapter = new ReportAdapter(reportList);
        reportAdapter.setHasStableIds(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(reportAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof IncompleteReportsFragmentCallbackInterface) {
            mListener = (IncompleteReportsFragmentCallbackInterface) context;
        } else {
            //throw new RuntimeException(context.toString() + " must implement IncompleteReportsFragmentCallbackInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface IncompleteReportsFragmentCallbackInterface {

    }
}

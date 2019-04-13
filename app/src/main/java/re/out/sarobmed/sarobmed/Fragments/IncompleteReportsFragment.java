package re.out.sarobmed.sarobmed.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import re.out.sarobmed.sarobmed.Adapters.DeleteReportInterface;
import re.out.sarobmed.sarobmed.Adapters.ReportAdapter;
import re.out.sarobmed.sarobmed.Adapters.ReportEditableAdapter;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.R;
import re.out.sarobmed.sarobmed.ViewModels.MainViewModel;


public class IncompleteReportsFragment extends Fragment implements DeleteReportInterface {

    private Context context;
    private IncompleteReportsFragmentCallbackInterface mListener;
    private RecyclerView recyclerView;
    private ReportEditableAdapter reportAdapter;
    private List<ReportMinimal> reportMinimalList;
    private MainViewModel model;

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

        model = ViewModelProviders.of(this).get(MainViewModel.class);
        createObservers();

        return v;
    }


    private void initViews(View v) {
        reportMinimalList = new ArrayList<>();
        recyclerView = v.findViewById(R.id.incomplete_recyclerview);
    }

    private void setupRecyclerview() {
        reportAdapter = new ReportEditableAdapter(reportMinimalList, context, this);
        reportAdapter.setHasStableIds(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(reportAdapter);
    }

    private void createObservers() {

        model.getAllIncompleteReportMinimal().observe(getViewLifecycleOwner(), new Observer<List<ReportMinimal>>() {
            @Override
            public void onChanged(List<ReportMinimal> reportMinimals) {
                reportMinimalList = reportMinimals;
                reportAdapter.swap(reportMinimals);
            }
        });
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
        reportAdapter.finishActionMode();
    }

    @Override
    public void deleteReports(ArrayList<Long> IDs) {
        for(Long i: IDs){
            model.deleteReportByID(i);
        }
    }

    public interface IncompleteReportsFragmentCallbackInterface {

    }
}

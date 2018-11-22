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
import re.out.sarobmed.sarobmed.Adapters.ReportAdapter;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.R;
import re.out.sarobmed.sarobmed.ViewModels.MainViewModel;

public class UnsyncedReportsFragment extends Fragment {

    private Context context;
    private UnsyncedReportsFragmentCallbackInterface mListener;
    private RecyclerView recyclerView;
    private ReportAdapter reportAdapter;
    private List<ReportMinimal> reportMinimalList;
    private MainViewModel model;

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
        setupRecyclerview();

        model = ViewModelProviders.of(this).get(MainViewModel.class);
        createObservers();
        return v;
    }

    private void initViews(View v) {
        reportMinimalList = new ArrayList<>();
        recyclerView = v.findViewById(R.id.unsynced_recyclerview);
    }

    private void setupRecyclerview() {
        reportAdapter = new ReportAdapter(reportMinimalList, context);
        reportAdapter.setHasStableIds(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(reportAdapter);
    }

    private void createObservers() {

        model.getAllUnsyncedReportMinimal().observe(getViewLifecycleOwner(), new Observer<List<ReportMinimal>>() {
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

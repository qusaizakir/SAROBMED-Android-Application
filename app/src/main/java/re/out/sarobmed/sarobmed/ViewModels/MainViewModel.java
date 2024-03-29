package re.out.sarobmed.sarobmed.ViewModels;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.Repositories.ReportRepository;

public class MainViewModel extends AndroidViewModel {

    private ReportRepository reportRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.reportRepository = new ReportRepository(application);
    }

    //Get incomplete ReportsMinimal
    public LiveData<List<ReportMinimal>> getAllIncompleteReportMinimal(){
        return reportRepository.getAllIncompleteReportMinimal();
    }

    //Get synced ReportsMinimal
    public LiveData<List<ReportMinimal>> getAllSyncedReportMinimal(){
        return reportRepository.getAllSyncedReportMinimal();
    }

    //Get unsynced ReportsMinimal
    public LiveData<List<ReportMinimal>> getAllUnsyncedReportMinimal(){
        return reportRepository.getAllUnsyncedReportMinimal();
    }

    public void deleteReportByID (Long ID){
        reportRepository.deleteReportByID(ID);
    }
}

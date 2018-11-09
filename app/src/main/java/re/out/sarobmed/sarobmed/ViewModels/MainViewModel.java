package re.out.sarobmed.sarobmed.ViewModels;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
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
}

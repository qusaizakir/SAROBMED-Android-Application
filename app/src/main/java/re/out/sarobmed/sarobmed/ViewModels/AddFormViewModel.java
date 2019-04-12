package re.out.sarobmed.sarobmed.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.Repositories.ReportRepository;

public class AddFormViewModel extends AndroidViewModel {

    private ReportRepository reportRepository;

    public AddFormViewModel(@NonNull Application application) {
        super(application);
        this.reportRepository = new ReportRepository(application);
    }

    public void insertReport(Report report){
        reportRepository.insertReport(report);
    }

    public void updateReport(Report report){
        reportRepository.updateReport(report);
    }

    public void deleteReport(Report report){
        reportRepository.deleteReport(report);
    }

}

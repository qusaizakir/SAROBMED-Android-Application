package re.out.sarobmed.sarobmed.Repositories;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;
import re.out.sarobmed.sarobmed.Dao.ReportDao;
import re.out.sarobmed.sarobmed.Database.AppDatabase;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.Models.ReporterDetails;

public class ReportRepository {

    private final ReportDao reportDao;

    public ReportRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        reportDao = db.reportDao();
    }

    //ReporterDetails
    public LiveData<ReporterDetails> getReporterDetailsByID(int id){
        return reportDao.getReporterDetailsByID(id);
    }

    public LiveData<List<ReportMinimal>> getAllIncompleteReportMinimal(){
        return reportDao.getAllIncompleteReportMinimal();
    }

    public LiveData<List<ReportMinimal>> getAllSyncedReportMinimal(){
        return reportDao.getAllSyncedReportMinimal();
    }

    public LiveData<List<ReportMinimal>> getAllUnsyncedReportMinimal(){
        return reportDao.getAllUnsyncedReportMinimal();
    }

    //IncidentDetails
    //LocationDetails
    //ActorsDetails
    //FatalitiesDetails
}

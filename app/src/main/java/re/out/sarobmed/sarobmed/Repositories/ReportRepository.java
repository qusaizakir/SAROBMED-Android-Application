package re.out.sarobmed.sarobmed.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import re.out.sarobmed.sarobmed.Dao.ReportDao;
import re.out.sarobmed.sarobmed.Database.AppDatabase;
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

    //IncidentDetails
    //LocationDetails
    //ActorsDetails
    //FatalitiesDetails
}

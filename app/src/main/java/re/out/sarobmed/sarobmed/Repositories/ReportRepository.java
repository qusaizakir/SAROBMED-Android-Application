package re.out.sarobmed.sarobmed.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import re.out.sarobmed.sarobmed.Dao.ReportDao;
import re.out.sarobmed.sarobmed.Database.AppDatabase;
import re.out.sarobmed.sarobmed.Models.ActorDetails;
import re.out.sarobmed.sarobmed.Models.FatalitiesDetails;
import re.out.sarobmed.sarobmed.Models.IncidentDetails;
import re.out.sarobmed.sarobmed.Models.LocationDetails;
import re.out.sarobmed.sarobmed.Models.Report;
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

    //IncidentDetails
    public LiveData<IncidentDetails> getIncidentDetailsByID(int id){
        return reportDao.getIncidentDetailsByID(id);
    }

    //LocationDetails
    public LiveData<LocationDetails> getLocationDetailsByID(int id){
        return reportDao.getLocationDetailsByID(id);
    }

    //ActorsDetails
    public LiveData<ActorDetails> getActorDetailsByID(int id){
        return reportDao.getActorDetailsByID(id);
    }

    //FatalitiesDetails
    public LiveData<FatalitiesDetails> getFatalitiesDetailsByID(int id){
        return reportDao.getFatalitiesDetailsByID(id);
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

    //AsyncTask to insert Report
    public void insertReport(Report report) {
        new insertReport(reportDao).execute(report);
    }
    private static class insertReport extends AsyncTask<Report, Void, Void> {

        private ReportDao mAsyncTaskDao;

        insertReport(ReportDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Report... params) {
            mAsyncTaskDao.insertReport(params[0]);
            return null;
        }
    }

    //AsyncTask to update Report
    public void updateReport(Report report) {
        new updateReport(reportDao).execute(report);
    }
    private static class updateReport extends AsyncTask<Report, Void, Void> {

        private ReportDao mAsyncTaskDao;

        updateReport(ReportDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Report... params) {
            mAsyncTaskDao.updateReport(params[0]);
            return null;
        }
    }

}

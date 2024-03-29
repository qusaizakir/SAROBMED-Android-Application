package re.out.sarobmed.sarobmed.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import re.out.sarobmed.sarobmed.Dao.ReportDao;
import re.out.sarobmed.sarobmed.Models.IncidentDetails;
import re.out.sarobmed.sarobmed.Models.LocationDetails;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.Models.ReporterDetails;

@Database(entities = {Report.class}, version = 5)
@TypeConverters({TypeConvertersClass.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract ReportDao reportDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {

        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if(INSTANCE == null){
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Database")
                                    .fallbackToDestructiveMigration()
                                    .addCallback(sRoomDatabaseCallback)
                                    .build();

                }
            }

        }
        return INSTANCE;
    }

    private static  RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate (@NonNull SupportSQLiteDatabase db){
            new PopulateDbAsync(INSTANCE).execute();
            super.onCreate(db);

        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final ReportDao reportDao;


        PopulateDbAsync(AppDatabase db) {
            reportDao = db.reportDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            ArrayList<String> loc = new ArrayList<>();
            loc.add("Western Mediterranean");
            Random r = new Random();

            Report report = new Report();
            report.setUID(0L);
            report.setShortTitle("Proactiva: Rescue of 57 people in the Western Mediterranean Synced");
            report.setLocationDescription(loc);
            report.setSynced(true);
            report.setFinished(true);
            report.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report1 = new Report();
            report1.setUID(1L);
            report1.setShortTitle("SOS Mediterranee: Severe threats from Libyan Coast Guard Synced");
            report1.setLocationDescription(loc);
            report1.setSynced(true);
            report1.setFinished(true);
            report1.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report2 = new Report();
            report2.setUID(2L);
            report2.setShortTitle("Refugee Rescue: Denied permission to assist a deflating migrant vessel Synced");
            report2.setLocationDescription(loc);
            report2.setSynced(true);
            report2.setFinished(true);
            report2.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report3 = new Report();
            report3.setUID(3L);
            report3.setShortTitle("Arrest of rescue workers in Greece Incomplete");
            report3.setLocationDescription(loc);
            report3.setFinished(false);
            report3.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report4 = new Report();
            report4.setUID(4L);
            report4.setShortTitle("SMH: 53 migrants landed in Chios Incomplete");
            report4.setLocationDescription(loc);
            report4.setFinished(false);
            report4.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report5 = new Report();
            report5.setUID(5L);
            report5.setShortTitle("Refugee Rescue: Denied permission to launch for rescue UNSynced");
            report5.setLocationDescription(loc);
            report5.setFinished(true);
            report5.setSynced(false);
            report5.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report6 = new Report();
            report6.setUID(6L);
            report6.setShortTitle("MSF: Aquarius rescued a wooden boat with 25 people on board UNSynced");
            report6.setLocationDescription(loc);
            report6.setFinished(true);
            report6.setSynced(false);
            report6.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            reportDao.insertReport(report);
            reportDao.insertReport(report1);
            reportDao.insertReport(report2);
            reportDao.insertReport(report3);
            reportDao.insertReport(report4);
            reportDao.insertReport(report5);
            reportDao.insertReport(report6);
            return null;
        }
    }
}


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

@Database(entities = {Report.class}, version = 2)
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
            report.setShortTitle("Proactiva: Rescue of 57 people in the Western Mediterranean");
            report.setLocationDescription(loc);
            report.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report1 = new Report();
            report1.setShortTitle("SOS Mediterranee: Severe threats from Libyan Coast Guard");
            report1.setLocationDescription(loc);
            report1.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report2 = new Report();
            report2.setShortTitle("Refugee Rescue: Denied permission to assist a deflating migrant vessel");
            report2.setLocationDescription(loc);
            report2.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report3 = new Report();
            report3.setShortTitle("Arrest of rescue workers in Greece");
            report3.setLocationDescription(loc);
            report3.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report4 = new Report();
            report4.setShortTitle("SMH: 53 migrants landed in Chios");
            report4.setLocationDescription(loc);
            report4.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report5 = new Report();
            report5.setShortTitle("Refugee Rescue: Denied permission to launch for rescue");
            report5.setLocationDescription(loc);
            report5.setDateOfMission(new Date(System.currentTimeMillis() + ((r.nextInt(80 - 1) + 1)* 86400000)));

            Report report6 = new Report();
            report6.setShortTitle("MSF: Aquarius rescued a wooden boat with 25 people on board");
            report6.setLocationDescription(loc);
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


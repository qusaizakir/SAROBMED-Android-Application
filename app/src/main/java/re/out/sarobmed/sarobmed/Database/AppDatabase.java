package re.out.sarobmed.sarobmed.Database;

import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import re.out.sarobmed.sarobmed.Dao.ReportDao;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.Models.ReporterDetails;

@Database(entities = {ReporterDetails.class}, version = 1)
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

            Report report = new Report(0, new ReporterDetails());
            report.getReporterDetails().setOrganisation("Brunel University London");
            report.getReporterDetails().setReporter("Qusai Zakir");

            reportDao.insertReport(report);

            return null;
        }
    }
}


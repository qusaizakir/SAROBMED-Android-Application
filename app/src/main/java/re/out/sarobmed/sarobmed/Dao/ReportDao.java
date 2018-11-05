package re.out.sarobmed.sarobmed.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.Models.ReporterDetails;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ReportDao {

    @Query("SELECT * FROM Report WHERE UID = :ID")
    LiveData<ReporterDetails> getReporterDetailsByID(int ID);

    @Insert(onConflict = REPLACE)
    void insertReport(Report report);

}

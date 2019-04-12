package re.out.sarobmed.sarobmed.Dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import re.out.sarobmed.sarobmed.Models.ActorDetails;
import re.out.sarobmed.sarobmed.Models.FatalitiesDetails;
import re.out.sarobmed.sarobmed.Models.IncidentDetails;
import re.out.sarobmed.sarobmed.Models.LocationDetails;
import re.out.sarobmed.sarobmed.Models.Report;
import re.out.sarobmed.sarobmed.Models.ReportMinimal;
import re.out.sarobmed.sarobmed.Models.ReporterDetails;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ReportDao {

    @Insert(onConflict = REPLACE)
    void insertReport(Report report);

    @Update
    void updateReport(Report report);

    @Delete
    void deleteReport(Report report);

    //For each part of the report, get each part separately

    //Get only ReporterDetails from the report, for a specific report.
    @Query("SELECT UID, reporter, organisation, reporter_complete " +
            "FROM Report WHERE UID = :ID")
    LiveData<ReporterDetails> getReporterDetailsByID(int ID);

    //Get only IncidentDetails from the report, for a specific report.
    @Query("SELECT UID, shortTitle, dateOfMission, timeOfFirstInfoGet, startTimeOfFirstSighting," +
            " endTimeOfMission, missionDesc, SARAsset, migrantNoOfBoats, migrantTypeOfBoats," +
            " migrantConditionOfBoats, migrantNoOfPeoplePerBoat, migrantBoatIdentifiers, " +
            "seaAndWeatherConditions, otherVesselsInVicinity, sourceOfFirstInfo," +
            " mediaOfCommunication, meansOfBoatDetection, coordOnScene, coordOverall," +
            " coordOrdersToSARVessel, supportingEvidence, incident_complete  " +
            "FROM Report WHERE UID = :ID")
    LiveData<IncidentDetails> getIncidentDetailsByID(int ID);

    //Get only LocationDetails from the report, for a specific report.
    @Query("SELECT UID, posOfVesselLong, posOfVesselLat, locationDescription, " +
            "approxDistanceFromCoastline, assumedPointOfDeparture, location_complete" +
            " FROM Report WHERE UID = :ID")
    LiveData<LocationDetails> getLocationDetailsByID(int ID);

    //Get only ActorDetails from the report, for a specific report.
    @Query("SELECT UID, shipActors, assetActors, intimidation, interference," +
            " actionAgainstSurvivors, actionAgainstNGO, actor_complete FROM Report WHERE UID = :ID")
    LiveData<ActorDetails> getActorDetailsByID(int ID);

    //Get only FatalitiesDetails from the report, for a specific report.
    @Query("SELECT UID, totConfirmDead, totEstimateDeadMissing, deadPrior, deadDuring, deadAfter," +
            " fatalities_complete FROM Report WHERE UID = :ID")
    LiveData<FatalitiesDetails> getFatalitiesDetailsByID(int ID);

    //For the main page, get status of reports (Synced, Unsynced or incomplete)

    //Get list of all Reports (as ReportMinimal) where they have not been finished or synced, order by newest
    @Query("SELECT UID, shortTitle, locationDescription, dateOfMission" +
            " FROM Report WHERE finished = 0 ORDER BY UID DESC")
    LiveData<List<ReportMinimal>> getAllIncompleteReportMinimal();

    //Get list of all Reports (as ReportMinimal) which have been synced and finished, order by newest
    @Query("SELECT UID, shortTitle, locationDescription, dateOfMission" +
            " FROM Report WHERE synced = 1 AND finished = 1 ORDER BY UID DESC")
    LiveData<List<ReportMinimal>> getAllSyncedReportMinimal();

    //Get list of all Reports (as ReportMinimal) which have been finished but not synced, order by newest
    @Query("SELECT UID, shortTitle, locationDescription, dateOfMission" +
            " FROM Report WHERE synced = 0 AND finished = 1 ORDER BY UID DESC")
    LiveData<List<ReportMinimal>> getAllUnsyncedReportMinimal();

}

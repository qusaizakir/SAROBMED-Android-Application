package re.out.sarobmed.sarobmed.Models;

import java.util.ArrayList;
import java.util.Date;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
* This is the main Report Table in the SQL ROOM Database
* It includes all parts of the report
* Each 'part' is split into different models that are queried individually
* And displayed on the Report Details page*/

@Entity
public class Report {

    @PrimaryKey(autoGenerate = true)
    private int UID;
    private boolean finished;
    private boolean synced;

    //ReporterDetails
    private String reporter;
    private String organisation;
    private boolean reporter_complete;

    //LocationDetails
    private Double posOfVesselLong;
    private Double posOfVesselLat;
    private ArrayList<String> locationDescription;
    private int approxDistanceFromCoastline;
    private String assumedPointOfDeparture;
    private boolean location_complete;

    //IncidentDetails
    private String shortTitle;
    private Date dateOfMission;
    private Date timeOfFirstInfoGet;
    private Date startTimeOfFirstSighting;
    private Date endTimeOfMission;
    private String missionDesc;
    private String SARAsset;
    private int migrantNoOfBoats;
    private String migrantTypeOfBoats;
    private String migrantConditionOfBoats;
    private int migrantNoOfPeoplePerBoat;
    private String migrantBoatIdentifiers;
    private String seaAndWeatherConditions;
    private String otherVesselsInVicinity;
    private String sourceOfFirstInfo;
    private ArrayList<String> mediaOfCommunication;
    private ArrayList<String> meansOfBoatDetection;
    private String coordOnScene;
    private String coordOverall;
    private String coordOrdersToSARVessel;
    private ArrayList<String> supportingEvidence;
    private boolean incident_complete;


    public Report() {
        this.incident_complete = false;
        this.location_complete = false;
        this.reporter_complete = false;
        this.finished = false;
        this.synced = false;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isSynced() {
        return synced;
    }

    public void setSynced(boolean synced) {
        this.synced = synced;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public boolean isReporter_complete() {
        return reporter_complete;
    }

    public void setReporter_complete(boolean reporter_complete) {
        this.reporter_complete = reporter_complete;
    }

    public Double getPosOfVesselLong() {
        return posOfVesselLong;
    }

    public void setPosOfVesselLong(Double posOfVesselLong) {
        this.posOfVesselLong = posOfVesselLong;
    }

    public Double getPosOfVesselLat() {
        return posOfVesselLat;
    }

    public void setPosOfVesselLat(Double posOfVesselLat) {
        this.posOfVesselLat = posOfVesselLat;
    }

    public ArrayList<String> getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(ArrayList<String> locationDescription) {
        this.locationDescription = locationDescription;
    }

    public int getApproxDistanceFromCoastline() {
        return approxDistanceFromCoastline;
    }

    public void setApproxDistanceFromCoastline(int approxDistanceFromCoastline) {
        this.approxDistanceFromCoastline = approxDistanceFromCoastline;
    }

    public String getAssumedPointOfDeparture() {
        return assumedPointOfDeparture;
    }

    public void setAssumedPointOfDeparture(String assumedPointOfDeparture) {
        this.assumedPointOfDeparture = assumedPointOfDeparture;
    }

    public boolean isLocation_complete() {
        return location_complete;
    }

    public void setLocation_complete(boolean location_complete) {
        this.location_complete = location_complete;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public Date getDateOfMission() {
        return dateOfMission;
    }

    public void setDateOfMission(Date dateOfMission) {
        this.dateOfMission = dateOfMission;
    }

    public Date getTimeOfFirstInfoGet() {
        return timeOfFirstInfoGet;
    }

    public void setTimeOfFirstInfoGet(Date timeOfFirstInfoGet) {
        this.timeOfFirstInfoGet = timeOfFirstInfoGet;
    }

    public Date getStartTimeOfFirstSighting() {
        return startTimeOfFirstSighting;
    }

    public void setStartTimeOfFirstSighting(Date startTimeOfFirstSighting) {
        this.startTimeOfFirstSighting = startTimeOfFirstSighting;
    }

    public Date getEndTimeOfMission() {
        return endTimeOfMission;
    }

    public void setEndTimeOfMission(Date endTimeOfMission) {
        this.endTimeOfMission = endTimeOfMission;
    }

    public String getMissionDesc() {
        return missionDesc;
    }

    public void setMissionDesc(String missionDesc) {
        this.missionDesc = missionDesc;
    }

    public String getSARAsset() {
        return SARAsset;
    }

    public void setSARAsset(String SARAsset) {
        this.SARAsset = SARAsset;
    }

    public int getMigrantNoOfBoats() {
        return migrantNoOfBoats;
    }

    public void setMigrantNoOfBoats(int migrantNoOfBoats) {
        this.migrantNoOfBoats = migrantNoOfBoats;
    }

    public String getMigrantTypeOfBoats() {
        return migrantTypeOfBoats;
    }

    public void setMigrantTypeOfBoats(String migrantTypeOfBoats) {
        this.migrantTypeOfBoats = migrantTypeOfBoats;
    }

    public String getMigrantConditionOfBoats() {
        return migrantConditionOfBoats;
    }

    public void setMigrantConditionOfBoats(String migrantConditionOfBoats) {
        this.migrantConditionOfBoats = migrantConditionOfBoats;
    }

    public int getMigrantNoOfPeoplePerBoat() {
        return migrantNoOfPeoplePerBoat;
    }

    public void setMigrantNoOfPeoplePerBoat(int migrantNoOfPeoplePerBoat) {
        this.migrantNoOfPeoplePerBoat = migrantNoOfPeoplePerBoat;
    }

    public String getMigrantBoatIdentifiers() {
        return migrantBoatIdentifiers;
    }

    public void setMigrantBoatIdentifiers(String migrantBoatIdentifiers) {
        this.migrantBoatIdentifiers = migrantBoatIdentifiers;
    }

    public String getSeaAndWeatherConditions() {
        return seaAndWeatherConditions;
    }

    public void setSeaAndWeatherConditions(String seaAndWeatherConditions) {
        this.seaAndWeatherConditions = seaAndWeatherConditions;
    }

    public String getOtherVesselsInVicinity() {
        return otherVesselsInVicinity;
    }

    public void setOtherVesselsInVicinity(String otherVesselsInVicinity) {
        this.otherVesselsInVicinity = otherVesselsInVicinity;
    }

    public String getSourceOfFirstInfo() {
        return sourceOfFirstInfo;
    }

    public void setSourceOfFirstInfo(String sourceOfFirstInfo) {
        this.sourceOfFirstInfo = sourceOfFirstInfo;
    }

    public ArrayList<String> getMediaOfCommunication() {
        return mediaOfCommunication;
    }

    public void setMediaOfCommunication(ArrayList<String> mediaOfCommunication) {
        this.mediaOfCommunication = mediaOfCommunication;
    }

    public ArrayList<String> getMeansOfBoatDetection() {
        return meansOfBoatDetection;
    }

    public void setMeansOfBoatDetection(ArrayList<String> meansOfBoatDetection) {
        this.meansOfBoatDetection = meansOfBoatDetection;
    }

    public String getCoordOnScene() {
        return coordOnScene;
    }

    public void setCoordOnScene(String coordOnScene) {
        this.coordOnScene = coordOnScene;
    }

    public String getCoordOverall() {
        return coordOverall;
    }

    public void setCoordOverall(String coordOverall) {
        this.coordOverall = coordOverall;
    }

    public String getCoordOrdersToSARVessel() {
        return coordOrdersToSARVessel;
    }

    public void setCoordOrdersToSARVessel(String coordOrdersToSARVessel) {
        this.coordOrdersToSARVessel = coordOrdersToSARVessel;
    }

    public ArrayList<String> getSupportingEvidence() {
        return supportingEvidence;
    }

    public void setSupportingEvidence(ArrayList<String> supportingEvidence) {
        this.supportingEvidence = supportingEvidence;
    }

    public boolean isIncident_complete() {
        return incident_complete;
    }

    public void setIncident_complete(boolean incident_complete) {
        this.incident_complete = incident_complete;
    }
}

package re.out.sarobmed.sarobmed.Models;

import java.util.ArrayList;
import java.util.Date;

public class IncidentDetails {

    private long UID;
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

    public IncidentDetails() {
        incident_complete = false;
    }

    public long getUID() {
        return UID;
    }

    public void setUID(long UID) {
        this.UID = UID;
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

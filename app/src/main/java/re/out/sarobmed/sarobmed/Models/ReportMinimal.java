package re.out.sarobmed.sarobmed.Models;

import java.util.ArrayList;
import java.util.Date;

public class ReportMinimal {

    private long UID;
    private String shortTitle;
    private ArrayList<String> locationDescription;
    private Date dateOfMission;

    public ReportMinimal() {
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

    public ArrayList<String> getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(ArrayList<String> locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Date getDateOfMission() {
        return dateOfMission;
    }

    public void setDateOfMission(Date dateOfMission) {
        this.dateOfMission = dateOfMission;
    }
}

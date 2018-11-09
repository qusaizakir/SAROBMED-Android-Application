package re.out.sarobmed.sarobmed.Models;

import java.util.ArrayList;

public class LocationDetails {

    private int UID;
    private Double posOfVesselLong;
    private Double posOfVesselLat;
    private ArrayList<String> locationDescription;
    private int approxDistanceFromCoastline;
    private String assumedPointOfDeparture;
    private boolean location_complete;

    public LocationDetails() {
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
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
}

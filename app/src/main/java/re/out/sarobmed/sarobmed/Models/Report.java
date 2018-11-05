package re.out.sarobmed.sarobmed.Models;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Report {

    @PrimaryKey
    private int UID;
    @Embedded(prefix = "reporter_")
    ReporterDetails reporterDetails;
    //Embed all entities into Report (this) entity to consolidate information
    //Room will allow for references to embedded entities from one query

    //IncidentDetails
    //LocationDetails
    //ActorsDetails
    //FatalitiesDetails
    private boolean complete;
    private boolean synced;

    public Report(int UID, ReporterDetails reporterDetails) {
        this.UID = UID;
        this.reporterDetails = reporterDetails;
        this.complete = false;
        this.synced = false;
    }

    public boolean isSynced() {
        return synced;
    }

    public void setSynced(boolean synced) {
        this.synced = synced;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public ReporterDetails getReporterDetails() {
        return reporterDetails;
    }

    public void setReporterDetails(ReporterDetails reporterDetails) {
        this.reporterDetails = reporterDetails;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}

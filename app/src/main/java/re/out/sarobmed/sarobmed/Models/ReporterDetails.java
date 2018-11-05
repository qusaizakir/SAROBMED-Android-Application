package re.out.sarobmed.sarobmed.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ReporterDetails {

    @PrimaryKey(autoGenerate = true)
    private String reporter;
    private String organisation;
    private boolean complete;

    public ReporterDetails() {
        this.reporter = "";
        this.organisation = "";
        this.complete = false;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
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
}

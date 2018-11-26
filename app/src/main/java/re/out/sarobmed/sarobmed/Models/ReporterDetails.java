package re.out.sarobmed.sarobmed.Models;

public class ReporterDetails {

    private long UID;
    private String reporter;
    private String organisation;
    private boolean reporter_complete;

    public ReporterDetails() {
    }

    public long getUID() {
        return UID;
    }

    public void setUID(long UID) {
        this.UID = UID;
    }

    public boolean isReporter_complete() {
        return reporter_complete;
    }

    public void setReporter_complete(boolean reporter_complete) {
        this.reporter_complete = reporter_complete;
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

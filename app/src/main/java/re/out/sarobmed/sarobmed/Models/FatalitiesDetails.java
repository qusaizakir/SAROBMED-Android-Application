package re.out.sarobmed.sarobmed.Models;

public class FatalitiesDetails {

    private long UID;
    private int totConfirmDead;
    private int totEstimateDeadMissing;
    private int deadPrior;
    private int deadDuring;
    private int deadAfter;
    private boolean fatalities_complete;

    public FatalitiesDetails() {
    }

    public long getUID() {
        return UID;
    }

    public void setUID(long UID) {
        this.UID = UID;
    }

    public int getTotConfirmDead() {
        return totConfirmDead;
    }

    public void setTotConfirmDead(int totConfirmDead) {
        this.totConfirmDead = totConfirmDead;
    }

    public int getTotEstimateDeadMissing() {
        return totEstimateDeadMissing;
    }

    public void setTotEstimateDeadMissing(int totEstimateDeadMissing) {
        this.totEstimateDeadMissing = totEstimateDeadMissing;
    }

    public int getDeadPrior() {
        return deadPrior;
    }

    public void setDeadPrior(int deadPrior) {
        this.deadPrior = deadPrior;
    }

    public int getDeadDuring() {
        return deadDuring;
    }

    public void setDeadDuring(int deadDuring) {
        this.deadDuring = deadDuring;
    }

    public int getDeadAfter() {
        return deadAfter;
    }

    public void setDeadAfter(int deadAfter) {
        this.deadAfter = deadAfter;
    }

    public boolean isFatalities_complete() {
        return fatalities_complete;
    }

    public void setFatalities_complete(boolean fatalities_complete) {
        this.fatalities_complete = fatalities_complete;
    }
}

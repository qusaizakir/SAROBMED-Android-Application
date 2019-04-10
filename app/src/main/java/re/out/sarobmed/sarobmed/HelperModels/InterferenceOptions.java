package re.out.sarobmed.sarobmed.HelperModels;

public class InterferenceOptions {
    private String interference;
    private String actor;

    public InterferenceOptions(String interference, String actor){
        this.interference = interference;
        this.actor = actor;
    }

    public String getInterference() {
        return interference;
    }

    public void setInterference(String interference) {
        this.interference = interference;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}

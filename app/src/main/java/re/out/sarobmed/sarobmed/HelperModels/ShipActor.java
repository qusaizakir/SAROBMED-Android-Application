package re.out.sarobmed.sarobmed.HelperModels;

public class ShipActor {
    private String hullNumber;
    private String flag;

    public ShipActor(String hullNumber, String flag) {
        this.hullNumber = hullNumber;
        this.flag = flag;
    }

    public String getHullNumber() {
        return hullNumber;
    }

    public void setHullNumber(String hullNumber) {
        this.hullNumber = hullNumber;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}

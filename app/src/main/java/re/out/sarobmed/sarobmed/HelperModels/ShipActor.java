package re.out.sarobmed.sarobmed.HelperModels;

public class ShipActor {
    private int hullNumber;
    private String flag;

    public ShipActor(int hullNumber, String flag) {
        this.hullNumber = hullNumber;
        this.flag = flag;
    }

    public int getHullNumber() {
        return hullNumber;
    }

    public void setHullNumber(int hullNumber) {
        this.hullNumber = hullNumber;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}

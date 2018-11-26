package re.out.sarobmed.sarobmed.HelperModels;

public class AssetActor {
    private String institution;
    private String addInfo;

    public AssetActor(String institution, String addInfo) {
        this.institution = institution;
        this.addInfo = addInfo;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}

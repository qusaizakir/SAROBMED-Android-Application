package re.out.sarobmed.sarobmed.Models;

import java.util.ArrayList;

import re.out.sarobmed.sarobmed.HelperModels.AssetActor;
import re.out.sarobmed.sarobmed.HelperModels.ShipActor;

public class ActorDetails {

    private long UID;
    private ArrayList<ShipActor> shipActors;
    private ArrayList<AssetActor> assetActors;
    private ArrayList<String> intimidation;
    private ArrayList<String> interference;
    private ArrayList<String> actionAgainstSurvivors;
    private ArrayList<String> actionAgainstNGO;
    private boolean actor_complete;

    public ActorDetails() {
    }

    public long getUID() {
        return UID;
    }

    public void setUID(long UID) {
        this.UID = UID;
    }

    public ArrayList<ShipActor> getShipActors() {
        return shipActors;
    }

    public void setShipActors(ArrayList<ShipActor> shipActors) {
        this.shipActors = shipActors;
    }

    public ArrayList<AssetActor> getAssetActors() {
        return assetActors;
    }

    public void setAssetActors(ArrayList<AssetActor> assetActors) {
        this.assetActors = assetActors;
    }

    public ArrayList<String> getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(ArrayList<String> intimidation) {
        this.intimidation = intimidation;
    }

    public ArrayList<String> getInterference() {
        return interference;
    }

    public void setInterference(ArrayList<String> interference) {
        this.interference = interference;
    }

    public ArrayList<String> getActionAgainstSurvivors() {
        return actionAgainstSurvivors;
    }

    public void setActionAgainstSurvivors(ArrayList<String> actionAgainstSurvivors) {
        this.actionAgainstSurvivors = actionAgainstSurvivors;
    }

    public ArrayList<String> getActionAgainstNGO() {
        return actionAgainstNGO;
    }

    public void setActionAgainstNGO(ArrayList<String> actionAgainstNGO) {
        this.actionAgainstNGO = actionAgainstNGO;
    }

    public boolean isActor_complete() {
        return actor_complete;
    }

    public void setActor_complete(boolean actor_complete) {
        this.actor_complete = actor_complete;
    }
}

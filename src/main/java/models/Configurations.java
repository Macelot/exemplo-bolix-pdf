package models;

import org.json.JSONObject;

public class Configurations {

    private Float interest;

    private Float fine;

    private JSONObject configurationsOBJ;

    public Configurations(Float interest, Float fine) {
        this.interest = interest;
        this.fine = fine;
        this.configurationsOBJ = new JSONObject();
        this.configurationsOBJ.put("interest", interest);
        this.configurationsOBJ.put("fine", fine);
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Float getFine() {
        return fine;
    }

    public void setFine(Float fine) {
        this.fine = fine;
    }

    public JSONObject getConfigurationsOBJ() {
        return configurationsOBJ;
    }

    public void setConfigurationsOBJ(JSONObject configurationsOBJ) {
        this.configurationsOBJ = configurationsOBJ;
    }

    @Override
    public String toString() {
        return "Configurations{" + "interest=" + interest + ", fine=" + fine + '}';
    }
    
    
}

package models;

import org.json.JSONObject;

public class Conditional_discount {

    private String type;

    private Float value;

    private String until_date;

    private JSONObject conditional_discountOBJ;

    public Conditional_discount(String type, Float value, String until_date) {
        this.type = type;
        this.value = value;
        this.until_date = until_date;
        this.conditional_discountOBJ = new JSONObject();
        this.conditional_discountOBJ.put("type", type);
        this.conditional_discountOBJ.put("value", value);
        this.conditional_discountOBJ.put("until_date", until_date);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getUntil_date() {
        return until_date;
    }

    public void setUntil_date(String until_date) {
        this.until_date = until_date;
    }

    public JSONObject getConditional_discountOBJ() {
        return conditional_discountOBJ;
    }

    public void setConditional_discountOBJ(JSONObject conditional_discountOBJ) {
        this.conditional_discountOBJ = conditional_discountOBJ;
    }

    @Override
    public String toString() {
        return "Conditional_discount{" + "type=" + type + ", value=" + value + ", until_date=" + until_date + '}';
    }
    
    
}

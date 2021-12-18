package models;

import org.json.JSONObject;

public class Discount {

    private String type;

    private Float value;

    private JSONObject discountOBJ;

    public Discount(String type, Float value) {
        this.type = type;
        this.value = value;
        this.discountOBJ = new JSONObject();
        this.discountOBJ.put("type", type);
        this.discountOBJ.put("value", value);
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

    public JSONObject getDiscountOBJ() {
        return discountOBJ;
    }

    public void setDiscountOBJ(JSONObject discountOBJ) {
        this.discountOBJ = discountOBJ;
    }

    @Override
    public String toString() {
        return "Discount{" + "type=" + type + ", value=" + value + '}';
    }
    
    
}

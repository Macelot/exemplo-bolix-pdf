package models;

public class Item {

    private String name;

    private Integer amount;

    private Float value;

    public Item(String name, Integer amount, Float value) {
        this.name = name;
        this.amount = amount;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
    
    
}

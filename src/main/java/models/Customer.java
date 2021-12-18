package models;

import org.json.JSONObject;

public class Customer {

    private String name;

    private String cpf;

    private String phone_number;

    private JSONObject customerOBJ;

    public Customer(String name, String cpf, String phone_number) {
        this.name = name;
        this.cpf = cpf;
        this.phone_number = phone_number;
        this.customerOBJ = new JSONObject();
        this.customerOBJ.put("name", name);
        this.customerOBJ.put("cpf", cpf);
        this.customerOBJ.put("phone_number", phone_number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public JSONObject getCustomerOBJ() {
        return customerOBJ;
    }

    public void setCustomerOBJ(JSONObject customerOBJ) {
        this.customerOBJ = customerOBJ;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", cpf=" + cpf + ", phone_number=" + phone_number + '}';
    }
    
    

   
}

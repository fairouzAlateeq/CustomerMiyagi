package com.ps.CustomerMiyagi.models;

public class Customer {

    private int customerId;
    private String name;
    private String phone;

    //an empty constructor cause this will be a bean which is something we'll inject is sql i think
    public Customer(){}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

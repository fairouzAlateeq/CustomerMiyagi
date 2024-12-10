package com.ps.CustomerMiyagi.models;

public class Product {
    private int productId;
    private String name;
    private String type;

    public Product() {
    }

    public Product(int productId, String name, String type) {
        this.productId = productId;
        this.name = name;
        this.type = type;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

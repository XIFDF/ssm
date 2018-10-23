package com.xifdf.pojo;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return products;
    }

    public void setProductList(List<Product> products) {
        this.products = products;
    }
}

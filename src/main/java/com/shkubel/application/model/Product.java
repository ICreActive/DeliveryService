package com.shkubel.application.model;

import java.io.Serializable;


public class Product implements Serializable {

    private int id;
    private String name;
    private float price;
    private ProdCategory prodCategory;

    public Product() {
    }

    public Product(int id, String name, float price, ProdCategory prodCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.prodCategory = prodCategory;
    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProdCategory getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(ProdCategory prodCategory) {
        this.prodCategory = prodCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", prodCategory=" + prodCategory +
                '}';
    }
}

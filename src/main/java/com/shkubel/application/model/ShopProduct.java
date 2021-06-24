package com.shkubel.application.model;

import java.io.Serializable;
import java.util.Objects;

public class ShopProduct implements Serializable, Comparable<ShopProduct> {

    private long id;
    private Product product;
    private Shop shop;
    private float price;
    private int count;

    public ShopProduct() {

    }

    public ShopProduct(long id, Product product, Shop shop, float price, int count) {
        this.id = id;
        this.product = product;
        this.shop = shop;
        this.price = price;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(ShopProduct o) {
        return Float.compare(this.price, o.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopProduct that = (ShopProduct) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product in Shop: " +
                "id" + id +
                ", product: " + product.getName() +
                " Category:  " + product.getProdCategory() +
                ", shop: " + shop.getName() +
                ", price: " + price +
                ", count: " + count
                ;
    }


}
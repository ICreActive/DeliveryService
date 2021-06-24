package com.shkubel.application.model;

import java.io.Serializable;

public class Order implements Serializable {

    private long id;
    private User user;
    private ShopProduct shopProduct;
    private int quantity;
    private float total;

    public Order() {
    }

    public Order(long id, User user, ShopProduct shopProduct, int quantity, float total) {
        this.id = id;
        this.user = user;
        this.shopProduct = shopProduct;
        this.quantity = quantity;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShopProduct getShopProduct() {
        return shopProduct;
    }

    public void setShopProduct(ShopProduct shopProduct) {
        this.shopProduct = shopProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "You order: " + '\n' +
                "id: " + id + '\n' +
                "user: " + user.getName() + " " + user.getLastName() + '\n' +
                "Address  delivery: " + user.getAddress() + '\n' +
                "Seller: " + shopProduct.getShop().getName() + '\n' +
                "shopProduct: " + shopProduct.getProduct().getName() + ", " +
                shopProduct.getPrice() + " Quantity " + quantity+ '\n' + "Total: " + total
                ;
    }
}

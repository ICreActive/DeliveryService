package com.shkubel.application.service;

import com.shkubel.application.exception.ObjectNotFoundException;
import com.shkubel.application.model.Order;
import com.shkubel.application.database.DataBase;

import java.util.List;

public class OrderService implements ShowDelInterface {

    DataBase db = new DataBase();
    List<Order> orderList = db.loadOrderList();

    public void createOrder(long userId, long shopProductId, int quantity) {
        var order = new Order();
        try {
            order.setUser(db.findUserById((userId)));
        } catch (ObjectNotFoundException e) {
            System.err.println(e);
        }
        try {
            order.setShopProduct(db.findShopProductById(shopProductId));
            order.setQuantity(quantity);
            order.setTotal(order.getQuantity() * order.getShopProduct().getPrice());
            order.setId(orderList.size() + 1L);
            orderList.add(order);
            db.saveOrderList(orderList);
        } catch (ObjectNotFoundException e) {
            System.err.println(e);
        }
    }

    @Override
    public void show() {
        db.loadOrderList().forEach(System.out::println);
    }

    @Override
    public void delete(long id) {
        try {
            db.findOrderById(id);
            orderList.removeIf(order -> order.getId() == id);
            db.saveOrderList(orderList);
            System.out.println("Deleted");
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}


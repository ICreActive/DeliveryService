package com.shkubel.application.service;

import com.shkubel.application.exception.ObjectNotFoundException;
import com.shkubel.application.model.Shop;
import com.shkubel.application.database.DataBase;

import java.util.List;

public class ShopService implements ShowDelInterface {

    DataBase db = new DataBase();
    List<Shop> shops = db.loadShopList();

    public void createShop(String shopName, float markup) {
        var shop = new Shop();
        shop.setName(shopName);
        shop.setMarkup(markup);
        shop.setId(shops.size() + 1);
        shops.add(shop);
        System.out.println(shop);
        db.saveShopList(shops);
    }


    public void updateShop(long id, String name, float markup) {
        Shop shopInDb = null;
        try {
            shopInDb = db.findShopById(id);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
        for (Shop shop : shops
        ) {
            if (shop.equals(shopInDb)) {
                System.out.println(shop);
                shop.setName(name);
                shop.setMarkup(markup);
            }
        }
        db.saveShopList(shops);
    }

    @Override
    public void delete(long id) {
        try {
            db.findShopById(id);
            shops.removeIf(shopElem -> shopElem.getId() == id);
            db.saveShopList(shops);
            System.out.println("Deleted");
        } catch (ObjectNotFoundException e) {
            System.err.println(e);
        }

    }


    @Override
    public void show() {
        for (var shop : db.loadShopList()) {
            System.out.println(shop);
            System.out.println();
        }
    }
}

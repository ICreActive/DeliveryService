package com.shkubel.application.database;

import com.shkubel.application.exception.ObjectNotFoundException;
import com.shkubel.application.model.*;

import java.util.List;

public interface  StorageService {

    void saveUserList(List <User> list);

    List <User> loadUserList();


    void saveShopList(List<Shop> shopList);

    List<Shop> loadShopList();

    List<Product> loadProductList();

    void saveProductList (List <Product> productList);

    List<ShopProduct> loadShopProductList();

    void saveShopProductList (List <ShopProduct> productList);

    List<Order> loadOrderList();

    void saveOrderList (List <Order> orderList);

    User findUserById(long id) throws ObjectNotFoundException;

    ShopProduct findShopProductById(long id) throws ObjectNotFoundException;

    Product findProductById(long id) throws ObjectNotFoundException;

    Shop findShopById(long id) throws ObjectNotFoundException;

    Order findOrderById(long id) throws ObjectNotFoundException;

    void findShopProductByNameAndShop (String productName, String shopName);

}

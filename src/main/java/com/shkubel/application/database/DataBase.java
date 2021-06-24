package com.shkubel.application.database;

import com.google.gson.reflect.TypeToken;
import com.shkubel.application.exception.ObjectNotFoundException;
import com.shkubel.application.model.*;

import java.util.LinkedList;
import java.util.List;

public class DataBase implements StorageService{

    protected static final String STORAGE_FILE_SHOPS = "Shops.json";
    protected static final String STORAGE_FILE_USERS = "Users.json";
    protected static final String STORAGE_FILE_PRODUCT = "Product.json";
    protected static final String STORAGE_FILE_SHOPPRODUCT = "ShopProduct.json";
    protected static final String STORAGE_FILE_ORDERS = "Orders.json";


    @Override
    public void saveUserList(List <User> userList) {
        SerializationUtil.exportDataToFile(userList, STORAGE_FILE_USERS);

    }

    @Override
    public List <User> loadUserList() {
        return (List<User>) SerializationUtil.importDataFromFile(STORAGE_FILE_USERS, new TypeToken<LinkedList<User>>() {
        }.getType());
    }

    @Override
    public void saveShopList(List<Shop> shopList) {
        SerializationUtil.exportDataToFile(shopList, STORAGE_FILE_SHOPS);

    }

    @Override
    public List<Shop> loadShopList() {
        return (List<Shop>) SerializationUtil.importDataFromFile(STORAGE_FILE_SHOPS, new TypeToken<LinkedList<Shop>>() {
        }.getType());
    }

    @Override
    public void saveProductList(List<Product> productList) {
        SerializationUtil.exportDataToFile(productList, STORAGE_FILE_PRODUCT);

    }

    @Override
    public List<Product> loadProductList() {
        return (List<Product>) SerializationUtil.importDataFromFile(STORAGE_FILE_PRODUCT, new TypeToken<LinkedList<Product>>() {
        }.getType());

    }

    @Override
    public List<ShopProduct> loadShopProductList() {
        return (List<ShopProduct>) SerializationUtil.importDataFromFile(STORAGE_FILE_SHOPPRODUCT, new TypeToken<LinkedList<ShopProduct>>() {
        }.getType());
    }

    @Override
    public void saveShopProductList(List<ShopProduct> shopProductList) {
        SerializationUtil.exportDataToFile(shopProductList, STORAGE_FILE_SHOPPRODUCT);

    }

    @Override
    public List<Order> loadOrderList() {
        return (List<Order>) SerializationUtil.importDataFromFile(STORAGE_FILE_ORDERS, new TypeToken<LinkedList<Order>>() {
        }.getType());
    }

    @Override
    public void saveOrderList(List<Order> orderList) {
        SerializationUtil.exportDataToFile(orderList, STORAGE_FILE_ORDERS);
    }


    @Override
    public User findUserById(long id) throws ObjectNotFoundException {
        User current = null;
        for (User user : loadUserList()
        ) {
            if (user.getId() == id)
                current = user;
        }
        if (current==null) {
            throw new ObjectNotFoundException("User not found in DB");
        }
        return current;
    }

    @Override
    public ShopProduct findShopProductById(long id) throws ObjectNotFoundException {
        ShopProduct current = null;
        for (ShopProduct sp : loadShopProductList()
        ) {
            if (sp.getId() == id)
                current = sp;
        }
        if (current==null) {
            throw new ObjectNotFoundException("Product in shop not found in DB");
        }
        return current;
    }

    @Override
    public Product findProductById(long id) throws ObjectNotFoundException {
        Product current = null;
        for (Product product : loadProductList()
        ) {
            if (product.getId() == id) {
                current = product;
                break;
            }
        }
        if (current==null) {
            throw new ObjectNotFoundException("Product not found in DB");
        }
        return current;
    }

    @Override
    public Shop findShopById(long id) throws ObjectNotFoundException {
        Shop current = null;
        for (Shop shop : loadShopList()
        ) {
            if (shop.getId() == id) {
                current = shop;
                break;
            }
        }
        if (current==null) {
            throw new ObjectNotFoundException("Shop not found in DB");
        }
        return current;
    }

    @Override
    public Order findOrderById(long id) throws  ObjectNotFoundException {
        Order current = null;
        for (var order : loadOrderList()
        ) {
            if (order.getId() == id) {
                current = order;
                break;
            }
        }
        if (current==null) {
            throw new ObjectNotFoundException("Shop not found in DB");
        }
        return current;
    }

    @Override
    public void findShopProductByNameAndShop(String productName, String shopName) {
        List<ShopProduct> shopProductList = loadShopProductList();
        shopProductList.stream()
                .filter(name -> name.getProduct().getName().equalsIgnoreCase(productName) &&
                        name.getShop().getName().equalsIgnoreCase(shopName))
                .forEach(System.out::println);
    }

}

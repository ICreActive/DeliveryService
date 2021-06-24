package com.shkubel.application.service;


import com.shkubel.application.exception.ObjectNotFoundException;
import com.shkubel.application.model.ProdCategory;
import com.shkubel.application.model.ShopProduct;
import com.shkubel.application.database.DataBase;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ShopProductService implements ShowDelInterface {

    DataBase db = new DataBase();
    List<ShopProduct> shopProductList = db.loadShopProductList();

    public ShopProduct createShopProduct(long id, long shopId, long productId, int count) {
        var shopProduct = new ShopProduct();
        try {
            shopProduct.setShop(db.findShopById(shopId));
        } catch (ObjectNotFoundException e) {
            System.err.println(e);
        }
        try {
            shopProduct.setProduct(db.findProductById(productId));
        } catch (ObjectNotFoundException e) {
            System.err.println(e);
        }
        try {
        shopProduct.setPrice((db.findProductById(productId).getPrice()*db.findShopById(shopId).getMarkup()+100)/100);
        } catch (ObjectNotFoundException e) {
            System.err.println(e);
        }
        shopProduct.setCount(count);
        shopProduct.setId(id);
        return shopProduct;
    }

    public void filterShopProductByCategory (List <ShopProduct> shopProductList, String filterCategory) {
        for (ProdCategory category: ProdCategory.values()
             ) {
            if (category.name().equalsIgnoreCase(filterCategory)) {
                shopProductList.stream()
                        .filter(shopProduct -> shopProduct.getProduct().getProdCategory()
                                .equals(ProdCategory.valueOf(filterCategory.toUpperCase(Locale.ROOT))))
                        .forEach(System.out::println);
            }
        }
    }
    public void sortShopProductByPrice (List <ShopProduct> shopProductList) {
        Collections.sort(shopProductList);
        shopProductList.forEach(System.out::println);
     }

    @Override
    public void delete(long id) {
        try {
            db.findShopProductById(id);
            shopProductList.removeIf(product -> product.getId() == id);
            db.saveShopProductList(shopProductList);
            System.out.println("Deleted");
        }
        catch (ObjectNotFoundException e) {
            System.err.println(e);
        }
    }
}

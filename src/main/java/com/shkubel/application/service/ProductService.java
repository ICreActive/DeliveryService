package com.shkubel.application.service;

import com.shkubel.application.exception.ObjectNotFoundException;
import com.shkubel.application.model.ProdCategory;
import com.shkubel.application.model.Product;
import com.shkubel.application.database.DataBase;


import java.util.List;

public class ProductService implements ShowDelInterface {

    DataBase db = new DataBase();
    List<Product> productList = db.loadProductList();

    public void createProduct(String name, String productCategory, float price) {
        var product = new Product();
        product.setName(name);
        for (ProdCategory elem : ProdCategory.values()) {
            if (elem.name().equalsIgnoreCase(productCategory)) {
                product.setProdCategory(ProdCategory.valueOf(productCategory.toUpperCase()));
                break;
            }
            product.setProdCategory(ProdCategory.OTHER);
        }
        product.setPrice(price);
        product.setId(productList.size() + 1);
        productList.add(product);
        db.saveProductList(productList);
    }

    public void updateProduct(long id, String name, float price) {
        Product productInDb = null;
        try {
            productInDb = db.findProductById(id);
            for (Product product : productList
            ) {
                if (product.equals(productInDb)) {
                    System.out.println(product);
                    product.setName(name);
                    product.setPrice(price);
                }
            }
            db.saveProductList(productList);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try {
            db.findProductById(id);
            productList.removeIf(product -> product.getId() == id);
            db.saveProductList(productList);
            System.out.println("Deleted");
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

}

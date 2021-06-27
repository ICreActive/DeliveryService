package com.shkubel.application.init;

import com.shkubel.application.database.DataBase;
import com.shkubel.application.model.ProdCategory;
import com.shkubel.application.model.Product;
import com.shkubel.application.model.Shop;
import com.shkubel.application.model.ShopProduct;
import com.shkubel.application.service.ShopProductService;

import java.util.List;

//Initialized for a quick demo application
public final class InitData {

    private InitData() {

    }

    public static void Init() {

        var db = new DataBase();
        List<Shop> shops = db.loadShopList();
        List<Product> productList = db.loadProductList();
        List<ShopProduct> shopProductList = db.loadShopProductList();
        var shopProduct = new ShopProductService();


        productList.add(new Product(1, "Dress", 20, ProdCategory.WOMEN));
        productList.add(new Product(2, "Lamp", 16, ProdCategory.HOME));
        productList.add(new Product(3, "Book", 13, ProdCategory.OTHER));
        productList.add(new Product(4, "Holder", 4, ProdCategory.OTHER));
        productList.add(new Product(5, "Picture", 20, ProdCategory.MEN));
        db.saveProductList(productList);

        shops.add(new Shop(1, "BIGZ", 10));
        shops.add(new Shop(2, "PRO100", 19));
        shops.add(new Shop(3, "EURO", 15));
        shops.add(new Shop(4, "MOLL", 13));
        db.saveShopList(shops);

        shopProductList.add(shopProduct.createShopProduct( 1, 1, 20));
        shopProductList.add(shopProduct.createShopProduct( 2, 1, 15));
        shopProductList.add(shopProduct.createShopProduct(3, 2, 20));
        shopProductList.add(shopProduct.createShopProduct( 3, 1, 14));
        shopProductList.add(shopProduct.createShopProduct( 1, 4, 12));
        db.saveShopProductList(shopProductList);

    }
}

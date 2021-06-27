package com.shkubel.application;

import com.shkubel.application.database.DataBase;
import com.shkubel.application.init.InitData;
import com.shkubel.application.service.*;
import com.shkubel.application.util.ShowListUtil;

import java.util.Scanner;

public class DeliveryApp {

    public static void main(String[] args) {

        var db = new DataBase();
        var shopProductService = new ShopProductService();

        if (db.loadShopProductList().isEmpty()) { // Initialized for a quick demo application
            InitData.Init();
        }

        var userService = new UserService();
        var productService = new ProductService();
        var orderService = new OrderService();
        var shopService = new ShopService();

        ShowListUtil.show(db.loadUserList());

        System.out.println("1 - Registration" + '\n' + "2 - login");
        var sc = new Scanner(System.in);

        if (sc.nextLine().equals("1")) {
            System.out.println("1 - Shop " + '\n' + "2 - User");

            switch (sc.nextInt()) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("Enter name of shop");
                    var sc3 = sc.nextLine();
                    System.out.println("Enter markup");
                    var sc4 = sc.nextFloat();
                    sc.nextLine();
                    shopService.createShop(sc3, sc4);
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.println("Enter name");
                    var sc5 = sc.nextLine();
                    System.out.println("Enter last name");
                    var sc6 = sc.nextLine();
                    System.out.println("Enter age");
                    var sc7 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter delivery address");
                    var sc8 = sc.nextLine();
                    userService.createUser(sc5, sc6, sc7, sc8);
                }
            }
        }

        String userChoice;
        do {
            System.out.println("1 - Edit User, 2 - Show all shops, 3 - Product list, " + '\n'
                    + " 4 - Product in Shop, 5 - Create order, 6 - Filter by category, 7 - sortByPrice, 9 - Create new product, "
                    + "10 - Add product to shop, " + " 11 - delete");
            var sc9 = sc.nextInt();
            sc.nextLine();

            switch (sc9) {
                case 1 -> {
                    System.out.println("Введите ID");
                    var sc10 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name");
                    var sc11 = sc.nextLine();
                    System.out.println("Enter new age");
                    var sc12 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new address");
                    var sc13 = sc.nextLine();
                    userService.updateUser(sc10, sc11, sc12, sc13);
                }

                case 2 -> {
                    ShowListUtil.show(db.loadShopList());
                    System.out.println("for update enter ID");
                    var sc14 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new name");
                    var sc15 = sc.nextLine();
                    System.out.println("Enter new markup");
                    var sc16 = sc.nextFloat();
                    sc.nextLine();
                    shopService.updateShop(sc14, sc15, sc16);

                }
                case 3 -> {
                    db.loadProductList().forEach(System.out::println);
                    System.out.println("for update enter ID");
                    var sc17 = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter new name");
                    var sc18 = sc.nextLine();
                    System.out.println("Enter price");
                    var sc19 = sc.nextFloat();
                    sc.nextLine();
                    productService.updateProduct(sc17, sc18, sc19);
                }
                case 4 -> ShowListUtil.show(db.loadShopProductList());

                case 5 -> {
                    System.out.println("Enter user ID");
                    var sc20 = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter shop_product ID");
                    var sc21 = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter quantity");
                    var sc22 = sc.nextInt();
                    sc.nextLine();
                    orderService.createOrder(sc20, sc21, sc22);
                    ShowListUtil.show(db.loadOrderList());
                }
                case 6 -> {
                    ShowListUtil.show(db.loadShopProductList());
                    System.out.println("Enter category");
                    var sc23 = sc.nextLine();
                    shopProductService.filterShopProductByCategory(db.loadShopProductList(), sc23);
                }
                case 7 -> {
                    ShowListUtil.show(db.loadShopProductList());
                    System.out.println("Sort by price? y / n");
                    var sc24 = sc.nextLine();
                    if (sc24.equalsIgnoreCase("y")) {
                        shopProductService.sortShopProductByPrice(db.loadShopProductList());
                    }
                }
                case 8 -> {
                    System.out.println("Enter product name");
                    var sc25 = sc.nextLine();
                    System.out.println("Enter name of shop");
                    var sc26 = sc.nextLine();
                    db.findShopProductByNameAndShop(sc25, sc26);
                }
                case 9 -> {
                    System.out.println("Enter product name");
                    var sc27 = sc.nextLine();
                    System.out.println("Enter category");
                    var sc28 = sc.nextLine();
                    System.out.println("Enter price");
                    var sc29 = sc.nextFloat();
                    sc.nextLine();
                    productService.createProduct(sc27, sc28, sc29);
                }
                case 10 -> {
                    ShowListUtil.show(db.loadShopList());
                    System.out.println("Enter shop id");
                    var sc27 = sc.nextLong();
                    ShowListUtil.show(db.loadProductList());
                    System.out.println("Enter product id");
                    var sc28 = sc.nextLong();
                    System.out.println("Enter quantity");
                    var sc29 = sc.nextInt();
                    sc.nextLine();
                    shopProductService.createShopProduct(sc27,sc28,sc29);
                }
                case 11 -> {
                    System.out.println("What you have delete?" + '\n'
                            + "1 - User" + '\n'
                            + "2 - Shop" + '\n'
                            + "3 - Product" + '\n'
                            + "4 - Product from the store" + '\n'
                            + "5 - Order");
                    var sc30 = sc.nextInt();
                    sc.nextLine();
                    switch (sc30) {
                        case 1 -> {
                            ShowListUtil.show(db.loadUserList());
                            System.out.println("Enter user ID");
                            var sc31 = sc.nextLong();
                            sc.nextLine();
                            userService.delete(sc31);

                        }
                        case 2 -> {
                            ShowListUtil.show(db.loadShopList());
                            System.out.println("Enter shop ID");
                            var sc31 = sc.nextLong();
                            sc.nextLine();
                            shopService.delete(sc31);

                        }
                        case 3 -> {
                            ShowListUtil.show(db.loadProductList());
                            System.out.println("Enter product ID");
                            var sc31 = sc.nextLong();
                            sc.nextLine();
                            productService.delete(sc31);

                        }
                        case 4 -> {
                            ShowListUtil.show(db.loadShopProductList());
                            System.out.println("Enter ID");
                            var sc31 = sc.nextLong();
                            sc.nextLine();
                            shopProductService.delete(sc31);
                        }
                        case 5 -> {
                            ShowListUtil.show(db.loadUserList());
                            System.out.println("Enter ID");
                            var sc31 = sc.nextLong();
                            sc.nextLine();
                            orderService.delete(sc31);
                        }

                    }

                }

            }
            System.out.println("Return (y) or Exit (any symbol)");
            userChoice = sc.nextLine();
        } while (userChoice.equals("y"));
    }
}






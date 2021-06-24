package com.shkubel.application.database;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

public final class SerializationUtil {

    private SerializationUtil() {

    }

    private static final Gson gson = new Gson();

    public static Object importDataFromFile(String fileName, Type listType) {

        try {
            var bufferedReader = new BufferedReader(new FileReader(fileName));
            return gson.fromJson(bufferedReader, listType);
        } catch (FileNotFoundException e) {
            switch (fileName) {
                case DataBase.STORAGE_FILE_USERS -> new File(DataBase.STORAGE_FILE_USERS);
                case DataBase.STORAGE_FILE_SHOPS -> new File(DataBase.STORAGE_FILE_SHOPS);
                case DataBase.STORAGE_FILE_PRODUCT -> new File(DataBase.STORAGE_FILE_PRODUCT);
                case DataBase.STORAGE_FILE_SHOPPRODUCT -> new File(DataBase.STORAGE_FILE_SHOPPRODUCT);
                case DataBase.STORAGE_FILE_ORDERS -> new File(DataBase.STORAGE_FILE_ORDERS);
            }

        }
        return new LinkedList();
    }

    public static void exportDataToFile(Object object, String fileName) {

        try {
           var writer = new FileWriter(fileName);
            writer.write(gson.toJson(object));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

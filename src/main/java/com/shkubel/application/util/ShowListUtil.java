package com.shkubel.application.util;

import java.util.List;

public class ShowListUtil {

    public static void show(List<?> list) {
        list.forEach(System.out::println);
    }

}

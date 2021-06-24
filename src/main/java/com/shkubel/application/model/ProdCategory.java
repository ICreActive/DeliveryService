package com.shkubel.application.model;

public enum ProdCategory {
    HOME ("Home"), KIDS("Kids"), MEN("Men"),WOMEN("Women"), OTHER("Other");

    private String name;

    ProdCategory (String name) {
        this.name = name;
    }

}

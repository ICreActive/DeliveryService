package com.shkubel.application.model;

import java.io.Serializable;

public class Shop implements Serializable {

    private int id;
    private String name;
    private float markup;

    public Shop() {
    }

    public Shop(int id, String name, float markup) {
        this.id = id;
        this.name = name;
        this.markup = markup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarkup() {
        return markup;
    }

    public void setMarkup(float markup) {
        this.markup = markup;
    }


    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", markup=" + markup +
                '}';
    }
}


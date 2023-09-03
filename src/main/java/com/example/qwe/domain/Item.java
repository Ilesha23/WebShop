package com.example.qwe.domain;

public class Item {
    private int id;
    private String name;
    private String desc;
    private double price;

    public Item (int id, String name, String desc, double price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name=" + name +
                ", desc=" + desc +
                ", price=" + price;
    }
}

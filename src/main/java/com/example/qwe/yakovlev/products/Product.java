package com.example.qwe.yakovlev.products;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Product implements Comparable<Product>, Iproduct, Serializable {
    // yes, double is bad for holding money
    private double price;
    private String name;
    private static double sumPrice = 0.0;
    private static int count = 0;

    public Product() {
        price = 0.0;
        name = "default";
        count++;
        sumPrice += price;
    }
    public  Product (String name, double price){
        this.price = price;
        this.name = name;
        count++;
        sumPrice += price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) throws NegativePriceException {
        if (price < 0){
            throw new NegativePriceException("Price can't be less than 0", price);
        }
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getAvgPrice() {
        return sumPrice / count;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Name:" + name + " Price:" + price;
    }


    public static class PriceComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.compareTo(o2);
        }
    }

}

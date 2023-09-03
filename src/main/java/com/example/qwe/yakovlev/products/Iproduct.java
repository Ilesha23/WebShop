package com.example.qwe.yakovlev.products;

public interface Iproduct {
    double getPrice();
    void setPrice(double price) throws NegativePriceException;
    String getName();
    void setName(String name);
}

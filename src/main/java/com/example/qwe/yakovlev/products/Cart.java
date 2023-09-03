package com.example.qwe.yakovlev.products;

import com.example.qwe.ShowProducts;

import java.util.ArrayList;

public class Cart {
    ArrayList<Product> cart;
    ItemsService itemsService = new ItemsService();

    public Cart() {
        cart = new ArrayList<>();
    }

    public void add(int index) {
        cart.add(itemsService.get(index));
    }

    public ArrayList<Product> getList() {
        return cart;
    }
}

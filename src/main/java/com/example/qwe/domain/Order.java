package com.example.qwe.domain;

import java.util.List;

public class Order {
    private int orderNumber;
    private String login;
    private String address;
    private List<Item>items;

    public Order(int orderNumber, Order order) {
        this(orderNumber, order.login, order.address, order.items);
    }

    public Order(int orderNumber, String login, String address, List<Item> items) {
        this.orderNumber = orderNumber;
        this.login = login;
        this.address = address;
        this.items = items;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

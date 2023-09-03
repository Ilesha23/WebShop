package com.example.qwe.yakovlev.products;

public enum MouseType {
    LASER("laser"),
    OPTICAL("optical");

    private String type;

    private MouseType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

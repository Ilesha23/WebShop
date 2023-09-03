package com.example.qwe.yakovlev.products;

public enum SwitchType {
    MEMBRANE("membrane"),
    MECHANICAL("mechanical"),
    OPTICAL("optical");

    private final String type;
    private SwitchType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

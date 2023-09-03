package com.example.qwe.yakovlev.products;

public enum PlasticType {
    ABS("abs"),
    PBT("pbt");

    private String type;
    private PlasticType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

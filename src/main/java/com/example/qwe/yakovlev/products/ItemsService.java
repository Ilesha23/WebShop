package com.example.qwe.yakovlev.products;

import java.util.ArrayList;

public class ItemsService {
    private ArrayList<Product> container;
    public ItemsService() {
        container = new ArrayList<>();
        container.add(new Keyboard("kb", 40, 100, PlasticType.PBT, SwitchType.MEMBRANE));
        container.add(new Keyboard("kb1", 50, 60, PlasticType.PBT, SwitchType.MECHANICAL));
        container.add(new Mouse("m", 45, 2, MouseType.LASER));
        container.add(new Mouse("m1", 30, 3, MouseType.OPTICAL));
    }

    public ArrayList<Product> getList() {
        return container;
    }

    public Product get(int index) {
        return container.get(index);
    }
}

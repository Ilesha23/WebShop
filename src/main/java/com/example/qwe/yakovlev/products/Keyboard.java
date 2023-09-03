package com.example.qwe.yakovlev.products;

import java.io.Serializable;

public class Keyboard extends Product implements Ikeyboard, Serializable {
    private double size;
    private PlasticType plasticType;
    private SwitchType switchType;
    private static int count = 0;
    private static double sumPrice = 0.0;

    public Keyboard() {
        size = 0.0;
        plasticType = PlasticType.ABS;
        switchType = SwitchType.MEMBRANE;
        count++;
        sumPrice += getPrice();
    }

    public Keyboard(String name, double price, double size, PlasticType plasticType, SwitchType switchType) {
        super(name, price);
        this.size = size;
        this.plasticType = plasticType;
        this.switchType = switchType;
        count++;
        sumPrice += getPrice();
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public PlasticType getPlasticType() {
        return plasticType;
    }

    public void setPlasticType(PlasticType plasticType) {
        this.plasticType = plasticType;
    }

    public SwitchType getSwitchType() {
        return switchType;
    }

    public void setSwitchType(SwitchType switchType) {
        this.switchType = switchType;
    }

    public static double getAvgPrice() {
        return sumPrice / count;
    }

    @Override
    public String toString() {
        return "Product:keyboard " + super.toString() + " Size:" + size + " Plastic:" + plasticType.getType() + " Switches:" + switchType.getType();
    }
}

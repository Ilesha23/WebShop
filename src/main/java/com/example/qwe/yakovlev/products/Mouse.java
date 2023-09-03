package com.example.qwe.yakovlev.products;

import java.io.Serializable;

public class Mouse extends Product implements Imouse, Serializable {
    private int buttons;
    private MouseType mouseType;
    private static int count = 0;
    private static double sumPrice = 0.0;

    public Mouse() {
        buttons = 0;
        mouseType = MouseType.LASER;
        count++;
        sumPrice += getPrice();
    }

    public Mouse(String name, double price, int buttons, MouseType mouseType) {
        super(name, price);
        this.buttons = buttons;
        this.mouseType = mouseType;
        count++;
        sumPrice += getPrice();
    }

    public int getButtons() {
        return buttons;
    }

    public void setButtons(int buttons) {
        this.buttons = buttons;
    }

    public MouseType getMouseType() {
        return mouseType;
    }

    public void setMouseType(MouseType mouseType) {
        this.mouseType = mouseType;
    }

    public static double getAvgPrice() {
        return sumPrice / count;
    }

    @Override
    public String toString() {
        return "Product:mouse " + super.toString() + " Buttons:" + buttons + " Type:" + mouseType.getType();
    }
}

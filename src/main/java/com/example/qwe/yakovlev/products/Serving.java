package com.example.qwe.yakovlev.products;

import java.util.ArrayList;
import java.util.Scanner;

public class Serving {
    private final Container<Product> cont;
    private ArrayList<Product> cart = new ArrayList<>();
    public Serving(Container<Product> c) {
        cont = c;
    }
    public void performAction(int n) {
        switch (n) {
            case 1 -> System.out.println(cont);
            case 2 -> add();
            case 3 -> addToCart();
            case 4 -> printCart();
            case 5 -> order();
            case 6 -> cart.clear();
        }
    }

    private void order() {
        double sum = 0;
        for (Product p : cart) {
            sum += p.getPrice();
        }
        System.out.println("number: " + cart.size() + "; price: " + sum);
    }

    private void printCart() {
        StringBuilder result = new StringBuilder("");
        for (Product product : cart) {
            result.append(product.toString()).append('\n');
        }
        System.out.println(result);
    }

    private void addToCart() {
        System.out.println("enter index of product: ");
        int index = new Scanner(System.in).nextInt();
        cart.add(cont.get(index));
    }

    private void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - keyboard");
        System.out.println("2 - mouse");
        int type = scan.nextInt();
        switch (type) {
            case 1 -> addKeyboard();
            case 2 -> addMouse();
        }
    }

    private void addMouse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name: ");
        String name = scan.next();
        System.out.println("enter price: ");
        double price = scan.nextDouble();
        System.out.println("enter buttons: ");
        int buttons = scan.nextInt();
        System.out.println("enter mouse type: ");
        String mt = scan.next();

        cont.add(new Mouse(name, price, buttons, MouseType.valueOf(mt)));
    }

    private void addKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter name: ");
        String name = scan.next();
        System.out.println("enter price: ");
        double price = scan.nextDouble();
        System.out.println("enter size: ");
        double size = scan.nextDouble();
        System.out.println("enter plastic type: ");
        String pt = scan.next();
        System.out.println("enter switch type: ");
        String st = scan.next();

        cont.add(new Keyboard(name, price, size, PlasticType.valueOf(pt), SwitchType.valueOf(st)));
    }

    public void mainMenu() {
        System.out.println("1 - print container");
        System.out.println("2 - add to container");
        System.out.println("3 - add to cart");
        System.out.println("4 - print cart");
        System.out.println("5 - place an order");
        System.out.println("6 - clear cart");
    }
}

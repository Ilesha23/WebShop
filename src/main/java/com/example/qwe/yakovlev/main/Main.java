package com.example.qwe.yakovlev.main;

import com.example.qwe.yakovlev.products.*;

import java.util.Scanner;

public class Main {
    public static Container<Product> container;
    public static void main(String[] args) {
        Keyboard kb = new Keyboard("kb", 40, 100, PlasticType.PBT, SwitchType.MEMBRANE);
        Keyboard kb1 = new Keyboard("kb1", 50, 60, PlasticType.PBT, SwitchType.MECHANICAL);
        Mouse m = new Mouse("m", 45, 2, MouseType.LASER);
        Mouse m1 = new Mouse("m1", 30, 3, MouseType.OPTICAL);

        /*Container<Product> */container = new Container<>();
        container.add(kb);
        container.add(kb1);
        container.add(m);
        container.add(m1);


//        container.deserialize();

//        Scanner scan = new Scanner(System.in);
//        int choice = 0;
//        do {
//            Serving cmd = new Serving(container);
//            cmd.mainMenu();
//            choice = scan.nextInt();
//            cmd.performAction(choice);
//        } while (choice > 0);

//        container.serialize();

    }

    public static Container<Product> get() {
        main(new String[]{});
        return container;
    }
}

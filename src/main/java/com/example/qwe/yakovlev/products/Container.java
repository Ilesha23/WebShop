package com.example.qwe.yakovlev.products;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * container for products using simple array Product[]
 */
public class Container<T extends Product> implements Iterable<T>, Serializable {
    private T[] container;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public Container(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("Wrong capacity: " + capacity);
        }
        this.capacity = capacity;
        container = (T[]) new Product[capacity];
    }

    public Container() {
        this(DEFAULT_CAPACITY);
    }
    
    public void add(T item) {
        if (size == container.length){
            resize(2 * container.length);
        }
        container[size++] = item;
    }
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = container[i];
        }
        container = temp;
    }
    public int size(){
        return size;
    }
    public T get(int index) {
        if (index >= 0 && index < size){
            return (T) container[index];
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ContainerIterator<>(container, size);
    }

    /**
     * sorts array using simple bubble sort
     */
    public void sort(Comparator<T> comparator){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                    if (comparator.compare(container[j], container[j + 1]) > 0) {
                    T temp = container[j];
                    container[j] = container[j + 1];
                    container[j + 1] = temp;
                }
            }
        }
    }

    public void serialize() {
        try {
            FileOutputStream fileCont = new FileOutputStream("container.txt");
            ObjectOutputStream contOut = new ObjectOutputStream(fileCont);

            FileOutputStream fileSize = new FileOutputStream("container-size.txt");
            ObjectOutputStream sizeOut = new ObjectOutputStream(fileSize);

            Field cont = Container.class.getDeclaredField("container");
            cont.setAccessible(true);
            Object obj = cont.get(this);

            Field size = Container.class.getDeclaredField("size");
            size.setAccessible(true);
            Object s = size.get(this);

            contOut.writeObject(obj);
            sizeOut.writeObject(s);
//            out.writeObject(this);
            contOut.close();
            fileCont.close();
            sizeOut.close();
            fileSize.close();
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void deserialize() {
        try {
            FileInputStream fileCont = new FileInputStream("container.txt");
            ObjectInputStream inCont = new ObjectInputStream(fileCont);

            FileInputStream fileSize = new FileInputStream("container-size.txt");
            ObjectInputStream inSize = new ObjectInputStream(fileSize);

            Field cont = Container.class.getDeclaredField("container");
            cont.setAccessible(true);
            Object obj = inCont.readObject();
            cont.set(this, obj);

            Field size = Container.class.getDeclaredField("size");
            size.setAccessible(true);
            Object s = inSize.readObject();
            size.set(this, s);

            //container = (T[]) in.readObject();
            inCont.close();
            fileCont.close();
            inSize.close();
            fileSize.close();
        } catch (IOException | NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            result.append(container[i].toString()).append('\n');
        }
        return result.toString();
    }

    public Iterator<Product> iterator(double min, double max) {
        return new Iterator<Product>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                while (currentIndex < size) {
                    Product p = container[currentIndex];
                    if (p.getPrice() >= min && p.getPrice() <= max) {
                        return true;
                    }
                    currentIndex++;
                }
                return false;
            }

            @Override
            public Product next() {
                /*while (currentIndex < size) {
                    Product p = container[currentIndex];
                    currentIndex++;
                    if (p.getPrice() >= min && p.getPrice() <= max) {
                        return p;
                    }
                }*/
                if (hasNext()){
                    return container[currentIndex++];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public class ContainerIterator<T> implements Iterator<T> {
        private final Object[] container;
        int currentIndex;
        //private final int size;

        public ContainerIterator(Object[] container, int size) {
            this.container = container;
            //this.size = size;
            currentIndex = size - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return (T) container[currentIndex--];
        }

    }



}

package com.codecool;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("iterator");
        dynamicArray.add("is");
        dynamicArray.add("not");
        dynamicArray.add("working");
        Iterator<String> iterator = dynamicArray.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("not")) {
                iterator.remove();
            }
        }
        System.out.println(dynamicArray);
    }
}

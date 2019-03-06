package com.codecool;

import java.util.Arrays;

public class App {
    public static void main( String[] args ) {
        int[] array = {4, 3, 654, 24, 5325, 24, 656, 75, 2, 1, 3, 55, 0, 65, 14, 65, 342, 345, 768, 876834, 2345, 55324, 3, 45, 2, 1, 8, 9};
//        int[] array = {2, 5, 1, 6, 3, 7};
        Quicksort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}

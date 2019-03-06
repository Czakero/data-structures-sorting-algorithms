package com.codecool;

import java.util.concurrent.ThreadLocalRandom;

class Quicksort {
    static void sort(int[] array) {
        if (array != null && array.length != 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin < end + 1) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }
    private static int partition(int[] array, int begin, int end) {
        swap(array, begin, getPivot(begin, end));
        int pointer = begin + 1;
        for (int i = pointer; i < end + 1; i++) {
            if (array[i] < array[begin]) {
                swap(array, pointer++, i);
            }
        }
        swap(array, begin, pointer - 1);
        return pointer - 1;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static int getPivot(int begin, int end) {
        return ThreadLocalRandom.current().nextInt(begin, end + 1);
    }
}
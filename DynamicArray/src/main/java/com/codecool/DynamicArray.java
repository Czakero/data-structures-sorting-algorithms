package com.codecool;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

public class DynamicArray<T> implements Iterable<T>, RandomAccess {
    private static final int DEFAULT_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 0.7f;
    private static final float GROW_RATE = 1.5f;
    private static final float HALF_FACTOR = 0.5f;
    private T[] data;
    private volatile int size = 0;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return this.size;
    }

    public int dataLength() {
        return this.data.length;
    }

    public synchronized boolean add(T element) {
        this.data[this.size++] = element;
        this.resizeArray();
        return true;
    }

    public T get(int index) {
        this.rangeCheck(index);
        return this.data[index];
    }

    @SuppressWarnings("unchecked")
    public synchronized void remove(int index) {
        rangeCheck(index);
        T[] newData = (T[]) new Object[this.data.length];
        for (int i = 0; i < this.size; i++) {
            if (i < index) {
                newData[i] = this.data[i];
            } else if (i > index) {
                newData[i - 1] = this.data[i];
            }
        }
        this.size--;
        this.data = newData;
        this.resizeArray();
    }

    private void rangeCheck(int index) {
        if (this.size == 0 & index == 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int var1) {
        return "Index: " + var1 + ", Size: " + this.size;
    }

    private void resizeArray() {
        if (this.size >= Math.floor(this.data.length * DEFAULT_LOAD_FACTOR)) {
            this.data = Arrays.copyOf(this.data, (int) (Math.floor(this.data.length * GROW_RATE)));
        } else if (this.size <= this.data.length * HALF_FACTOR && this.data.length > DEFAULT_CAPACITY) {
            this.data = Arrays.copyOf(this.data, (int) (Math.floor(this.data.length * DEFAULT_LOAD_FACTOR)) + 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return data[index++];
            }

            @Override
            public void remove() {
                DynamicArray.this.remove(index - 1);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= this.size - 1; i++) {
            sb.append(this.data[i]);
            if (i != this.size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

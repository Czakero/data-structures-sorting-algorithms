package com.codecool.krk;

import com.codecool.krk.Exceptions.EmptyStackException;
import com.codecool.krk.Exceptions.StackOverflowException;
import com.codecool.krk.Exceptions.StackUnderflowException;

public class Stack<T> {
    private static final int DEFAULT_LENGTH = 0;
    private T[] stack;
    private int length;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.stack = (T[]) new Object[size];
        this.size = size;
        this.length = DEFAULT_LENGTH;
    }

    public void push(T data) {
        if (stackIsFull()) {
            throw new StackOverflowException();
        } else {
            stack[getLength()] = data;
            incrementLength();
        }
    }

    private boolean stackIsFull() {
        return getLength() == getSize();
    }

    public void pop() {
        if (stackIsEmpty()) {
            throw new StackUnderflowException();
        } else {
            stack[getLength() - 1] = null;
            decrementLength();
        }
    }

    public T peek() {
        if (stackIsEmpty()) throw new EmptyStackException();
        return this.stack[getLength() - 1];
    }

    private boolean stackIsEmpty() {
        return getLength() == 0;
    }

    public int getLength() {
        return this.length;
    }

    private void incrementLength() {
        this.length++;
    }

    private void decrementLength() {
        this.length--;
    }
    public int getSize() {
        return this.size;
    }
    public int getLeftSpace() {
        return this.size - this.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getLength(); i++) {
            sb.append(" ").append(this.stack[i]);
        }
        return sb.toString();
    }
}

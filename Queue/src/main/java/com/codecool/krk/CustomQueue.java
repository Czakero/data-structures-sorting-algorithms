package com.codecool.krk;

import Exceptions.EmptyQueueException;

public class CustomQueue {
    private static final int DEFAULT_SIZE = 0;
    private Node head;
    private Node tail;
    private int size;

    public CustomQueue() {
        this.head = null;
        this.tail = null;
        this.size = DEFAULT_SIZE;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    private void setHead(Node node) {
        this.head = node;
    }

    private void setTail(Node node) {
        this.tail = node;
    }

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (getSize() == 0) {
            setHead(newNode);
            setTail(newNode);
            incrementSize();
        } else {
            getTail().setNextNodeReference(newNode);
            setTail(newNode);
            incrementSize();
        }
    }

    public String dequeue() {
        if (isEmpty()) throw new EmptyQueueException();
        Node dequequedNode = getHead();
        setHead(getHead().getNextNodeReference());
        decrementSize();
        return dequequedNode.getData();
    }

    public String peek() {
        if (isEmpty()) throw new EmptyQueueException();
        return getHead().getData();
    }

    public int queueSize() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node pointer = getHead();
        while (pointer != null) {
            sb.append(" ").append(pointer.getData());
            pointer = pointer.getNextNodeReference();
        }

        return sb.toString();
    }
}

class Node {

    private String data;
    private Node nextNodeReference;

    public Node(String data) {
        this.data = data;
        this.nextNodeReference = null;
    }
    public String getData() {
        return this.data;
    }
    public Node getNextNodeReference() {
        return nextNodeReference;
    }
    public void setNextNodeReference(Node nextNodeReference) {
        this.nextNodeReference = nextNodeReference;
    }
}

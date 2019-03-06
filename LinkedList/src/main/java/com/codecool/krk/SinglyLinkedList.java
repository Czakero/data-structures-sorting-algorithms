package com.codecool.krk;

public class SinglyLinkedList<T> {
    private static final int DEFAULT_LENGTH = 0;
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = DEFAULT_LENGTH;
    }
    private void incrementLength() {
        this.length++;
    }
    private void decrementLength() {
        this.length--;
    }

    private void setHead(Node<T> head) {
        this.head = head;
    }

    private void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > getLength() - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> pointer = getHead();
            int counter = 0;
            while (pointer != null) {
                if (counter == index) {
                    newNode.setNextNodeRef(getHead());
                    setHead(newNode);
                    incrementLength();
                    break;
                } else if (counter + 1 == index) {
                    newNode.setNextNodeRef(pointer.getNextNodeRef());
                    pointer.setNextNodeRef(newNode);
                    incrementLength();
                    break;
                }
                pointer = pointer.getNextNodeRef();
                counter++;
            }
        }

    }

    public void remove(int index) {
        if (index < 0 || index > getLength() - 1) {
            throw new IndexOutOfBoundsException();
        } else if (getLength() == 1) {
            setHead(null);
            setTail(null);
            decrementLength();
        } else if (index == 0 && getLength() > 1) {
            setHead(getHead().getNextNodeRef());
            decrementLength();
        } else {
            Node<T> pointer = getHead();
            int counter = 0;
            while (pointer != null) {
                if (counter + 1 == index) {
                    if (pointer.getNextNodeRef().getNextNodeRef() != null) {
                        pointer.setNextNodeRef(pointer.getNextNodeRef().getNextNodeRef());
                        break;
                    } else {
                        pointer.setNextNodeRef(null);
                        setTail(pointer);
                        break;
                    }
                }
                pointer = pointer.getNextNodeRef();
                counter++;
            }
            decrementLength();
        }
    }

    public Node<T> getByIndex(int index) {
        Node<T> result = null;
        if (index < 0 || index > getLength() - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            int counter = 0;
            Node<T> pointer = this.head;
            while (pointer != null) {
                if (counter == index) {
                    result = pointer;
                    break;
                }
                pointer = pointer.getNextNodeRef();
                counter++;
            }
        }
        return result;
    }

    public Node<T> getByValue(T data) {
        Node<T> foundNode = null;
        Node<T> pointer = getHead();
        while (pointer != null) {
            if (pointer.compareTo(data) == 0) {
                foundNode = pointer;
                break;
            }
            pointer = pointer.getNextNodeRef();
        }
        return foundNode;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (getLength() == 0) {
            setHead(newNode);
        } else {
            this.tail.setNextNodeRef(newNode);
        }
        setTail(newNode);
        incrementLength();
    }

    public String toString() {
        Node<T> pointer = getHead();
        StringBuilder sb = new StringBuilder();

        while (pointer != null) {
            sb.append(" ").append(pointer.getData());
            pointer = pointer.getNextNodeRef();
        }
        return sb.toString();
    }

}

class Node<T> implements Comparable<T> {

    private T data;
    private Node<T> nextNodeRef;

    public Node(T data) {
        setData(data);
        this.nextNodeRef = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    protected void setNextNodeRef(Node<T> nextNodeRef) {
        this.nextNodeRef = nextNodeRef;
    }

    public Node<T> getNextNodeRef() {
        return this.nextNodeRef;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public int compareTo(T value) {
        if (this.data.equals(value)) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", nextNodeRef=" + nextNodeRef +
                '}';
    }
}


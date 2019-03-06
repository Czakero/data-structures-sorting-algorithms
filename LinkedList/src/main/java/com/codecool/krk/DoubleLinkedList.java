package com.codecool.krk;

public class DoubleLinkedList<T> {
    private static final int DEFAULT_LENGTH = 0;
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int length;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = DEFAULT_LENGTH;
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

    public DoubleNode<T> getHead() {
        return this.head;
    }

    private void setHead(DoubleNode<T> head) {
        this.head = head;
    }

    public DoubleNode<T> getTail() {
        return this.tail;
    }

    private void setTail(DoubleNode<T> tail) {
        this.tail = tail;
    }

    public void insert(int index, T data) {
        if (indexOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            DoubleNode<T> newNode = new DoubleNode<>(data);
            DoubleNode<T> pointer = getHead();
            int counter = 0;
            while (pointer != null) {
                if (counter == index) {
                    newNode.setNextNodeRef(getHead());
                    newNode.setPreviousNodeRef(null);
                    getHead().setPreviousNodeRef(newNode);
                    setHead(newNode);
                    incrementLength();
                    break;
                } else if (counter + 1 == index) {
                    newNode.setNextNodeRef(pointer.getNextNodeRef());
                    pointer.getNextNodeRef().setPreviousNodeRef(newNode);
                    newNode.setPreviousNodeRef(pointer);
                    pointer.setNextNodeRef(newNode);
                    incrementLength();
                    break;
                }
                pointer = pointer.getNextNodeRef();
                counter++;
            }
        }

    }

    public void add(T data) {
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if (getLength() == 0) {
            setHead(newNode);
        } else {
            getTail().setNextNodeRef(newNode);
            newNode.setPreviousNodeRef(getTail());
        }
        setTail(newNode);
        incrementLength();
    }

    public DoubleNode<T> getByIndex(int index) {
        DoubleNode<T> foundNode = null;
        if (indexOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            int counter = 0;
            DoubleNode<T> pointer = getHead();
            while (pointer != null) {
                if (counter == index)  {
                    foundNode = pointer;
                    break;
                }
                pointer = pointer.getNextNodeRef();
                counter++;
            }
        }
        return foundNode;
    }

    public void remove(int index) {
        if (indexOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        } else if (onlyOneObjectInList(index)) {
            setHead(null);
            setTail(null);
            decrementLength();
        } else if (removingHeadFromNotEmptyList(index)) {
            setHead(getHead().getNextNodeRef());
            getHead().setPreviousNodeRef(null);
            decrementLength();
        } else {
            int counter = 0;
            DoubleNode<T> pointer = getHead();
            while (pointer != null) {
                if (counter + 1 == index) {
                    if (isNextNextReferenceNotNull(pointer)) {
                        connectReferences(pointer);
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

    private boolean removingHeadFromNotEmptyList(int index) {
        return index == 0 && getLength() > 1;
    }

    private boolean onlyOneObjectInList(int index) {
        return getLength() == 1 && index == 0;
    }

    private boolean indexOutOfRange(int index) {
        return index < 0 || index > getLength() - 1;
    }

    private boolean isNextNextReferenceNotNull(DoubleNode<T> pointer) {
        return pointer.getNextNodeRef().getNextNodeRef() != null;
    }

    private void connectReferences(DoubleNode<T> pointer) {
        DoubleNode<T> removedObjectNextReference = pointer.getNextNodeRef().getNextNodeRef();
        pointer.setNextNodeRef(pointer.getNextNodeRef().getNextNodeRef());
        removedObjectNextReference.setPreviousNodeRef(pointer);
    }

    public String toString() {
        DoubleNode<T> pointer = getHead();
        StringBuilder sb = new StringBuilder();

        while (pointer != null) {
            sb.append(" ").append(pointer.getData());
            pointer = pointer.getNextNodeRef();
        }
        return sb.toString();
    }

    public String reverseToString() {
        DoubleNode<T> pointer = getTail();
        StringBuilder sb = new StringBuilder();

        while (pointer != null) {
            sb.append(" ").append(pointer.getData());
            pointer = pointer.getPreviousNodeRef();
        }
        return sb.toString();
    }
}
class DoubleNode<T> implements Comparable<T> {

    private T data;
    private DoubleNode<T> nextNodeRef;
    private DoubleNode<T> previousNodeRef;


    public DoubleNode(T data) {
        this.data = data;
        this.nextNodeRef = null;
        this.previousNodeRef = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNodeRef(DoubleNode<T> nextNodeRef) {
        this.nextNodeRef = nextNodeRef;
    }

    public void setPreviousNodeRef(DoubleNode<T> previousNodeRef) {
        this.previousNodeRef = previousNodeRef;
    }

    public DoubleNode<T> getPreviousNodeRef() {
        return this.previousNodeRef;
    }

    public DoubleNode<T> getNextNodeRef() {
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
}

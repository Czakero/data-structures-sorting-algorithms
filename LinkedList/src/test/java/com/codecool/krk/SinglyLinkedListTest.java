package com.codecool.krk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    public void testInsertingObjectAtLastPositionInNotEmptyList() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 3 4 5 6 7 8 10 9";

        linkedList.insert(9, 10);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testInsertingObjectAtIndexZeroInNotEmptyList() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        String expected = " 2 0 1 2 3 4 5 6 7 8 9";

        linkedList.insert(0, 2);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void checkIfInsertingOnIndexOutOfBoundsThrowsException() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();

        assertThrows(IndexOutOfBoundsException.class, () -> {
           linkedList.insert(-100, 0);
           linkedList.insert(10, 0);
        });
    }

    @Test
    public void testInsertingObjectIntoNotEmptyList() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 25 3 4 5 6 7 8 9";

        linkedList.insert(3, 25);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testRemovingObjectWithIndexZeroFromNotEmptyList() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        String expected = " 1 2 3 4 5 6 7 8 9";

        linkedList.remove(0);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testRemovingTheOnlyOneObjectInListByIndex() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        String expected = "";
        linkedList.add(1);

        linkedList.remove(0);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void checkIfRemoveByIndexOutOfBoundsThrowsException() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-200));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(100));
    }

    @Test
    public void testRemoveByIndex() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 3 5 6 7 8 9";

        linkedList.remove(4);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testRemovingLastNodeByIndex() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 3 4 5 6 7 8";

        linkedList.remove(9);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testIfGetByValueReturnsProperObject() {
        SinglyLinkedList<String> linkedList = getNotEmptyStringList();
        String expected = "7";
        String expectedNextNodeValue = "8";

        Node<String> foundNode = linkedList.getByValue("7");
        String resultOfNextNodeValue = foundNode.getNextNodeRef().getData();

        assertEquals(expected, foundNode.getData());
        assertEquals(expectedNextNodeValue, resultOfNextNodeValue);
    }

    @Test
    public void testIfGetByIndexThrowsExceptionWhenPassingIndexesOutOfBounds() {
        SinglyLinkedList<String> linkedList = getNotEmptyStringList();

        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getByIndex(-100));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.getByIndex(100));
    }

    @Test
    public void testIfGetByIndexReturnsProperObject() {
        SinglyLinkedList<String> linkedList = getNotEmptyStringList();
        String expected = "3";

        Node<String> result = linkedList.getByIndex(3);

        assertEquals(expected, result.getData());
    }

    @Test
    public void testReferenceBetweenFirstAndSecondElement() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        Node<Integer> firstNode = linkedList.getByIndex(1);
        Node<Integer> secondNode = linkedList.getByIndex(2);

        assertEquals(firstNode.getNextNodeRef(), secondNode);
    }

    @Test
    public void testAddingIntegerToEmptyList() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        String expected = " 3";

        linkedList.add(3);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testIfAddingToEmptyListMakesHeadAndTailEqual() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.add(100);

        assertEquals(linkedList.getTail().getData(), linkedList.getHead().getData());
    }

    @Test
    public void testAddingNumberToNotEmptyList() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 3 4 5 6 7 8 9 20";

        linkedList.add(20);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testAddingNumberToListWithOneElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        String expected = " 1 2";
        linkedList.add(1);

        linkedList.add(2);

        assertEquals(expected, linkedList.toString());
    }

    @Test
    public void testIfLengthIsIncrementingProperly() {
        SinglyLinkedList<Integer> linkedList = getNotEmptyIntegerList();

        assertEquals(10, linkedList.getLength());
    }

    private SinglyLinkedList<String> getNotEmptyStringList() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(Integer.toString(i));
        }
        return linkedList;
    }

    private SinglyLinkedList<Integer> getNotEmptyIntegerList() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        for (Integer i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        return linkedList;
    }

}
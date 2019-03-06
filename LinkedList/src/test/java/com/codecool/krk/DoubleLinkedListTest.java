package com.codecool.krk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @Test
    public void testPreviousNdeReferencesAfterRemovingDataAtLastIndexFromNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 8 7 6 5 4 3 2 1 0";

        doubleLinkedList.remove(9);

        assertEquals(expected, doubleLinkedList.reverseToString());
    }

    @Test
    public void testPreviousNodeReferencesAfterRemovingDataAtIndexZeroFromNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 9 8 7 6 5 4 3 2 1";

        doubleLinkedList.remove(0);

        assertEquals(expected, doubleLinkedList.reverseToString());
    }

    @Test
    public void testPreviousNodeReferencesAfterRemovingDataFromNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 9 8 6 5 4 3 2 1 0";

        doubleLinkedList.remove(7);

        assertEquals(expected, doubleLinkedList.reverseToString());
    }

    @Test
    public void testPreviousNodeReferencesAfterInsertingDataAtLastIndexInNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 9 20 8 7 6 5 4 3 2 1 0";

        doubleLinkedList.insert(9, 20);

        assertEquals(expected, doubleLinkedList.reverseToString());
    }
    @Test
    public void testPreviousNodeReferencesAfterInsertingDataInNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 9 8 7 6 10 5 4 3 2 1 0";

        doubleLinkedList.insert(6, 10);

        assertEquals(expected, doubleLinkedList.reverseToString());
    }

    @Test
    public void testPreviousNodeReferencesAfterInsertingObjectAtIndexZero() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 9 8 7 6 5 4 3 2 1 0 10";

        doubleLinkedList.insert(0, 10);

        assertEquals(expected, doubleLinkedList.reverseToString());
    }

    @Test
    public void testInsertingObjectAtLastIndexInNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 3 4 5 6 7 8 10 9";

        doubleLinkedList.insert(9, 10);

        assertEquals(expected, doubleLinkedList.toString());
    }

    @Test
    public void testSimpleInserting() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 0 1 5 2 3 4 5 6 7 8 9";

        doubleLinkedList.insert(2, 5);

        assertEquals(expected, doubleLinkedList.toString());
    }


    @Test
    public void checkInsertingObjectAtIndexZeroInNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 10 0 1 2 3 4 5 6 7 8 9";

        doubleLinkedList.insert(0, 10);

        assertEquals(expected, doubleLinkedList.toString());
    }

    @Test
    public void checkIfInsertingAtIndexOutOfBoundsThrowsException() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();

        assertThrows(IndexOutOfBoundsException.class, () -> {
           doubleLinkedList.insert(-100, 2);
           doubleLinkedList.insert(10, 5);
        });
    }

    @Test
    public void testRemovingObjectWithIndexZeroFromNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 1 2 3 4 5 6 7 8 9";

        doubleLinkedList.remove(0);

        assertEquals(expected, doubleLinkedList.toString());
    }

    @Test
    public void testIfLengthIsDecrementingProperly() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        int expected = 6;

        doubleLinkedList.remove(0);
        doubleLinkedList.remove(0);
        doubleLinkedList.remove(0);
        doubleLinkedList.remove(0);

        assertEquals(expected, doubleLinkedList.getLength());
    }

    @Test
    public void testIfLengthIsIncrementingProperly() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        int expected = 10;

        assertEquals(expected, doubleLinkedList.getLength());
    }

    @Test
    public void testRemovingManyObjectsFromNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 0 2 4 6 8";

        doubleLinkedList.remove(1);
        doubleLinkedList.remove(2);
        doubleLinkedList.remove(3);
        doubleLinkedList.remove(4);
        doubleLinkedList.remove(5);

        assertEquals(expected, doubleLinkedList.toString());
    }

    @Test
    public void testRemovingLastObjectFromNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 3 4 5 6 7 8";

        doubleLinkedList.remove(9);

        assertEquals(expected, doubleLinkedList.toString());
    }

    @Test
    public void testRemovingObjectFromNotEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 4 5 6 7 8 9";

        doubleLinkedList.remove(3);

        assertEquals(expected, doubleLinkedList.toString());

    }

    @Test
    public void testRemovingObjectFromListWithOnlyOneObject() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add("TEST");
        String expected = "";

        doubleLinkedList.remove(0);

        assertEquals(expected, doubleLinkedList.toString());
    }

    @Test
    public void checkIfRemoveThrowsExceptionWhenPassingIndexOutOfBounds() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            doubleLinkedList.remove(-100);
            doubleLinkedList.remove(10);
        });
    }

    @Test
    public void testIfGetByIndexReturnsProperObject() {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();
        DoubleNode<String> expected = new DoubleNode<>("TEST");
        doubleLinkedList.add("TEST");

        DoubleNode<String> result = doubleLinkedList.getByIndex(0);

        assertEquals(expected.getData(), result.getData());
    }

    @Test
    public void checkIfGetByIndexWithIndexOutOfBoundsThrowsException() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();


        assertThrows(IndexOutOfBoundsException.class, () -> {
            doubleLinkedList.getByIndex(-100);
            doubleLinkedList.getByIndex(10);
        });
    }

    @Test
    public void testReferencesBetweenThreeObjects() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        DoubleNode<Integer> firstNode = doubleLinkedList.getByIndex(0);
        DoubleNode<Integer> secondNode = doubleLinkedList.getByIndex(1);
        DoubleNode<Integer> thirdNode = doubleLinkedList.getByIndex(2);


        assertEquals(firstNode.getNextNodeRef(), secondNode);
        assertEquals(secondNode.getPreviousNodeRef(), firstNode);
        assertEquals(secondNode.getNextNodeRef(), thirdNode);
        assertEquals(thirdNode.getPreviousNodeRef(), secondNode);
    }

    @Test
    public void testSimpleAddingNumberToEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        String expected = " 10";

        doubleLinkedList.add(10);

        assertEquals(expected, doubleLinkedList.toString());
    }

    @Test
    public void testAddingMoreNumbersToEmptyList() {
        DoubleLinkedList<Integer> doubleLinkedList = getNotEmptyIntegerList();
        String expected = " 0 1 2 3 4 5 6 7 8 9";

        assertEquals(expected, doubleLinkedList.toString());
    }

    private DoubleLinkedList<Integer> getNotEmptyIntegerList() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        for (int i = 0; i < 10; i++) {
            doubleLinkedList.add(i);
        }

        return doubleLinkedList;
    }

}
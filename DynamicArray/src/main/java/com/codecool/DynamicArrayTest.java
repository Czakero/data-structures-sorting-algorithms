package com.codecool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicArrayTest {

    @Test
    public void testCreatingAndAddingToArray() {
        String expected = "[test, loop add, loop add, loop add, loop add, loop add, loop add, loop add, loop add, loop add, loop add]";
        DynamicArray<String> dynamicArray = new DynamicArray<>();

        dynamicArray.add("test");
        for (int i = 0; i < 10; i++) {
            dynamicArray.add("loop add");
        }

        assertEquals(expected, dynamicArray.toString());
    }

    @Test
    public void testIfGetMethodThrowsIndexOutOfBoundsException() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();

        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(1000));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(-1000));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(0));

        dynamicArray.add("test");

        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(dynamicArray.size()));
    }

    @Test
    public void testRemovingFromArray() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i);
        }
        String expected = "[1, 2, 4, 5, 7, 8, 9]";

        dynamicArray.remove(0);
        dynamicArray.remove(2);
        dynamicArray.remove(4);

        assertEquals(expected, dynamicArray.toString());
    }

    @Test
    public void testResizingArrayWhenAddingAndRemoving() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        int initialExpected = 10;
        int firstResizeExpected = 15;
        int afterShrinkExpected = 11;

        assertEquals(initialExpected, dynamicArray.dataLength());

        for (int i = 0; i < 8; i++) {
            dynamicArray.add(i);
        }

        assertEquals(firstResizeExpected, dynamicArray.dataLength());

        dynamicArray.remove(0);

        assertEquals(afterShrinkExpected, dynamicArray.dataLength());

    }

}

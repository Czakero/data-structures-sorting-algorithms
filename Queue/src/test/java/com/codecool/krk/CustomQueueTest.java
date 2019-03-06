package com.codecool.krk;

import Exceptions.EmptyQueueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    @Test
    public void testRemovingDataFromNotEmptyQueue() {
        CustomQueue customQueue = getCustomQueueWithExampleData();
        String expected_returned_data = "one";
        String expected_queue = " two three four";

        String result = customQueue.dequeue();

        assertEquals(expected_returned_data, result);
        assertEquals(expected_queue, customQueue.toString());
    }

    @Test
    public void checkIfRemovingDataFromEmptyQueueThrowsException() {
        CustomQueue customQueue = new CustomQueue();

        assertThrows(EmptyQueueException.class, customQueue::dequeue);
    }

    @Test
    public void checkIfPeekingOnEmptyQueueThrowsException() {
        CustomQueue customQueue = new CustomQueue();

        assertThrows(EmptyQueueException.class, customQueue::peek);
    }

    @Test
    public void testPeekingAtObjectInNotEmptyQueue() {
        CustomQueue customQueue = getCustomQueueWithExampleData();
        String expected = "one";

        assertEquals(expected, customQueue.peek());
    }

    @Test
    public void testAddingDataToNotEmptyQueue() {
        CustomQueue customQueue = getCustomQueueWithExampleData();
        String expected = " one two three four five";

        customQueue.enqueue("five");

        assertEquals(expected, customQueue.toString());
    }

    @Test
    public void testAddingDataToEmptyQueue() {
        CustomQueue customQueue = new CustomQueue();
        String expected = " test";

        customQueue.enqueue("test");

        assertEquals(expected, customQueue.toString());
    }

    private CustomQueue getCustomQueueWithExampleData() {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue("one");
        customQueue.enqueue("two");
        customQueue.enqueue("three");
        customQueue.enqueue("four");

        return customQueue;
    }

}
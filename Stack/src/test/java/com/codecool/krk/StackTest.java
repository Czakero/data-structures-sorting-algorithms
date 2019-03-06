package com.codecool.krk;

import com.codecool.krk.Exceptions.EmptyStackException;
import com.codecool.krk.Exceptions.StackOverflowException;
import com.codecool.krk.Exceptions.StackUnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testGetLeftSpaceMethodAfterPopingElementsFromFullStack() {
        Stack<Integer> stack = getFullIntegerStack();
        stack.pop();
        stack.pop();
        int expected = 2;

        int result = stack.getLeftSpace();

        assertEquals(expected, result);
    }
    @Test
    public void testGetLeftSpaceMethodOnFullStack() {
        Stack<Integer> stack = getFullIntegerStack();

        int expected = 0;

        int result = stack.getLeftSpace();

        assertEquals(expected, result);
    }

    @Test
    public void testPeekingAfterPopingElementFromStack() {
        Stack<Integer> stack = getFullIntegerStack();
        int expected = 8;
        stack.pop();

        int result = stack.peek();

        assertEquals(expected, result);
    }

    @Test
    public void testPeekingOnEmptyStackShouldThrowException() {
        Stack<Integer> stack = new Stack<>(10);

        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void testPeekingOnNotEmptyStack() {
        Stack<Integer> stack = getFullIntegerStack();
        int expected = 9;

        int result = stack.peek();

        assertEquals(expected, result);
    }
    @Test
    public void testFillingStackWithIntegers() {
        String expected = " 0 1 2 3 4 5 6 7 8 9";
        Stack<Integer> stack = getFullIntegerStack();

        assertEquals(expected, stack.toString());
    }

    @Test
    public void testPopingFromNotEmptyStack() {
        Stack<Integer> stack = getFullIntegerStack();
        String expected = " 0 1 2 3 4 5 6 7";

        stack.pop();
        stack.pop();

        assertEquals(expected, stack.toString());
    }
    @Test
    public void testIfPopingFromEmptyStackThrowsException() {
        Stack<Integer> stack = new Stack<>(10);

        assertThrows(StackUnderflowException.class, stack::pop);
    }

    @Test
    public void testPushingDataToStack() {
        Stack<Integer> stack = new Stack<>(10);
        String expected = " 1 2 3";

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(expected, stack.toString());
    }

    @Test
    public void testIfAddingDataToFullStackThrowsException() {
        Stack<Integer> stack = getFullIntegerStack();

        assertThrows(StackOverflowException.class, () -> stack.push(10));
    }

    private Stack<Integer> getFullIntegerStack() {
        Stack<Integer> stack = new Stack<>(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        return stack;

    }

}
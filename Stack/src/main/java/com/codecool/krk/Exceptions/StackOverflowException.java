package com.codecool.krk.Exceptions;

public class StackOverflowException extends RuntimeException {

    public StackOverflowException() {
        super();
    }

    public StackOverflowException(String message) {
        super(message);
    }
}

package com.codecool.krk.Exceptions;

public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super();
    }

    public EmptyStackException(String message) {
        super(message);
    }
}

package org.Exceptions;

public class InvalidAccountException extends Exception {
    public InvalidAccountException(){
    }

    public InvalidAccountException(String message) {
        super(message);
    }
}

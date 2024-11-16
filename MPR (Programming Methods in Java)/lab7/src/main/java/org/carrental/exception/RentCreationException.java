package org.carrental.exception;

public class RentCreationException extends RuntimeException {
    public RentCreationException(String message, Exception reason) {
        super(message, reason);
    }

    public RentCreationException(String message){
        super(message);
    }
}

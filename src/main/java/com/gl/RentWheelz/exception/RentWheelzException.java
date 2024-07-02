package com.gl.RentWheelz.exception;

public class RentWheelzException extends Exception{
    private String message;

    public RentWheelzException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}

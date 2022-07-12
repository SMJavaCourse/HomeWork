package org.course;
public class ApartmentException extends Exception {
    private final String context = "[ApartmentException]";
    private final int code = 404;
    private String message;

    public int getCode() {
        return code;
    }
    public String getContext() {
        return context;
    }

    public ApartmentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }



}

package com.rukbrook.exception;

public class CourseException extends RuntimeException {

    private String context;

    public CourseException(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }


}

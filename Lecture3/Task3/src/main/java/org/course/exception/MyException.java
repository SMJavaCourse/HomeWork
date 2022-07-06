package org.course.exception;

public class MyException extends Exception{
    String text;

    public MyException(String text) {
        this.text = text;
    }

    public String getTextException() {
        return text;
    }
}

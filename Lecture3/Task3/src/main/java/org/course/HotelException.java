package main.java.org.course;

public class HotelException extends Exception {
    private final String context = "[HotelException]";
    private final int code = 404;
    private String message;

    public int getCode() {
        return code;
    }
    public String getContext() {
        return context;
    }

    public HotelException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }



}

package main.java.org.course;

public class HotelException extends IndexOutOfBoundsException {
    private String context;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }
    public String getContext() {
        return context;
    }

    public HotelException(String context, int code, String message) {
        this.context = context;
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }



}

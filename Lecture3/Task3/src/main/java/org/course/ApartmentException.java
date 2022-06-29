package main.java.org.course;

public class ApartmentException extends HotelException {
    private String context;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }
    public String getContext() {
        return context;
    }

    public ApartmentException(String context, int code, String message) {
        super(context, code, message);
        this.context = context;
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }



}

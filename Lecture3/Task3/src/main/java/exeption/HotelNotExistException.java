package exeption;

public class HotelNotExistException extends Exception {
    public HotelNotExistException(String message) {
        super(message);
    }
}

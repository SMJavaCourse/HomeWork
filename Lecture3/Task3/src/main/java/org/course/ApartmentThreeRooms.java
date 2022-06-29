package main.java.org.course;

public class ApartmentThreeRooms extends Apartment {
    private static final String APART_TYPE = "Трехкомнатный номер";
    public ApartmentThreeRooms(float price, int places, int roomNumber) {
        super(price, places, roomNumber);
    }
    @Override
    public String getApartmentsTypeName() {
        return APART_TYPE;
    }
}

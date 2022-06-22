package org.course;

public class ThreeRoomApartment extends Apartment {
    private static final int NUMBER_OF_ROOMS = 3;

    public ThreeRoomApartment(double price, int numberOfRoom) {
        super(price, numberOfRoom);
    }
    public String getNameOfApartment(){
        return "Трехкомнатный номер";
    }
}

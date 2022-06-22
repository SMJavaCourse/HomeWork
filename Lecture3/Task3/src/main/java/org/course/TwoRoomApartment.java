package org.course;

public class TwoRoomApartment extends Apartment {
    private static final int NUMBER_OF_ROOMS = 2;

    public TwoRoomApartment(double price, int numberOfRoom) {
        super(price, numberOfRoom);
    }
    public String getNameOfApartment(){
        return "Двухкомнатный номер";
    }
}

package org.course;

public class OneRoomApartment extends Apartment {
    private static final int NUMBER_OF_ROOMS = 1;

    public OneRoomApartment(double price, int numberOfRoom) {
        super(price, numberOfRoom);

    }
    public String getNameOfApartment(){
        return "Однокомнатный номер";
    }

}

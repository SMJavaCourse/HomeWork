package org.course;

import org.course.exception.MyException;
import org.course.factory.HotelFactory;
import org.course.services.*;

import static org.course.Hotel.findHotels;

public class Task3 {

    public static void main(String[] args) throws MyException {

        Apartment[] allRoomsInHotel1 = new Apartment[5];
        allRoomsInHotel1[0] = new Apartment(1, 10, 1000, 2, new Balcony());
        allRoomsInHotel1[1] = new Apartment(2, 20, 3000, 4, new Balcony(),
                new Cleaning(), new Internet(512), new Conditioner());
        allRoomsInHotel1[2] = new Apartment(2, 30, 3000, 4, new Balcony(),
                new Cleaning(), new Internet(1024), new Conditioner());
        allRoomsInHotel1[3] = new Apartment(3, 40, 2500, 6);
        allRoomsInHotel1[4] = new Apartment(3, 50, 3500, 6, new Balcony(),
                new Internet(null), new Jacuzzi());

        Apartment[] allRoomsInHotel2 = new Apartment[3];
        allRoomsInHotel2[0] = new Apartment(1, 11, 1000, 2, new Meat());
        allRoomsInHotel2[1] = new Apartment(2, 22, 2000, 4, new Balcony(),
                new Cleaning());
        allRoomsInHotel2[2] = new Apartment(3, 33, 4000, 6, new Cleaning(),
                new Jacuzzi());

        HotelFactory factory = new HotelFactory();

        System.out.println("");

        Hotel[] hotels = new Hotel[2];
        hotels[0] = factory.createHotel("У мамы лучше", allRoomsInHotel1);
        hotels[1] = factory.createHotel("Шашлычок", allRoomsInHotel2);

        System.out.println(findHotels(hotels, "У мамы лучше", 5));

    }
}

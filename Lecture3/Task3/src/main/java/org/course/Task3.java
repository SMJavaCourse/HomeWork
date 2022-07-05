package org.course;

import org.course.services.*;

public class Task3 {

    public static void main(String[] args) {

        Apartment[] allRoomsInHotel1 = new Apartment[5];
        allRoomsInHotel1[0] = new OneRoomApartment(10,1000, new Balcony());
        allRoomsInHotel1[1] = new TwoRoomsApartment(20,3000, new Balcony(), new Cleaning(),
                new Internet(), new Conditioner());
        allRoomsInHotel1[2] = new TwoRoomsApartment(30,3000);
        allRoomsInHotel1[3] = new ThreeRoomsApartment(40,2500);
        allRoomsInHotel1[4] = new ThreeRoomsApartment(50,3500, new Balcony(), new Internet(),
                new Jacuzzi());

        Apartment[] allRoomsInHotel2 = new Apartment[3];
        allRoomsInHotel2[0] = new OneRoomApartment(11,1000, new Meat());
        allRoomsInHotel2[1] = new TwoRoomsApartment(22,2000, new Balcony(), new Cleaning());
        allRoomsInHotel2[2] = new ThreeRoomsApartment(33,4000, new Cleaning(), new Jacuzzi());

        Hotel uMamyLuchshe = new Hotel("У мамы лучше","12:00",allRoomsInHotel1);
        Hotel shashlichek = new Hotel("Шашлычок","09:00",allRoomsInHotel2);

        System.out.println("");
        System.out.println(uMamyLuchshe);
        System.out.println(shashlichek);

    }
}

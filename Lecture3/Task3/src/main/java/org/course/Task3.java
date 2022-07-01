package org.course;

import org.course.additions.*;
import org.course.apartments.OneRoomApartment;
import org.course.apartments.ThreeRoomsApartment;
import org.course.apartments.TwoRoomsApartment;

public class Task3 {
    public static void main(String[] args) {
        String[] additions;
        Balcony balcony = new Balcony();
        Cleaning cleaning = new Cleaning();
        Internet internet = new Internet();
        AirConditioner airConditioner = new AirConditioner();
        Kebab kebab = new Kebab();

        Apartment[] apartmentsMomHotel = new Apartment[5];
        Hotel momHotel = new Hotel("\"У мамы лучше\"", "12:00", apartmentsMomHotel);

        additions = new String[] {balcony.getName()};
        apartmentsMomHotel[0] = new OneRoomApartment(1500, 2, 13, additions);

        additions = new String[] {balcony.getName(), cleaning.getName(), internet.getName(), airConditioner.getName()};
        apartmentsMomHotel[1] = new TwoRoomsApartment(3000, 4, 14, additions);

        additions = new String[] {balcony.getName(), cleaning.getName(), internet.getName(), airConditioner.getName()};
        apartmentsMomHotel[2] = new TwoRoomsApartment(3000, 4, 15, additions);

        apartmentsMomHotel[3] = new ThreeRoomsApartment(2500, 6, 16, null);

        additions = new String[] {balcony.getName(), internet.getName()};
        apartmentsMomHotel[4] = new ThreeRoomsApartment(3500, 6, 17, additions);

        momHotel.hotelInfo();

        Apartment[] apartmentsKebabHotel = new Apartment[3];
        Hotel kebabHotel = new Hotel("\"Шашлычок\"", "09:00", apartmentsKebabHotel);

        additions = new String[] {kebab.getName()};
        apartmentsKebabHotel[0] = new OneRoomApartment(1000, 2, 10, additions);

        additions = new String[] {balcony.getName(), cleaning.getName()};
        apartmentsKebabHotel[1] = new TwoRoomsApartment(2000, 4, 11, additions);

        additions = new String[] {cleaning.getName()};
        apartmentsKebabHotel[2] = new ThreeRoomsApartment(4000, 4, 12, additions);

        kebabHotel.hotelInfo();
    }
}
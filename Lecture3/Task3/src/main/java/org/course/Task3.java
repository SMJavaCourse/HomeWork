package org.course;

import org.course.features.construct.AirConditioner;
import org.course.features.construct.Balcony;
import org.course.features.nonconstruct.Cleaning;
import org.course.features.nonconstruct.Internet;
import org.course.features.nonconstruct.Kebab;

public class Task3 {
    public static void main(String[] args) {

        Apartment[] apartmentsHotelGrandMa = new Apartment[5];
        apartmentsHotelGrandMa[0] = new OneRoomApartment(1000, 12,
                new Balcony());
        apartmentsHotelGrandMa[1] = new TwoRoomApartment(3000, 13,
                new Balcony(),
                new Internet(),
                new Cleaning(),
                new AirConditioner());
        apartmentsHotelGrandMa[2] = new TwoRoomApartment(3000, 14,
                new Balcony(),
                new Internet(),
                new Cleaning(),
                new AirConditioner());
        apartmentsHotelGrandMa[3] = new ThreeRoomApartment(2500,15);
        apartmentsHotelGrandMa[4] = new ThreeRoomApartment(3500,16,
                new Balcony(),
                new Internet());

        Apartment[] apartmentsHotelKebab = new Apartment[3];
        apartmentsHotelKebab[0] = new OneRoomApartment(1000, 11,
                new Kebab());
        apartmentsHotelKebab[1] = new TwoRoomApartment(2000, 12,
                new Cleaning(),
                new Balcony());
        apartmentsHotelKebab[2] = new ThreeRoomApartment(4000, 13,
                new Cleaning());

        Hotel hotelGrandMa = new Hotel("\"У мамы лучше\"", apartmentsHotelGrandMa, "12:00");
        Hotel hotelKebab = new Hotel("\"Шашлычок\"", apartmentsHotelKebab, "09:00");
//        hotelGrandMa.printHotel();
//        hotelKebab.printHotel();
        System.out.println(hotelGrandMa);
        System.out.println(hotelKebab);
    }
}


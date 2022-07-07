package org.course;

import org.course.factory.HotelFactory;
import org.course.test.FirstHotelTest;
import org.course.test.SecondHotelTest;

public class Task3 {
    public static void main(String[] args) {
//        HotelFactory hotelFactory = new HotelFactory();
//        Hotel hotelGrandMa = hotelFactory.createHotel("У мамы лучше");
//        Hotel hotelKebab = hotelFactory.createHotel("Шашлычок");
//        System.out.println(hotelGrandMa);
//        System.out.println(hotelKebab);
        FirstHotelTest firstHotelTest = new FirstHotelTest();
        firstHotelTest.testHotel();
        SecondHotelTest secondHotelTest = new SecondHotelTest();
        secondHotelTest.testHotel();
    }
}


package org.course.test;

import org.course.Hotel;
import org.course.factory.HotelFactory;

public class FirstHotelTest {

    public void testHotel() {
        Hotel hotelGrandMa = HotelFactory.getInstance().createHotel("У мамы лучше");
        System.out.println(hotelGrandMa);
    }
}

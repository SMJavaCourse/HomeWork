package org.course.test;

import org.course.Hotel;
import org.course.factory.HotelFactory;

public class SecondHotelTest {

    public void testHotel() {
        Hotel hotelKebab = HotelFactory.getInstance().createHotel("Шашлычок");
        System.out.println(hotelKebab);
    }

}

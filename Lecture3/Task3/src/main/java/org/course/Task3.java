package org.course;

import org.course.factory.HotelFactory;
import org.course.test.FirstHotelTest;
import org.course.test.SecondHotelTest;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(HotelFactory.getInstance().createHotel("У мамы лучше"));
        System.out.println(HotelFactory.getInstance().createHotel("Шашлычок"));
    }
}


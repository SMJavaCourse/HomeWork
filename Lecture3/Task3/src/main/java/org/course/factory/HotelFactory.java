package org.course.factory;

import org.course.Apartment;
import org.course.Hotel;
import org.course.exception.MyException;

public class HotelFactory {

    public Hotel createHotel(String nameOfHotel, Apartment[] apartments) {
        try {
            switch (nameOfHotel) {
                case "У мамы лучше":
                    return new Hotel("У мамы лучше", "12:00", apartments);
                case "Шашлычок":
                    return new Hotel("Шашлычок", "09:00", apartments);
            }
            throw new MyException("Невозможно создать отель \"" + nameOfHotel + "\"");
        } catch (MyException e) {
            System.out.println(e.getTextException());
        }
        return null;
    }
}

package org.course.factory;

import org.course.Apartment;
import org.course.Hotel;
import org.course.exception.MyException;

public class HotelFactory {

    public Hotel createHotel(String nameOfHotel, Apartment[] apartments) throws MyException {

            switch (nameOfHotel) {
                case "У мамы лучше":
                    return new Hotel("У мамы лучше", "12:00", apartments);
                case "Шашлычок":
                    return new Hotel("Шашлычок", "09:00", apartments);
            }
            throw new MyException("Ошибка при создании отеля - переданное имя не существует.");
    }

    public Apartment createApartment() {
        return null;
    }


}

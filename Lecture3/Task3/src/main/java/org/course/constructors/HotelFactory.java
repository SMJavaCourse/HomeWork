package org.course.constructors;

import org.course.Apartment;
import org.course.Hotel;
import org.course.exception.MyException;
import org.course.services.*;

public class HotelFactory {

    public Hotel createHotel(String nameOfHotel) throws MyException {
        ApartmentBuilder builder = new ApartmentBuilder();
        switch (nameOfHotel) {
                case "У мамы лучше":
                    Apartment[] allRoomsInHotel1 = new Apartment[5];
                    allRoomsInHotel1[0] = builder
                            .rooms(1).numberOfRoom(10).price(1000).capacity(2).services(
                                    new Balcony())
                            .build();
                    allRoomsInHotel1[1] = builder
                            .rooms(2).numberOfRoom(20).price(3000).capacity(4).services(
                                    new Balcony(),
                                    new Cleaning(),
                                    new Internet(512),
                                    new Conditioner())
                            .build();
                    allRoomsInHotel1[2] = builder
                            .rooms(2).numberOfRoom(30).price(3000).capacity(4).services(
                                    new Balcony(),
                                    new Cleaning(),
                                    new Internet(),
                                    new Conditioner())
                            .build();
                    allRoomsInHotel1[3] = builder
                            .rooms(3).numberOfRoom(40).price(2500).capacity(6).services()
                            .build();
                    allRoomsInHotel1[4] = builder
                            .rooms(3).numberOfRoom(50).price(3500).capacity(6).services(
                                    new Balcony(),
                                    new Internet(),
                                    new Conditioner(),
                                    new Jacuzzi())
                            .build();
                    return new Hotel("У мамы лучше", "12:00", allRoomsInHotel1);
                case "Шашлычок":
                    Apartment[] allRoomsInHotel2 = new Apartment[3];
                    allRoomsInHotel2[0] = builder
                            .rooms(1).numberOfRoom(11).price(1000).capacity(2).services(
                                    new Meat())
                            .build();
                    allRoomsInHotel2[1] = builder
                            .rooms(2).numberOfRoom(22).price(2000).capacity(4).services(
                                    new Balcony(),
                                    new Cleaning())
                            .build();
                    allRoomsInHotel2[2] = builder
                            .rooms(3).numberOfRoom(33).price(4000).capacity(6).services(
                                    new Cleaning(),
                                    new Jacuzzi())
                            .build();
                    return new Hotel("Шашлычок", "09:00", allRoomsInHotel2);
            }
            throw new MyException("Ошибка при создании отеля - переданное имя не существует.");
    }
}

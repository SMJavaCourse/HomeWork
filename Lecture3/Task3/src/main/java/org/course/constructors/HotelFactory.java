package org.course.constructors;

import org.course.Apartment;
import org.course.Hotel;
import org.course.exception.HotelFactoryException;
import org.course.services.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HotelFactory {

    private static HotelFactory instance;

    public static HotelFactory getInstance(){
        if (instance == null) {
            instance = new HotelFactory();
        }
        return instance;
    }

    public Hotel createHotel(String nameOfHotel) throws HotelFactoryException {
        ApartmentBuilder builder = new ApartmentBuilder();
        switch (nameOfHotel) {
            case "У мамы лучше" -> {
                ArrayList<Apartment> apartmentsInHotel1 = new ArrayList<>();
                apartmentsInHotel1.add(builder
                        .rooms(1).numberOfRoom(10).price(1000).capacity(2).services(
                                new Balcony())
                        .build());
                apartmentsInHotel1.add(builder
                        .rooms(2).numberOfRoom(20).price(3000).capacity(4).services(
                                new Balcony(),
                                new Cleaning(),
                                new Internet(512),
                                new Conditioner())
                        .build());
                apartmentsInHotel1.add(builder
                        .numberOfRoom(30).services(
                                new Balcony(),
                                new Cleaning(),
                                new Internet(),
                                new Conditioner())
                        .build());
                apartmentsInHotel1.add(builder
                        .rooms(3).numberOfRoom(40).price(2500).capacity(6).services()
                        .build());
                apartmentsInHotel1.add(builder
                        .numberOfRoom(50).price(3500).services(
                                new Balcony(),
                                new Internet(),
                                new Conditioner(),
                                new Jacuzzi())
                        .build());
                return new Hotel("У мамы лучше", "12:00", apartmentsInHotel1);
            }
            case "Шашлычок" -> {
                ArrayList<Apartment> apartmentsInHotel2 = new ArrayList<>();
                apartmentsInHotel2.add(builder
                        .rooms(1).numberOfRoom(11).price(1000).capacity(2).services(
                                new Meat())
                        .build());
                apartmentsInHotel2.add(builder
                        .rooms(2).numberOfRoom(22).price(2000).capacity(4).services(
                                new Balcony(),
                                new Cleaning())
                        .build());
                apartmentsInHotel2.add(builder
                        .rooms(3).numberOfRoom(33).price(4000).capacity(7).services(
                                new Cleaning(),
                                new Jacuzzi())
                        .build());
                return new Hotel("Шашлычок", "09:00", apartmentsInHotel2);
            }
        }
        throw new HotelFactoryException("Ошибка при создании отеля - переданное имя не существует.");
    }
}

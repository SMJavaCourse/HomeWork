package org.course.factory;

import org.course.*;
import org.course.builder.ApartmentBuilder;
import org.course.features.construct.AirConditioner;
import org.course.features.construct.Balcony;
import org.course.features.nonconstruct.Cleaning;
import org.course.features.nonconstruct.Internet;
import org.course.features.nonconstruct.Kebab;

public class HotelFactory {
    public static HotelFactory instance;

    private HotelFactory( ) {
    }

    public static HotelFactory getInstance() {
        if (instance == null) {
            instance = new HotelFactory();
        }
        return instance;
    }

    public Hotel createHotel(String name)  {

            ApartmentBuilder builder = new ApartmentBuilder();
            switch (name) {
                case "У мамы лучше" :
                    Apartment[] apartmentsHotelGrandMa = new Apartment[5];
                    apartmentsHotelGrandMa[0] = builder
                            .numberOfRooms(1)
                            .price(1000d)
                            .apartmentNumber(12)
                            .features(new Balcony())
                            .build();
                    apartmentsHotelGrandMa[1] = builder
                            .numberOfRooms(2)
                            .price(3000d)
                            .apartmentNumber(13)
                            .features(
                                    new Balcony(),
                                    new Internet(),
                                    new Cleaning(),
                                    new AirConditioner())
                            .build();
                    apartmentsHotelGrandMa[2] = builder
                            .apartmentNumber(14)
                            .build();
                    apartmentsHotelGrandMa[3] = builder
                            .numberOfRooms(3)
                            .price(2500d)
                            .apartmentNumber(15)
                            .features()
                            .build();
                    apartmentsHotelGrandMa[4] = builder
                            .price(3500d)
                            .apartmentNumber(16)
                            .features(
                                    new Balcony(),
                                    new Internet()
                            )
                            .build();
                    return new Hotel("У мамы лучше", apartmentsHotelGrandMa, "12:00");

                case "Шашлычок" :
                    Apartment[] apartmentsHotelKebab = new Apartment[3];
                    apartmentsHotelKebab[0] = builder.numberOfRooms(1).price(1000d).apartmentNumber(11).features(new Kebab()).build();
                    apartmentsHotelKebab[1] = builder.numberOfRooms(2).price(2000d).apartmentNumber(12).features(new Cleaning(), new Balcony()).build();
                    apartmentsHotelKebab[2] = builder.numberOfRooms(3).price(4000d).apartmentNumber(13).features(new Cleaning()).build();
                    return new Hotel("\"Шашлычок\"", apartmentsHotelKebab, "09:00");
                default:
                    throw new RuntimeException();
            }
        }
}

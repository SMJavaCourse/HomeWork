package org.course.Factory;

import org.course.Apartment;
import org.course.Builders.ApartmentBuilder;
import org.course.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelFactory {
    private static HotelFactory instance;

    public static HotelFactory getInstance() {
        if (instance == null) {
            instance = new HotelFactory();
        }
        return instance;
    }

    public Hotel createHotel(String nameOfHotel) {
        ApartmentBuilder builder = new ApartmentBuilder();
        switch (nameOfHotel) {
            case "У мамы лучше" -> {
                List<Apartment> apartMom = new ArrayList<>();
                builder
                        .apartment(1).num(11).price(1000).checkInTime("12:00").capacity(1)
                        .isCleaning(false)
                        .isInternet(false)
                        .isCooling(false)
                        .isBalcony(true);
                apartMom.add(builder.build());
                builder
                        .apartment(2).num(12).price(3000.0F).checkInTime("12:00").capacity(2)
                        .isCleaning(true)
                        .isInternet(true)
                        .isCooling(true)
                        .isBalcony(true);
                apartMom.add(builder.build());
                builder
                        .apartment(2).num(13).price(3000.0F).capacity(2)
                        .isCleaning(true)
                        .isInternet(true)
                        .isCooling(true)
                        .isBalcony(true);
                apartMom.add(builder.build());
                builder
                        .apartment(3).num(24).price(2500.0F).capacity(3)
                        .isCleaning(false)
                        .isInternet(false)
                        .isCooling(false)
                        .isBalcony(false);
                apartMom.add(builder.build());
                builder
                        .apartment(4).num(35).price(3500.0F).capacity(4)
                        .isCleaning(false)
                        .isInternet(true)
                        .isCooling(false)
                        .isBalcony(true);
                apartMom.add(builder.build());
                return new Hotel("У мамы лучше", "12:00", apartMom);
            }
            case "оШашлычок" -> {
                List<Apartment> apartGrill = new ArrayList<>();
                builder
                        .apartment(1).num(6).price(1000.0F).checkInTime("09:00").capacity(1)
                        .isCleaning(false)
                        .isInternet(false)
                        .isCooling(false)
                        .isBalcony(true)
                        .isGrillInNumber(true);
                apartGrill.add(builder.build());
                builder
                        .apartment(2).num(17).price(1000.0F).capacity(2)
                        .isCleaning(true)
                        .isInternet(false)
                        .isCooling(false)
                        .isBalcony(true)
                        .isGrillInNumber(false);
                apartGrill.add(builder.build());
                builder
                        .apartment(3).num(28).price(4000.0F).capacity(3)
                        .isCleaning(true)
                        .isInternet(false)
                        .isCooling(false)
                        .isBalcony(false)
                        .isGrillInNumber(true);
                apartGrill.add(builder.build());
                return new Hotel("оШашлычок", "09:00", apartGrill);
            }
        }
        return null;
    }
}
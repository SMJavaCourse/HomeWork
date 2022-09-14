package constructors;

import exeption.HotelNotExistException;
import org.course.Apartment;
import org.course.Hotel;

import java.util.ArrayList;
import java.util.List;

import static services.Services.*;

public class HotelFactory {

    private static HotelFactory instance;

    private HotelFactory() {
    }

    public static HotelFactory getInstance() {
        if (instance == null) {
            instance = new HotelFactory();
        }
        return instance;
    }

    public Hotel createHotel(String nameOfHotel) throws HotelNotExistException {
        var builder = Apartment.builder();

        switch (nameOfHotel) {
            case "У мамы лучше" -> {
                List<Apartment> apartmentsHotelGMama = new ArrayList<>();
                apartmentsHotelGMama.add(builder
                        .numberOfApart(1).rooms(1).capacity(2).price(1000).services
                                (List.of(BALCONY))
                        .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(2).rooms(2).capacity(4).price(3000).services
                                        (List.of(CLEANING, INTERNET, AIRCONDITIONER, BALCONY))
                                .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(3).rooms(2).capacity(4).price(3100).services
                                        (List.of(CLEANING, INTERNET, AIRCONDITIONER, BALCONY))
                                .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(4).rooms(3).capacity(6).price(2500).services
                                        (List.of())
                                .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(5).rooms(4).capacity(6).price(3500).services
                                        (List.of(INTERNET, BALCONY))
                                .build());
                return new Hotel("У мамы лучше", "12:00", apartmentsHotelGMama);
            }
            case "Шашлычок" -> {
                List<Apartment> apartmentsHotelShashlik = new ArrayList<>();
                apartmentsHotelShashlik.add(builder
                        .numberOfApart(6).rooms(1).capacity(2).price(1000).services
                                (List.of(BALCONY, KEBAB))
                        .build());
                apartmentsHotelShashlik.add(
                        builder
                                .numberOfApart(7).rooms(2).capacity(4).price(1000).services
                                        (List.of(CLEANING, BALCONY))
                                .build());
                apartmentsHotelShashlik.add(
                        builder
                                .numberOfApart(8).rooms(3).capacity(7).price(4000).services
                                        (List.of(CLEANING))
                                .build());
                return new Hotel("Шашлычок", "09:00", apartmentsHotelShashlik);
            }
        }
        throw new HotelNotExistException("Ошибка при создании отеля - переданное имя не существует.");
    }
}

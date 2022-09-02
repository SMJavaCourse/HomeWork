package constructors;

import org.course.Apartament;
import org.course.Hotel;
import services.*;

import java.util.ArrayList;
import java.util.List;

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

    public Hotel createHotel(String nameOfHotel) {
        var builder = Apartament.builder();

        switch (nameOfHotel) {
            case "У мамы лучше" -> {
                List<Apartament> apartmentsHotelGMama = new ArrayList<>();
                apartmentsHotelGMama.add(builder
                        .numberOfApart(1).rooms(1).capacity(2).price(1000).services(
                                new Balcony())
                        .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(2).rooms(2).capacity(4).price(3000).services(
                                        new Cleaning(),
                                        new Internet(),
                                        new AirConditioner(),
                                        new Balcony())
                                .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(3).rooms(2).capacity(4).price(3100).services(
                                        new Cleaning(),
                                        new Internet(),
                                        new AirConditioner(),
                                        new Balcony())
                                .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(4).rooms(3).capacity(6).price(2500).services()
                                .build());
                apartmentsHotelGMama.add(
                        builder
                                .numberOfApart(5).rooms(4).capacity(6).price(3500).services(
                                        new Internet(),
                                        new Balcony())
                                .build());
                return new Hotel("У мамы лучше", "12:00", apartmentsHotelGMama);
            }
            case "Шашлычок" -> {
                List<Apartament> apartmentsHotelShashlik = new ArrayList<>();
                apartmentsHotelShashlik.add(builder
                        .numberOfApart(6).rooms(1).capacity(2).price(1000).services(
                                new Balcony(),
                                new Kebab())
                        .build());
                apartmentsHotelShashlik.add(
                builder
                        .numberOfApart(7).rooms(2).capacity(4).price(1000).services(
                                new Cleaning(),
                                new Balcony())
                                .build());
                apartmentsHotelShashlik.add(
                builder
                        .numberOfApart(8).rooms(3).capacity(7).price(4000).services(
                                new Cleaning())
                        .build());
                return new Hotel("Шашлычок", "09:00", apartmentsHotelShashlik);
            }
        }
        return null;
    }
}

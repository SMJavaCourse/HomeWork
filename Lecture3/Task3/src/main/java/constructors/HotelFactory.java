package constructors;

import lombok.Builder;
import org.course.Apartment;
import org.course.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {

    private static HotelFactory instance;

    private HotelFactory( ) {
    }

    public static HotelFactory getInstance() {
        if (instance == null) {
            instance = new HotelFactory();
        }
        return instance;
    }

    public Hotel createHotel(String nameOfHotel) {
        ApartBuilder builder = new ApartBuilder();

        switch (nameOfHotel) {
            case "У мамы лучше" -> {
                List<Apartment> apartmentsHotelGMama = new ArrayList<>();
                builder
                        .rooms(1).num(1).price(1000).capacity(2)
                        .isClean(false)
                        .isInternet(false)
                        .isAirConditioner(false)
                        .isBalcony(true)
                        .isKebab(false);
                apartmentsHotelGMama.add(builder.build());
                builder
                        .rooms(2).num(2).price(3000.0F).time("12:00").capacity(4)
                        .isClean(true)
                        .isInternet(true)
                        .isAirConditioner(true)
                        .isBalcony(true);
                apartmentsHotelGMama.add(builder.build());
                builder
                        .rooms(2).num(3).price(3000.0F).capacity(4)
                        .isClean(true)
                        .isInternet(true)
                        .isAirConditioner(true)
                        .isBalcony(true);
                apartmentsHotelGMama.add(builder.build());
                builder
                        .rooms(3).num(4).price(2500.0F).capacity(6)
                        .isClean(false)
                        .isInternet(false)
                        .isAirConditioner(false)
                        .isBalcony(false);
                apartmentsHotelGMama.add(builder.build());
                builder
                        .rooms(4).num(5).price(3500.0F).capacity(6)
                        .isClean(false)
                        .isInternet(true)
                        .isAirConditioner(false)
                        .isBalcony(true);
                apartmentsHotelGMama.add(builder.build());
                return new Hotel("У мамы лучше", "12:00", apartmentsHotelGMama);
            }
            case "Шашлычок" -> {
                List<Apartment> apartmentsHotelShashlik = new ArrayList<>();
                builder
                        .rooms(1).num(6).price(1000.0F).time("09:00").capacity(2)
                        .isClean(false)
                        .isInternet(false)
                        .isAirConditioner(false)
                        .isBalcony(true)
                        .isKebab(true);
                apartmentsHotelShashlik.add(builder.build());
                builder
                        .rooms(2).num(7).price(1000.0F).capacity(4)
                        .isClean(true)
                        .isInternet(false)
                        .isAirConditioner(false)
                        .isBalcony(true);
                apartmentsHotelShashlik.add(builder.build());
                builder
                        .rooms(3).num(8).price(4000.0F).capacity(7)
                        .isClean(true)
                        .isInternet(false)
                        .isAirConditioner(false)
                        .isBalcony(false);
                apartmentsHotelShashlik.add(builder.build());
                return new Hotel("Шашлычок", "09:00", apartmentsHotelShashlik);
            }
        }
        return null;
    }
}

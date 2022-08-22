package org.course;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
@Setter
public class HotelsRepo {
    // Singleton
    private static HotelsRepo INSTANCE;
    private HotelsRepo() {}
    public static HotelsRepo getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new HotelsRepo();
        }
        return INSTANCE;
    }
    private List<Hotel> hotels = new ArrayList<>();
    private Map<String, Hotel> helpIndexHotel = new HashMap<>();


    // getHotel
    public Hotel getHotel(String hotelName) {
        Hotel hotelResult = helpIndexHotel.get(hotelName.toLowerCase());
        if (hotelResult != null) {
            return hotelResult;
        }
        return null;
//        throw new NoSuchElementException("Couldn't find hotel with name " + hotelName);
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
        helpIndexHotel.put(hotel.getName().toLowerCase(), hotel);
    }
    public void generateHotels() {
        addHotel(HotelFactory.createHotel("У мамы лучше"));
        addHotel(HotelFactory.createHotel("Шашлычок"));
        addHotel(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(100000f, 1, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        addHotel(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(140000f, 4, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
    }

    public void generateMoreHotels() {
        /**
         * for test method duration
         */
        addHotel(HotelFactory.createHotel("Шашлычок"));
        addHotel(HotelFactory.createHotel("У мамы лучше"));
        addHotel(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(100000f, 1, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        addHotel(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(140000f, 4, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        for (int i = 0; i < 1000000; i++) {
            addHotel(Hotel.builder()
                    .name("hotelName"+i)
                    .apartments(List.of(new ApartmentOneRoom(1000f, 7, 13)
                            .setServices(new ServicesImpl().addBalcony().addCleaning())))
                    .checkInTime(LocalTime.of(12, 0))
                    .build());
        }
    }
}

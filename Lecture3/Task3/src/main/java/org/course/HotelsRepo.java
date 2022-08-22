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
    private List<Hotel> hotels;
    private Map<String, Hotel> helpIndexHotel = new HashMap<>();


    // getHotel
    public Hotel getHotel(String hotelName) {
        Hotel hotelResult = helpIndexHotel.get(hotelName.toLowerCase());
        if (hotelResult != null) {
            return hotelResult;
        }
        throw new NoSuchElementException("Couldn't find hotel with name " + hotelName);
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
        helpIndexHotel.put(hotel.getName().toLowerCase(), hotel);
    }
    public List<Hotel> generateHotels() {
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
//        hotels.add(HotelFactory.createHotel("У мамы лучше"));
//        hotels.add(HotelFactory.createHotel("Шашлычок"));
//        hotels.add(Hotel.builder()
//                .name("Астория")
//                .apartments(List.of(new ApartmentOneRoom(100000f, 1, 1)
//                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
//                .checkInTime(LocalTime.of(12, 0))
//                .build());
//        hotels.add(Hotel.builder()
//                .name("Астория")
//                .apartments(List.of(new ApartmentOneRoom(140000f, 4, 1)
//                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
//                .checkInTime(LocalTime.of(12, 0))
//                .build());
        return hotels;
    }

    public List<Hotel> generateMoreHotels() {
        /**
         * for test method duration
         */
//        List<Hotel> hotels = new ArrayList<>();
        hotels.add(HotelFactory.createHotel("Шашлычок"));
        hotels.add(HotelFactory.createHotel("У мамы лучше"));
        hotels.add(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(100000f, 1, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        hotels.add(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(140000f, 4, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        for (int i = 0; i < 1000000; i++) {
            hotels.add(Hotel.builder()
                    .name("hotelName"+i)
                    .apartments(List.of(new ApartmentOneRoom(1000f, 7, 13)
                            .setServices(new ServicesImpl().addBalcony().addCleaning())))
                    .checkInTime(LocalTime.of(12, 0))
                    .build());
        }
        return hotels;
    }
}

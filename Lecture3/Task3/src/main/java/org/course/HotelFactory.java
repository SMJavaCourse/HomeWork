package org.course;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {

    public static List<Hotel> hotels;

    public static List<Hotel> generateHotels() {
        hotels.add(HotelFactory.createHotel("У мамы лучше"));
        hotels.add(HotelFactory.createHotel("Шашлычок"));
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
        return hotels;
    }

        public static List<Hotel> generateMoreHotels() {
        /**
         * for test method duration
         */
        List<Hotel> hotels = new ArrayList<>();
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

    public static Hotel createHotel(String hotelName) {
        try {
            switch (hotelName) {
                case "У мамы лучше":
                    List<Apartment> apartmentsForHotel1 = new ArrayList<>();
                    apartmentsForHotel1.add(new ApartmentOneRoom(1000f, 2, 13)
                                    .setServices(new ServicesImpl().addBalcony().addCleaning()));
                    apartmentsForHotel1.add(new ApartmentTwoRooms(3000f, 4, 14)
                            .setServices(new ServicesImpl().addBalcony().addCleaning().addConditioner()));
                    apartmentsForHotel1.add(new ApartmentTwoRooms(3000f, 4, 15)
                                    .setServices(new ServicesImpl().addBalcony().addCleaning().addConditioner().addInternet()));
                    apartmentsForHotel1.add(new ApartmentThreeRooms(2500f, 6, 16));
                    apartmentsForHotel1.add(new ApartmentThreeRooms(3500f, 6, 17)
                                    .setServices(new ServicesImpl().addBalcony().addInternet()));

                    return Hotel.builder()
                            .name(hotelName).apartments(apartmentsForHotel1).checkInTime(LocalTime.of(12, 0))
                            .build();

                case "Шашлычок":
                    List<Apartment> apartmentsForHotel2 = new ArrayList<>();
                    apartmentsForHotel2.add(new ApartmentOneRoom(1000f, 2, 13)
                            .setServices(new ServicesImpl().addGrillMeat()));
                    apartmentsForHotel2.add(new ApartmentTwoRooms(2000f, 4, 14)
                                    .setServices(new ServicesImpl().addBalcony().addCleaning()));
                    apartmentsForHotel2.add(new ApartmentThreeRooms(4000f, 6, 15)
                                    .setServices(new ServicesImpl().addCleaning()));
                    return Hotel.builder()
                            .name(hotelName).apartments(apartmentsForHotel2).checkInTime(LocalTime.of(9, 0))
                            .build();
                default:
                    throw new HotelException("Cannot create hotel with name \"" + hotelName + "\"");
            }
        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
        return Hotel.builder().build();
    }
}

package org.course;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {

    public static HotelImpl createHotel(String hotelName) {
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

                    return HotelImpl.builder()
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
                    return HotelImpl.builder()
                            .name(hotelName).apartments(apartmentsForHotel2).checkInTime(LocalTime.of(9, 0))
                            .build();
                default:
                    throw new HotelException("Cannot create hotel with name \"" + hotelName + "\"");
            }
        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
        return HotelImpl.builder().build();
    }
}

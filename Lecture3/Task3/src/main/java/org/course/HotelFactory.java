package org.course;

import java.time.LocalTime;
import java.util.List;

public class HotelFactory {
    public static Hotel createHotel(String hotelName) {
        HotelBuilder hotelBuilder = new HotelBuilder();

        try {
            switch (hotelName) {
                case "У мамы лучше":
                    Apartment[] apartmentsForHotel1 = new Apartment[5];
                    apartmentsForHotel1[0] = new ApartmentOneRoom(1000f, 2, 13,
                            List.of(new ServicesImpl().addBalcony()));
                    apartmentsForHotel1[1] = new ApartmentTwoRooms(3000f, 4, 14,
//                            List.of(new ServicesImpl().addBalcony().addCleaning().addConditioner())
                            List.of(new ServicesImpl().addBalcony(), new ServicesImpl().addCleaning(), new ServicesImpl().addConditioner())
                    );
                    apartmentsForHotel1[2] = new ApartmentTwoRooms(3000f, 4, 15,
                            List.of(new ServicesImpl().addBalcony().addCleaning().addConditioner().addInternet()));
                    apartmentsForHotel1[3] = new ApartmentThreeRooms(2500f, 6, 16,
                            List.of());
                    apartmentsForHotel1[4] = new ApartmentThreeRooms(3500f, 6, 17,
                            List.of(new ServicesImpl().addBalcony().addInternet()));
                    hotelBuilder.name(hotelName).apartments(apartmentsForHotel1).checkInTime(LocalTime.of(12, 0));
                    break;
                case "Шашлычок":
                    Apartment[] apartmentsForHotel2 = new Apartment[3];
                    apartmentsForHotel2[0] = new ApartmentOneRoom(1000f, 2, 13,
                            List.of(new ServicesImpl().addGrillMeat()));
                    apartmentsForHotel2[1] = new ApartmentTwoRooms(2000f, 4, 14,
                            List.of(new ServicesImpl().addBalcony().addCleaning()));
                    apartmentsForHotel2[2] = new ApartmentThreeRooms(4000f, 6, 15,
                            List.of(new ServicesImpl().addCleaning()));
                    hotelBuilder.name(hotelName).apartments(apartmentsForHotel2).checkInTime(LocalTime.of(9, 0));
                    break;
                default:
                    throw new HotelException("Cannot create hotel with name \"" + hotelName + "\"");
            }
        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
        return hotelBuilder.build();
    }
}

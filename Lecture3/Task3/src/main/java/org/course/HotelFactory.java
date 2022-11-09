package org.course;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {

    public static Hotels createHotel(String hotelName) {
        try {
            switch (hotelName) {
                case "У мамы лучше":
                    List<Apartment> apartmentsForHotel1 = new ArrayList<>();
                    apartmentsForHotel1.add(new Apartments("Однокомнатный номер", 1000f, 2, 13)
                                    .services(new Services().addBalcony().addCleaning()));
                    apartmentsForHotel1.add(new Apartments("Двухкомнатный номер", 3000f, 4, 14)
                            .services(new Services().addBalcony().addCleaning().addConditioner()));
                    apartmentsForHotel1.add(new Apartments("Двухкомнатный номер", 3000f, 4, 15)
                                    .services(new Services().addBalcony().addCleaning().addConditioner().addInternet()));
                    apartmentsForHotel1.add(new Apartments("Трехкомнатный номер", 2500f, 6, 16));
                    apartmentsForHotel1.add(new Apartments("Трехкомнатный номер", 3500f, 6, 17)
                                    .services(new Services().addBalcony().addInternet()));

                    return Hotels.builder()
                            .name(hotelName).apartments(apartmentsForHotel1).checkInTime(LocalTime.of(12, 0))
                            .build();

                case "Шашлычок":
                    List<Apartment> apartmentsForHotel2 = new ArrayList<>();
                    apartmentsForHotel2.add(new Apartments("Однокомнатный номер", 1000f, 2, 13)
                            .services(new Services().addGrillMeat()));
                    apartmentsForHotel2.add(new Apartments("Двухкомнатный номер", 2000f, 4, 14)
                                    .services(new Services().addBalcony().addCleaning()));
                    apartmentsForHotel2.add(new Apartments("Трехкомнатный номер", 4000f, 6, 15)
                                    .services(new Services().addCleaning()));
                    return Hotels.builder()
                            .name(hotelName).apartments(apartmentsForHotel2).checkInTime(LocalTime.of(9, 0))
                            .build();
                default:
                    throw new HotelException("Cannot create hotel with name \"" + hotelName + "\"");
            }
        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
        return Hotels.builder().build();
    }
}

package main.java.org.course;

import java.time.LocalTime;

public class HotelFactory {
    public static Hotel createHotel(String hotelName) {
        Hotel hotel = new Hotel();
        try {
            switch (hotelName) {
                case "У мамы лучше":
                    Apartment[] apartmentsForHotel1 = new Apartment[5];
                    apartmentsForHotel1[0] = new ApartmentOneRoom(1000f, 2, 13)
                            .addBalcony();
                    apartmentsForHotel1[1] = new ApartmentTwoRooms(3000f, 4, 14)
                            .addBalcony().addCleaning().addConditioner();
                    apartmentsForHotel1[2] = new ApartmentTwoRooms(3000f, 4, 15)
                            .addBalcony().addCleaning().addConditioner().addInternet();
                    apartmentsForHotel1[3] = new ApartmentThreeRooms(2500f, 6, 16);
                    apartmentsForHotel1[4] = new ApartmentThreeRooms(3500f, 6, 17)
                            .addBalcony().addInternet();
                    hotel = new Hotel(hotelName, apartmentsForHotel1, LocalTime.of(12, 0));
                    break;
                case "Шашлычок":
                    Apartment[] apartmentsForHotel2 = new Apartment[3];
                    apartmentsForHotel2[0] = new ApartmentOneRoom(1000f, 2, 13)
                            .addGrillMeat();
                    apartmentsForHotel2[1] = new ApartmentTwoRooms(2000f, 4, 14)
                            .addBalcony().addCleaning();
                    apartmentsForHotel2[2] = new ApartmentThreeRooms(4000f, 6, 15)
                            .addCleaning();
                    hotel = new Hotel(hotelName, apartmentsForHotel2, LocalTime.of(9,0));
                    break;
            }
            throw new HotelException("No hotels in factory");
        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
        return hotel;
    }
}

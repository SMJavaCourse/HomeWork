package org.course;

import java.util.List;

public interface Hotels {

    List<Apartment> getApartments();
    Integer getRoomsTotalCount();

    static void printHotelInfo(List<HotelImpl> hotels) {
        for (HotelImpl hotel: hotels) {
            System.out.println(hotel.toString());
            Apartments.printApartments(hotel.getApartments());
            System.out.println("\n*****************************\n");
        }
    }

}

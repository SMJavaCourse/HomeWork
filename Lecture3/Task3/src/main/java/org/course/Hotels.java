package org.course;

import java.util.List;

public interface Hotels {

    List<Apartment> getApartments();
    Integer getRoomsTotalCount();

    static void printHotelInfo(List<Hotel> hotels) {
        for (Hotel hotel: hotels) {
            System.out.println(hotel.toString());
            Apartments.printApartments(hotel.getApartments());
            System.out.println("\n*****************************\n");
        }
    }

}

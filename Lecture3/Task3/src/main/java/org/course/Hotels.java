package org.course;

import java.util.List;

public interface Hotels {

    List<Apartment> getAllApartments();
    int getRoomsTotalCount();

    static void printHotelInfo(List<Hotel> hotels) {
        for (Hotel hotel: hotels) {
            System.out.println(hotel.toString());
            Apartments.printApartments(hotel.getAllApartments());
            System.out.println("\n*****************************\n");
        }
    }

}

package org.course;


public interface Hotels {

    Apartment[] getAllApartments();
    int getRoomsTotalCount();

    static void printHotelInfo(Hotel[] hotels) throws HotelException {
        for (int i = 0; i < hotels.length; i++) {
            System.out.println(hotels[i].toString());
            Apartments.printApartments(hotels[i].getAllApartments());
            System.out.println("\n************************************************\n");
        }
    }
//    static void printAvailableApartmentByName(Hotel[] hotels, String apartmentName, int places) {}


}

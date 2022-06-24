package main.java.org.course;

public interface Hotels {

    Apartment[] getAllApartments();
    int getRoomsTotalCount();

    static void printHotelInfo(Hotel[] hotels) {
        for (int i = 0; i < hotels.length; i++) {
            System.out.println(hotels[i].toString());
            Apartments.printApartments(hotels[i].getAllApartments());
            System.out.println("\n************************************************\n");
        }
    }
}

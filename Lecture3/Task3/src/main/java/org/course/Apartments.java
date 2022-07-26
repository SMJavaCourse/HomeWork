package org.course;


import java.time.LocalTime;
import java.util.List;

public interface Apartments {
    String getApartmentsTypeName();

    void setCheckinTime(LocalTime checkinTime);

    Services getServices();

    static void printApartments(List<Apartment> apartments) {
        try {
            for (Apartment apartment : apartments) {
                System.out.println(apartment);
            }
        } catch (NullPointerException e) {
            System.out.println("No apartments");
        }
    }

}

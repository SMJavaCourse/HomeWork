package org.course;


import java.time.LocalTime;
import java.util.List;

public interface Apartments {
    String getApartmentsTypeName();

    void setCheckinTime(LocalTime checkinTime);

    List<Services> getServicesList();

    static void printApartments(Apartment[] apartments) {
        try {
            for (Apartment apartment : apartments) {
                System.out.println(apartment.toString());
            }
        } catch (NullPointerException e) {
            System.out.println("No apartments");
        }
    }

}

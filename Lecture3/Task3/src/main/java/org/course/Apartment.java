package org.course;


import java.time.LocalTime;
import java.util.List;

public interface Apartment {
    String getApartmentsTypeName();

    void setCheckinTime(LocalTime checkinTime);
    LocalTime getCheckinTime();
    List<Service> getServicesList();
    Service getServices(); // ? duplicated
    void setServices(Service services);
    void setServiceList(Service services);
    Integer getRoomNumber();
    Integer getPlaces();
    Float getPrice();

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

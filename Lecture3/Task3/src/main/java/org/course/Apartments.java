package main.java.org.course;


import java.time.LocalTime;

public interface Apartments {
    String getApartmentsTypeName();

    void setCheckinTime(LocalTime checkinTime);

    static void printApartments(Apartment[] apartments) {
        for (int i = 0; i < apartments.length; i++) {
            System.out.println(apartments[i].toString());
        }
    }

    Apartment addBalcony();
    Apartment addInternet();
    Apartment addConditioner();
    Apartment addCleaning();
    Apartment addGrillMeat();
    boolean isBalcony();
    boolean isInternet();
    boolean isConditioner();
    boolean isCleaning();
    boolean isGrillMeat();

}

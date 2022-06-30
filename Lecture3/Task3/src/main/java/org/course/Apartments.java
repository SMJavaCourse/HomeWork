package main.java.org.course;


import java.time.LocalTime;

public interface Apartments {
    String getApartmentsTypeName();

    void setCheckinTime(LocalTime checkinTime);

    static void printApartments(Apartment[] apartments) {
        try {
            for (Apartment apartment : apartments) {
                System.out.println(apartment.toString());
            }
        } catch (NullPointerException e) {
            System.out.println("No apartments");
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

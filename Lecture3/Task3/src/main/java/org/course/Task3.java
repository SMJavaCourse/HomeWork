package org.course;

public class Task3 {
    private static Apartment[] apartments;

    public static void main(String[] args) {

        Hotel uMamyLuchshe = new Hotel("У мамы лучше", apartments);
        uMamyLuchshe.setStartTime("12:00");
        uMamyLuchshe.setNumberOfRooms(5);
        //uMamyLuchshe.setRooms();

        uMamyLuchshe.soutTitle(uMamyLuchshe.getName(),uMamyLuchshe.getNumberOfRooms());
    }


}

package org.course;

public class Task3 {

    public static void main(String[] args) {

        Apartment[] allRoomsInHotel1 = new Apartment[5];
        allRoomsInHotel1[0] = new OneRoomApartment(10,1000);
        allRoomsInHotel1[0].setBalcony(true);
        allRoomsInHotel1[0].setJacuzzi(true);
        allRoomsInHotel1[1] = new TwoRoomsApartment(20,3000);
        allRoomsInHotel1[1].setBalcony(true);
        allRoomsInHotel1[1].setCleaning(true);
        allRoomsInHotel1[1].setInternet(true);
        allRoomsInHotel1[1].setConditioner(true);
        allRoomsInHotel1[2] = new TwoRoomsApartment(30,3000);
        allRoomsInHotel1[2].setBalcony(true);
        allRoomsInHotel1[2].setCleaning(true);
        allRoomsInHotel1[2].setInternet(true);
        allRoomsInHotel1[2].setConditioner(true);
        allRoomsInHotel1[3] = new ThreeRoomsApartment(40,2500);
        allRoomsInHotel1[4] = new ThreeRoomsApartment(50,3500);
        allRoomsInHotel1[4].setBalcony(true);
        allRoomsInHotel1[4].setInternet(true);
        allRoomsInHotel1[4].setJacuzzi(true);

        Apartment[] allRoomsInHotel2 = new Apartment[3];
        allRoomsInHotel2[0] = new OneRoomApartment(11,1000);
        allRoomsInHotel2[0].setMeat(true);
        allRoomsInHotel2[1] = new TwoRoomsApartment(22,2000);
        allRoomsInHotel2[1].setBalcony(true);
        allRoomsInHotel2[1].setCleaning(true);
        allRoomsInHotel2[2] = new ThreeRoomsApartment(33,4000);
        allRoomsInHotel2[2].setCleaning(true);
        allRoomsInHotel2[2].setJacuzzi(true);

        Hotel uMamyLuchshe = new Hotel("У мамы лучше","12:00",allRoomsInHotel1);
        Hotel shashlichek = new Hotel("Шашлычок","09:00",allRoomsInHotel2);

        System.out.println(uMamyLuchshe.getRooms().length);
        System.out.println(shashlichek.getRooms().length);

        uMamyLuchshe.soutTitle(uMamyLuchshe.getName(), uMamyLuchshe.getRooms().length);
        Apartment.soutRooms(uMamyLuchshe.getStartTime(), allRoomsInHotel1,uMamyLuchshe.getRooms().length);
        System.out.println();
        shashlichek.soutTitle(shashlichek.getName(), shashlichek.getRooms().length);
        Apartment.soutRooms(shashlichek.getStartTime(), allRoomsInHotel2,shashlichek.getRooms().length);

    }
}

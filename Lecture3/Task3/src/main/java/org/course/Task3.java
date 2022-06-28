package org.course;

public class Task3 {

    public static String oneRoomApartment = "Однокомнатный номер";
    public static String twoRoomApartment = "Двухкомнатный номер";
    public static String threeRoomApartment = "Трехкомнатный номер";
    public static String startTime1 = "12:00";
    public static String startTime2 = "09:00";

    public static void main(String[] args) {

        Apartment[] allRoomsInHotel1 = new Apartment[5];
        Apartment room11 = new Apartment(oneRoomApartment,"12:00",1000,1,2,true,
                false,false,false,false);
        Apartment room12 = new Apartment(twoRoomApartment,"12:00",3000,2,4,true,
                true,true,true,false);
        Apartment room13 = new Apartment(twoRoomApartment,"12:00",3000,3,4,true,
                true,true,true,false);
        Apartment room14 = new Apartment(threeRoomApartment,"12:00",2500,4,6,false,
                false,false,false,false);
        Apartment room15 = new Apartment(threeRoomApartment,"12:00",3500,5,6,true,
                false,true,false,false);

        allRoomsInHotel1[0] = room11;
        allRoomsInHotel1[1] = room12;
        allRoomsInHotel1[2] = room13;
        allRoomsInHotel1[3] = room14;
        allRoomsInHotel1[4] = room15;

        Apartment[] allRoomsInHotel2 = new Apartment[3];
        Apartment room21 = new Apartment(oneRoomApartment,"09:00",1000,1,2,false,
                false,false,false,true);
        Apartment room22 = new Apartment(twoRoomApartment,"09:00",2000,2,4,true,
                true,false,false,false);
        Apartment room23 = new Apartment(threeRoomApartment,"09:00",4000,3,6,false,
                true,false,false,false);

        allRoomsInHotel2[0] = room21;
        allRoomsInHotel2[1] = room22;
        allRoomsInHotel2[2] = room23;

        Hotel uMamyLuchshe = new Hotel("У мамы лучше", allRoomsInHotel1);
        Hotel shashlichek = new Hotel("Шашлычек", allRoomsInHotel2);

        uMamyLuchshe.soutTitle(uMamyLuchshe.getName(), uMamyLuchshe.getRooms().length);
        uMamyLuchshe.soutRooms(uMamyLuchshe.getRooms(),uMamyLuchshe.getRooms().length);
        System.out.println();
        shashlichek.soutTitle(shashlichek.getName(), shashlichek.getRooms().length);
        shashlichek.soutRooms(shashlichek.getRooms(),shashlichek.getRooms().length);


    }
}

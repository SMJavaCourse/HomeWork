package org.course;

public class Task3 {

    public static void main(String[] args) {

        Apartment[] allRoomsInHotel1 = new Apartment[5];
        Apartment room11 = new Apartment(1,1000,1,2,true,
                false,false,false,false,false);
        Apartment room12 = new Apartment(2,3000,2,4,true,
                true,true,true,false,false);
        Apartment room13 = new Apartment(2,3000,3,4,true,
                true,true,true,false,false);
        Apartment room14 = new Apartment(3,2500,4,6,false,
                false,false,false,false,false);
        Apartment room15 = new Apartment(3,3500,5,6,true,
                false,true,false,false,true);

        allRoomsInHotel1[0] = room11;
        allRoomsInHotel1[1] = room12;
        allRoomsInHotel1[2] = room13;
        allRoomsInHotel1[3] = room14;
        allRoomsInHotel1[4] = room15;

        Apartment[] allRoomsInHotel2 = new Apartment[3];
        Apartment room21 = new Apartment(1,1000,1,2,false,
                false,false,false,true,true);
        Apartment room22 = new Apartment(2,2000,2,4,true,
                true,false,false,false,false);
        Apartment room23 = new Apartment(3,4000,3,6,false,
                true,false,false,false,true);

        allRoomsInHotel2[0] = room21;
        allRoomsInHotel2[1] = room22;
        allRoomsInHotel2[2] = room23;

        Hotel uMamyLuchshe = new Hotel("У мамы лучше","12:00",allRoomsInHotel1);
        Hotel shashlichek = new Hotel("Шашлычек","09:00",allRoomsInHotel2);

        uMamyLuchshe.soutTitle(uMamyLuchshe.getName(), uMamyLuchshe.getRooms().length);
        uMamyLuchshe.soutRooms(uMamyLuchshe.getStartTime(),uMamyLuchshe.getRooms(),uMamyLuchshe.getRooms().length);
        System.out.println();
        shashlichek.soutTitle(shashlichek.getName(), shashlichek.getRooms().length);
        shashlichek.soutRooms(shashlichek.getStartTime(), shashlichek.getRooms(),shashlichek.getRooms().length);


    }
}

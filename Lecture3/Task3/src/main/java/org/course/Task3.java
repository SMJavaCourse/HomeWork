package org.course;

public class Task3 {

    public static String balcony = "балкон";
    public static String cleaning = "уборка номера";
    public static String internet = "интернет";
    public static String conditioner = "кондиционер";
    public static String meat = "шашлычок в номер";
    public static String oneRoomApatrtment = "Однокомнатный номер";
    public static String twoRoomApatrtment = "Двухкомнатный номер";
    public static String threeRoomApatrtment = "Трехкомнатный номер";
    public static String startTime1 = "12:00";
    public static String startTime2 = "09:00";

    public static void main(String[] args) {

        Apartment[] allRoomsInHotel1 = new Apartment[5];
        Apartment room11 = new Apartment(oneRoomApatrtment, 1000, 1, 2, startTime1, balcony,
                null, null, null, null);
        Apartment room12 = new Apartment(twoRoomApatrtment, 3000, 2, 4, startTime1, balcony,
                cleaning, internet, conditioner, null);
        Apartment room13 = new Apartment(twoRoomApatrtment, 3000, 3, 4, startTime1, balcony,
                cleaning, internet, conditioner, null);
        Apartment room14 = new Apartment(threeRoomApatrtment, 2500, 4, 6, startTime1,null,
                null, null,null, null);
        Apartment room15 = new Apartment(threeRoomApatrtment, 3500, 5, 6, startTime1, balcony,
                null, internet, null, null);

        allRoomsInHotel1[0] = room11;
        allRoomsInHotel1[1] = room12;
        allRoomsInHotel1[2] = room13;
        allRoomsInHotel1[3] = room14;
        allRoomsInHotel1[4] = room15;

        Apartment[] allRoomsInHotel2 = new Apartment[3];
        Apartment room21 = new Apartment(oneRoomApatrtment, 1000, 1, 2, startTime2,null,
                null, null, null, meat);
        Apartment room22 = new Apartment(twoRoomApatrtment, 2000, 2, 4, startTime2, balcony,
                cleaning, null, null, null);
        Apartment room23 = new Apartment(threeRoomApatrtment, 4000, 3, 6, startTime2,null,
                cleaning, null, null, null);

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

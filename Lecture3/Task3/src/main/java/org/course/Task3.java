package org.course;

public class Task3 {
    public static void main(String[] args) {
        Hotel[] hotels = new Hotel[2];
        Room[] hotelShashlykRoom = new Room[3];
        hotelShashlykRoom[0] = new Room(1, "1000", 2, "с шашлычком в номер");
        hotelShashlykRoom[1] = new Room(1, "2000", 4, "с балконом, уборкой номера, интернетом и кондиционером");
        hotelShashlykRoom[2] = new Room(1, "4000", 6, "с уборкой номера");
        hotels[0] = new Hotel("Шашлычок", hotelShashlykRoom, "12-00");


        Room[] hotelMamaRoom = new Room[5];
        hotelMamaRoom[0] = new Room(1, "1000", 2, "с балконом");
        hotelMamaRoom[1] = new Room(2, "3000", 4, "с балконом, уборкой номера, интернетом и кондиционером");
        hotelMamaRoom[2] = new Room(2, "3000", 4, "с балконом, уборкой номера, интернетом и кондиционером");
        hotelMamaRoom[3] = new Room(3, "2500", 6, "");
        hotelMamaRoom[4] = new Room(3, "3500", 6, "с балконом и интернетом");
        hotels[1] = new Hotel("У мамы лучше", hotelMamaRoom, "12-00");

        for (int i = 0; i < hotels.length; i++) {
            System.out.println("\nНазвание отеля: " + hotels[i].getName());
            System.out.println("Количество номеров: " + hotels[i].getRooms().length + "\nВремя заселения: " + hotels[i].getCheckin());
            System.out.println("Номера:");
            for (int j = 0; j < hotels[i].getRooms().length; j++) {
                System.out.println(hotels[i].getRooms()[j]);
            }
        }

    }
}

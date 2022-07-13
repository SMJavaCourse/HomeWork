package org.course;

public class HotelFactory {
    enum hotelName {
        Shashlyk,
        Mama
    }

    public Hotel createHotel(hotelName type) {
        Services balkon = new Services("Шикарный балкон");
        Services kondicioner = new Services("Кондиционер");
        Services uborka = new Services("Уборка номера");
        Services internet = new Services("Интернет");
        Services shashlychok = new Services("Шашлычок в номер");
        Services non = new Services("Без дополнительных услуг");
        switch (type) {
            case Shashlyk:
                Room[] hotelShashlykRoom = new Room[3];
                hotelShashlykRoom[0] = new Room(1, "1000", 2, shashlychok);
                hotelShashlykRoom[1] = new Room(1, "2000", 4, balkon, uborka);
                hotelShashlykRoom[2] = new Room(1, "4000", 6, uborka);
                return new Hotel("Шашлычок", hotelShashlykRoom, "12-00");
            case Mama:
                Room[] hotelMamaRoom = new Room[5];
                hotelMamaRoom[0] = new Room(1, "1000", 2, balkon);
                hotelMamaRoom[1] = new Room(2, "3000", 4, balkon,uborka,internet, kondicioner);
                hotelMamaRoom[2] = new Room(2, "3000", 4, kondicioner);
                hotelMamaRoom[3] = new Room(3, "2500", 6, non);
                hotelMamaRoom[4] = new Room(3, "3500", 6, balkon,internet);
                return new Hotel("У Мамы Лучше", hotelMamaRoom, "12-00");
            default:
                throw new RuntimeException("Нет такого отеля");
        }

    }

}
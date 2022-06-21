package org.course;

public class Task3 {
    public static void main(String[] args) {

        Apartment[] apartmentsMomHotel = new Apartment[5];
        Hotel momHotel = new Hotel("\"У мамы лучше\"", "12:00", apartmentsMomHotel);

        apartmentsMomHotel[0] = new OneRoomApartment(1500, 2, 13);
        apartmentsMomHotel[0].setAdditions("балкон");

        apartmentsMomHotel[1] = new TwoRoomsApartment(3000, 4, 14);
        apartmentsMomHotel[1].setAdditions("балкон, уборка номера, интернет, кондиционер");

        apartmentsMomHotel[2] = new TwoRoomsApartment(3000, 4, 15);
        apartmentsMomHotel[2].setAdditions("балкон, уборка номера, интернет, кондиционер");

        apartmentsMomHotel[3] = new ThreeRoomsApartment(2500, 6, 16);

        apartmentsMomHotel[4] = new ThreeRoomsApartment(3500, 6, 17);
        apartmentsMomHotel[4].setAdditions("балкон, интернет");

        momHotel.HotelInfo();

        Apartment[] apartmentsKebabHotel = new Apartment[3];
        Hotel kebabHotel = new Hotel("\"Шашлычок\"", "09:00", apartmentsKebabHotel);

        apartmentsKebabHotel[0] = new OneRoomApartment(1000, 2, 10);
        apartmentsKebabHotel[0].setAdditions("шашлычок в номер");

        apartmentsKebabHotel[1] = new TwoRoomsApartment(2000, 4, 11);
        apartmentsKebabHotel[1].setAdditions("балкон, уборка номера");

        apartmentsKebabHotel[2] = new ThreeRoomsApartment(4000, 4, 12);
        apartmentsKebabHotel[2].setAdditions("уборка номера");

        kebabHotel.HotelInfo();
    }
}
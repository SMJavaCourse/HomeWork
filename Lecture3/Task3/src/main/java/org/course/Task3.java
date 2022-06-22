package org.course;

public class Task3 {
    public static void main(String[] args) {
        Apartment[] apartmentsHotel1 = new Apartment[5];
        apartmentsHotel1[0] = new OneRoomApartment(1000, 13);
        apartmentsHotel1[0].setBalcony(true);
        apartmentsHotel1[1] = new TwoRoomApartment(3000, 12);
        apartmentsHotel1[1].setBalcony(true);
        apartmentsHotel1[1].setCleaning(true);
        apartmentsHotel1[1].setInternet(true);
        apartmentsHotel1[1].setAirConditioner(true);
        apartmentsHotel1[2] = new TwoRoomApartment(3000,34);
        apartmentsHotel1[2].setBalcony(true);
        apartmentsHotel1[2].setCleaning(true);
        apartmentsHotel1[2].setInternet(true);
        apartmentsHotel1[2].setAirConditioner(true);
        apartmentsHotel1[3] = new ThreeRoomApartment(2500,45);
        apartmentsHotel1[4] = new ThreeRoomApartment(3500,46);
        apartmentsHotel1[4].setInternet(true);
        apartmentsHotel1[4].setBalcony(true);
        Apartment[] apartmentsHotel2 = new Apartment[3];
        apartmentsHotel2[0] = new OneRoomApartment(1000, 11);
        apartmentsHotel2[0].setKebab(true);
        apartmentsHotel2[1] = new OneRoomApartment(2000, 12);
        apartmentsHotel2[1].setCleaning(true);
        apartmentsHotel2[1].setBalcony(true);
        apartmentsHotel2[2] = new OneRoomApartment(4000, 13);
        apartmentsHotel2[2].setCleaning(true);

        Hotel hotel1 = new Hotel("\"У мамы лучше\"", apartmentsHotel1, "12:00");
        Hotel hotel2 = new Hotel("\"Шашлычок\"", apartmentsHotel2, "09:00");
        System.out.println("Отель: " + hotel1.getName());
        System.out.println("Время заселения: " + hotel1.getCheckInTime());

        Apartment.printApartmentsInfo(apartmentsHotel1);

        System.out.println("Отель: " + hotel2.getName());
        System.out.println("Время заселения: " + hotel2.getCheckInTime());

        Apartment.printApartmentsInfo(apartmentsHotel2);



    }
}

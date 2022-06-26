package org.course;

public class Task3 {
    public static void main(String[] args) {

        Apartment[] apartmentsHotelGrandMa = new Apartment[5];
        OneRoomApartment oneRoomApartment = new OneRoomApartment(1000, 13);
        oneRoomApartment.setBalcony(true);
        apartmentsHotelGrandMa[0] = new OneRoomApartment(1000, 13);
        apartmentsHotelGrandMa[0].setBalcony(true);
        apartmentsHotelGrandMa[1] = new TwoRoomApartment(3000, 12);
        apartmentsHotelGrandMa[1].setBalcony(true);
        apartmentsHotelGrandMa[1].setCleaning(true);
        apartmentsHotelGrandMa[1].setInternet(true);
        apartmentsHotelGrandMa[1].setAirConditioner(true);
        apartmentsHotelGrandMa[2] = new TwoRoomApartment(3000,34);
        apartmentsHotelGrandMa[2].setBalcony(true);
        apartmentsHotelGrandMa[2].setCleaning(true);
        apartmentsHotelGrandMa[2].setInternet(true);
        apartmentsHotelGrandMa[2].setAirConditioner(true);
        apartmentsHotelGrandMa[3] = new ThreeRoomApartment(2500,45);
        apartmentsHotelGrandMa[4] = new ThreeRoomApartment(3500,46);
        apartmentsHotelGrandMa[4].setInternet(true);
        apartmentsHotelGrandMa[4].setBalcony(true);

        Apartment[] apartmentsHotel2 = new Apartment[3];
        apartmentsHotel2[0] = new OneRoomApartment(1000, 11);
        apartmentsHotel2[0].setKebab(true);
        apartmentsHotel2[1] = new OneRoomApartment(2000, 12);
        apartmentsHotel2[1].setCleaning(true);
        apartmentsHotel2[1].setBalcony(true);
        apartmentsHotel2[2] = new OneRoomApartment(4000, 13);
        apartmentsHotel2[2].setCleaning(true);

        Hotel hotel1 = new Hotel("\"У мамы лучше\"", apartmentsHotelGrandMa, "12:00");
        Hotel hotel2 = new Hotel("\"Шашлычок\"", apartmentsHotel2, "09:00");
        System.out.println("Отель: " + hotel1.getName());
        System.out.println("Время заселения: " + hotel1.getCheckInTime());

        Apartment.printApartmentsInfo(apartmentsHotelGrandMa);

        System.out.println("Отель: " + hotel2.getName());
        System.out.println("Время заселения: " + hotel2.getCheckInTime());

        Apartment.printApartmentsInfo(apartmentsHotel2);










    }
}

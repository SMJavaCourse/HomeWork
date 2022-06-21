package main.java.org.course;

import java.time.LocalTime;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {

        // вывести по каждому из отелей:
        // общее количество номеров
        // список номеров с их описанием

        Apartment[] apartmentsForHotel1 = new Apartment[5];
        apartmentsForHotel1[0] = new ApartmentOneRoom(1000f, 2, 13)
                .setBalcony(true);
        apartmentsForHotel1[1] = new ApartmentTwoRooms(3000f, 4, 14)
                .setBalcony(true).setCleaning(true).setConditioner(true).setInternet(true);
        apartmentsForHotel1[2] = new ApartmentTwoRooms(3000f, 4, 15)
                .setBalcony(true).setCleaning(true).setConditioner(true).setInternet(true);
        apartmentsForHotel1[3] = new ApartmentThreeRooms(2500f, 6, 16);
        apartmentsForHotel1[4] = new ApartmentThreeRooms(3500f, 6, 17)
                .setBalcony(true).setInternet(true);


        Apartment[] apartmentsForHotel2 = new Apartment[3];
        apartmentsForHotel2[0] = new ApartmentOneRoom(1000f, 2, 13)
                .setGrillMeat(true);
        apartmentsForHotel2[1] = new ApartmentTwoRooms(2000f, 4, 14)
                .setBalcony(true).setCleaning(true);
        apartmentsForHotel2[2] = new ApartmentThreeRooms(4000f, 6, 15)
                .setCleaning(true);

        Hotel[] hotels = new Hotel[2];
        hotels[0] = new Hotel("У мамы лучше", apartmentsForHotel1, LocalTime.of(12, 00));
        hotels[1] = new Hotel("Шашлычок", apartmentsForHotel2, LocalTime.of(9, 00));

        Hotel.printHotelInfo(hotels);

    }
}

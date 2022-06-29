package main.java.org.course;

import java.time.LocalTime;

public class Task3 {
    public static void main(String[] args) throws ApartmentException {

        // вывести по каждому из отелей:
        // общее количество номеров
        // список номеров с их описанием

        Apartment[] apartmentsForHotel1 = new Apartment[5];
        apartmentsForHotel1[0] = new ApartmentOneRoom(1000f, 2, 13)
                .addBalcony();
        apartmentsForHotel1[1] = new ApartmentTwoRooms(3000f, 4, 14)
                .addBalcony().addCleaning().addConditioner();
        apartmentsForHotel1[2] = new ApartmentTwoRooms(3000f, 4, 15)
                .addBalcony().addCleaning().addConditioner().addInternet();
        apartmentsForHotel1[3] = new ApartmentThreeRooms(2500f, 6, 16);
        apartmentsForHotel1[4] = new ApartmentThreeRooms(3500f, 6, 17)
                .addBalcony().addInternet();


        Apartment[] apartmentsForHotel2 = new Apartment[3];
        apartmentsForHotel2[0] = new ApartmentOneRoom(1000f, 2, 13)
                .addGrillMeat();
        apartmentsForHotel2[1] = new ApartmentTwoRooms(2000f, 4, 14)
                .addBalcony().addCleaning();
        apartmentsForHotel2[2] = new ApartmentThreeRooms(4000f, 6, 15)
                .addCleaning();

        Hotel[] hotels = new Hotel[2];
        hotels[0] = new Hotel("У мамы лучше", apartmentsForHotel1, LocalTime.of(12, 00));
        hotels[1] = new Hotel("Шашлычок", apartmentsForHotel2, LocalTime.of(9, 00));


        Hotels.printHotelInfo(hotels);
        Hotel.printAvailableApartmentByName(hotels, "У мамы лучше", 4);

        // for test:
//        Hotel.printAvailableApartmentByName(hotels, "У папы лучше", 4);
//        Hotel.printAvailableApartmentByName(hotels, "У мамы лучше", 40);
//        Hotel.printAvailableApartmentByName(new Hotel[0], "У мамы лучше", 4);
//        Hotel.printAvailableApartmentByName(new Hotel[1], "У мамы лучше", 4);


    }
}

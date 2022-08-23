package org.course;

import org.apache.commons.cli.ParseException;
import java.time.LocalTime;
import java.util.List;


public class Task3 {
    public static HotelsRepo hotelsRepo = HotelsRepo.getInstance();
    public static void main(String[] args) throws HotelException, ParseException {
        // вывести по каждому из отелей:
        // общее количество номеров
        // список номеров с их описанием

        hotelsRepo.generateMoreHotels(); // нагенерить > 1000000 отелей для теста
        var list = List.of(Hotel.builder()
                .name("Спб")
                .apartments(List.of(new ApartmentOneRoom(5000f, 2, 11)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build(),
                Hotel.builder()
                        .name("Отель")
                        .apartments(List.of(new ApartmentOneRoom(1000f, 2, 3)
                                .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                        .checkInTime(LocalTime.of(12, 0))
                        .build());
        hotelsRepo.setHotels(list);


        var time = new SearchTimeDemo();
        Hotel.printAvailableApartmentByParams(hotelsRepo, "У мамы лучше", 4);
        time.getMethodDuration();

        // for test (Task#3):
//        Hotel.printAvailableApartmentByParams(hotelsRepo, 4);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У папы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(hotels, "У мамы лучше", 40);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[0], "У мамы лучше", 4);
//        Hotel.printAvailableApartmentByHotelName(new Hotel[1], "У мамы лучше", 4);
    }

}

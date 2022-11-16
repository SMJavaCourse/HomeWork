package org.course;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    @SneakyThrows
    public static void main(String[] args) throws HotelException {
        var applicationContext = SpringApplication.run(App.class, args);

//        var globalStorage = new GlobalStorage();
//        var webServer = new WebServer(globalStorage);
//        webServer.start();

//        var hotelService = new HotelService();

//        hotelService.saveHotel(HotelImpl.builder()
//                .name("У мамы лучше")
//                .apartments(List.of(new ApartmentOneRoom(1000f, 1, 1)
//                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
//                .checkInTime(LocalTime.of(12, 0))
//                .build());
//
//        System.out.println(hotelService.getAllHotels());
//        System.out.println(hotelService.removeHotels());


    }

}

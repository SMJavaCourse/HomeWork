package org.course;

import org.course.service.HotelService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import java.util.Properties;


public class App {
    public static void main(String[] args) throws SQLException {

        // db connect
        String url = "jdbc:postgresql://localhost:5433/postgres";
        Properties properties = new Properties();
        properties.setProperty("user", "hotels");
        properties.setProperty("password", "hotels");
        properties.setProperty("ssl", "false");
        Connection connection = DriverManager.getConnection(url, properties);
        if (connection.isValid(1)) {
            System.out.println("Connected");
        }
        var statement = connection.createStatement();
        var resultFromDb = statement.executeQuery("select * from hotels");
        if (resultFromDb.next()) {
            System.out.println(resultFromDb.getString(2) + " | "
                    + resultFromDb.getString(3) + " | "
                    + resultFromDb.getString(4));
            System.out.println("***");
        }

        //TODO: сделать запись отелей в базу

        var hotelService = new HotelService();

        var hotels = hotelService.generateHotels();
        hotelService.saveHotel(Hotel.builder()
                .name("Новый отельчик")
                .apartments(List.of(new ApartmentOneRoom(1000f, 1, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        hotelService.printAvailableApartmentByParams("Новый отельчик", 1);
        hotelService.printAvailableApartmentByParams(6);


        // for test (Task#3):
//        hotelService.printAvailableApartmentByParams(4);
//        hotelService.printAvailableApartmentByParams("У папы лучше", 4);
//        hotelService.printAvailableApartmentByParams("У мамы лучше", 40);
//        hotelService.printAvailableApartmentByParams("У мамы лучше", 4);
//        hotelService.printAvailableApartmentByParams("У мамы лучше", 4);
    }

}

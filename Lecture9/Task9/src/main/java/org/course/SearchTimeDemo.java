package org.course;

import org.course.dao.DataSource;
import org.course.dao.HotelRepository;
import org.course.entity.Apartment;
import org.course.entity.Hotel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SearchTimeDemo {

    public static void main(String[] args) {

        HotelRepository hotelRepository = new HotelRepository();
//        hotelRepository.deleteAll();

        try (var connection = DataSource.getConnection()) {

            ArrayList<Apartment> apartment = new ArrayList<>();
            apartment.add(new Apartment(1, 11, 1000, 2, new ArrayList<>()));

            int numberOfHotels = 10;
            String nameOfHotelToFind = "имя отеля9";

            ArrayList<Hotel> hotelArrayList = new ArrayList<>();
            Map<String, Hotel> hotelByName = new HashMap<>();

            System.out.println("Начало создания отелей...");

            long start = System.currentTimeMillis();
            for (int i = 0; i < numberOfHotels; i++) {
                try (var statement = connection.prepareStatement("UPDATE hotels SET id = ?, name = ?, starttime = ?")) {
                    statement.setString(1, UUID.randomUUID().toString());
                    statement.setString(2, "имя отеля" + i);
                    statement.setString(3, "10:00");
                    statement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            long end = System.currentTimeMillis() - start;
            System.out.println(numberOfHotels + " отелей создано за " + end + " мс\n\nНачало поиска...\n");

            start = System.currentTimeMillis();
            String findHotel = hotelRepository.hotelFinder(nameOfHotelToFind,null,1);
            end = System.currentTimeMillis() - start;
            System.out.println("Найдено отелей: 1\nВсего отелей: " + numberOfHotels + "\nНайдено за " + end + " мс.\n" + findHotel);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

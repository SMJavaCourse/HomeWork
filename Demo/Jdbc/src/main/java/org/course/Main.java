package org.course;

import lombok.extern.java.Log;
import org.course.dao.CarRepository;
import org.course.dao.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Log
public class Main {

    public static void main(String[] args) throws SQLException {

        var car = CarRepository.getInstance().byId("1FF2FF");
        System.out.println(car);
        car.setModel("kalina");
        var savedCar = CarRepository.getInstance().save(car);
        System.out.println(savedCar);
//        try (Connection conn = DataSource.getConnection()) {
//            if (conn.isValid(1)) {
//                System.out.println("Connected");
//            }
////            try (var statement = conn.prepareStatement("UPDATE cars SET model = 'granta' where id = ?")) {
////                statement.setString(1, "1");
////                var result = statement.executeUpdate();
////                System.out.println(result);
////            }
//            try (var insertStatement = conn.prepareStatement("insert into clients values (?, ?, ?)")) {
//                insertStatement.setString(1, "3");
//                insertStatement.setString(2, "Пётр");
//                insertStatement.setString(3, "Петров");
//                insertStatement.executeUpdate();
//            }
//        }


    }



}

package org.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static volatile Connection instance;

    public static Connection getConnection() throws SQLException {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (JdbcUtils.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = newConnection();
                }
            }
        }
        return localInstance;
    }

    private static Connection newConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/car";
        Properties props = new Properties();
        props.setProperty("user", "car");
        props.setProperty("password", "car");
        props.setProperty("ssl", "false");
        return DriverManager.getConnection(url, props);
    }

    public static void printCars(Connection connection) throws SQLException {
        try (var statement = connection.createStatement();
             var rs = statement.executeQuery("SELECT * FROM cars")) {
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString("vin"));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString("model"));
            }
        }
    }

    public static void addClient(Connection connection, String id, String lastName, String firstName) throws SQLException {
        var sql = "INSERT INTO clients (id, first_name, last_name) VALUES (?, ?, ?)";
        try (var statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.executeUpdate();
        }
    }
}



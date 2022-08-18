package org.course.dao;

import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.course.entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository extends Repository<Car, String> {
    private static final Map<String, Car> carByVin = new HashMap<>();
    private static volatile CarRepository instance;

    public static CarRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (CarRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new CarRepository();
                }
            }
        }
        return localInstance;
    }

    private CarRepository() {
    }

    @Override
    public List<Car> all() {
        var result = new ArrayList<Car>();
        try (var connection = DataSource.getConnection();
             var statement = connection.createStatement();
             var rs = statement.executeQuery("SELECT vin, make, model FROM cars")) {
            while (rs.next()) {
                result.add(extractCar(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Car extractCar(ResultSet rs) throws SQLException {
        var car = new Car();
        car.setVin(rs.getString(1));
        car.setMake(rs.getString(2));
        car.setModel(rs.getString(3));
        return car;
    }

    @SneakyThrows
    public Car save(Car car) {
        if (StringUtils.isBlank(car.getVin())) {
            throw new Exception("Vin cannot be blank");
        }
        if (byId(car.getVin()) != null) {
            try (var connection = DataSource.getConnection();
                 var statement = connection.prepareStatement("UPDATE cars SET make = ?, model = ? WHERE vin = ?")) {
                statement.setString(1, car.getMake());
                statement.setString(2, car.getModel());
                statement.setString(3, car.getVin());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (var connection = DataSource.getConnection();
                 var statement = connection.prepareStatement("INSERT INTO cars VALUES (?, ?, ?)")) {
                statement.setString(1, car.getVin());
                statement.setString(2, car.getMake());
                statement.setString(3, car.getModel());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return car;
    }

    public Car byId(String id) {
        try (var connection = DataSource.getConnection();
             var stmt = connection.prepareStatement("SELECT vin, make, model FROM cars WHERE vin = ?")) {
            stmt.setString(1, id);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractCar(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void deleteAll() {
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement("DELETE FROM cars")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Car> find(List<String> vins) {
        var stream = carByVin.values().stream();
        if (CollectionUtils.isNotEmpty(vins)) {
            stream = stream.filter(rr -> vins.contains(rr.getVin()));
        }
        return stream.sorted(defaultComparator()).toList();
    }

    private Comparator<Car> defaultComparator() {
        return Comparator.comparing(Car::getVin);
    }

}

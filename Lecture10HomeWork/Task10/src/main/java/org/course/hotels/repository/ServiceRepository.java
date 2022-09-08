package org.course.hotels.repository;

import org.course.hotels.dto.ServicesEnum;
import org.course.hotels.entity.services.*;
import org.course.hotels.entity.services.ServicesAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.UUID;

@Repository
public class ServiceRepository {

    private static DataSource dataSource;

    @Autowired
    public ServiceRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ServicesAbstract servicesBuilder(String nameOfService, String customProperty, String defaultProperty) {
        switch (ServicesEnum.valueOf(nameOfService.toUpperCase())) {
            case BALCONY -> {
                return new Balcony();
            }
            case CLEANING -> {
                return new Cleaning();
            }
            case CONDITIONER -> {
                return new Conditioner();
            }
            case JACUZZI -> {
                return new Jacuzzi();
            }
            case MEAT -> {
                return new Meat();
            }
            case INTERNET -> {
                if (customProperty == null || "".equals(customProperty)) {
                    return new Internet(Integer.parseInt(defaultProperty));
                } else {
                    return new Internet(Integer.parseInt(customProperty));
                }
            }
        }
        throw new RuntimeException();
    }


    public String getIdByServiceName(String serviceName) {
        try (var connection = dataSource.getConnection();
             var prepareStatement = connection.prepareStatement("SELECT id FROM services WHERE servicename = ?")) {
            prepareStatement.setString(1, serviceName.toUpperCase());
            var result = prepareStatement.executeQuery();
            if (result.next()) {
                return result.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public String save(String apartmentId, String serviceName, String customValue) {
        var getIdByServiceName = getIdByServiceName(serviceName);
        var uuId = UUID.randomUUID().toString();
        if (getIdByServiceName != null) {
            try (var connection = dataSource.getConnection();
                 var statement = connection.prepareStatement("INSERT INTO apartmentservices VALUES (?, ?, ?, ?)")) {
                statement.setString(1, uuId);
                statement.setString(2, apartmentId);
                statement.setString(3, getIdByServiceName);
                statement.setString(4, customValue);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return "Successful, apartmentServiceId is " + uuId;
        } else {
            return "Unsuccessful, service not found";
        }
    }
    public void deleteAll() {
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM apartmentservices;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int deleteById(String apartmentServiceId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("DELETE FROM apartmentservices WHERE id = ?")) {
            statement.setString(1, apartmentServiceId);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteServiceByName(String serviceName) {
        try (var connection = dataSource.getConnection();
             var baseStatement = connection.prepareStatement("DELETE FROM apartmentservices WHERE id = ?")) {
            baseStatement.setString(1, getIdByServiceName(serviceName));
            return baseStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

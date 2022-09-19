package org.course.hotels.repository;

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

    public int deleteByApartmentId(String apartmentServicesId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("DELETE FROM apartmentservices WHERE id = ?")) {
            statement.setString(1, apartmentServicesId);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public String getIdByServiceName(String serviceName) {
        try (var connection = dataSource.getConnection();
             var prepareStatement = connection.prepareStatement("SELECT id FROM services WHERE servicenameru = ?")) {
            prepareStatement.setString(1, serviceName.toLowerCase());
            var result = prepareStatement.executeQuery();
            if (result.next()) {
                return result.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deleteAll() {
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM apartmentservices;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

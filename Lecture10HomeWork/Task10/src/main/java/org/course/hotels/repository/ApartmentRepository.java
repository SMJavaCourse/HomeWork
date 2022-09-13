package org.course.hotels.repository;

import org.course.hotels.dto.Apartment;
import org.course.hotels.entity.ApartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

@Repository
public class ApartmentRepository {

    private static DataSource dataSource;
    private static volatile ApartmentRepository instance;

    public ApartmentRepository() {

    }

    public static ApartmentRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (ApartmentRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ApartmentRepository();
                }
            }
        }
        return localInstance;
    }

    @Autowired
    public ApartmentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<Apartment> suitableApartments(String hotelId, int numberOfGuests) {
        ArrayList<Apartment> result = new ArrayList<>();
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, hotelId, rooms, numberofroom, price," +
                     " capacity FROM apartments WHERE hotelid = ?")) {
            statement.setString(1, hotelId);
            try (var rs = statement.executeQuery()) {
                while (rs.next()) {
                    var capacity =rs.getInt(6);
                    if (capacity >= numberOfGuests) {
                        apartmentConstructor(result, rs);
                    }
                }
            }
            mostExpensiveApartment(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    private static void mostExpensiveApartment(ArrayList<Apartment> apartments) throws NoSuchElementException {
        if (apartments.size() != 0) {
            var mostExpensiveApartment = apartments
                    .stream()
                    .max(Comparator.comparing(Apartment::getPrice))
                    .get();
            mostExpensiveApartment.setName(mostExpensiveApartment.getName() + " LUXURY");
        }
    }
    public ArrayList<Apartment> allApartmentsInHotel(String hotelId) {
        ArrayList<Apartment> result = new ArrayList<>();
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, hotelid, rooms, numberofroom, price," +
                     " capacity FROM apartments WHERE hotelid = ?")) {
            statement.setString(1, hotelId);
            try (var rs = statement.executeQuery()) {
                while (rs.next()) {
                    apartmentConstructor(result, rs);
                }
            }
            mostExpensiveApartment(result);
        } catch (SQLException | NoSuchElementException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    private void apartmentConstructor(ArrayList<Apartment> result, ResultSet rs) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setId(rs.getString(1));
        if (rs.getInt(3) == 1) {
            apartment.setName("Однокомнатный номер");
        } else if (rs.getInt(3) == 2) {
            apartment.setName("Двухкомнатный номер");
        } else if (rs.getInt(3) == 3) {
            apartment.setName("Трехкомнатный номер");
        }
        apartment.setRooms(rs.getInt(3));
        apartment.setRoomNumber(rs.getInt(4));
        apartment.setPrice(rs.getInt(5));
        apartment.setCapacity(rs.getInt(6));
//        apartment.setServices(allServicesInApartment(rs.getString(1)));
        result.add(apartment);
    }
    public ArrayList<String> allServicesInApartment(String apartmentsId) {
        ArrayList<String> services = new ArrayList<>();
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT serviceName, serviceNameRu, " +
                     "defaultProperty, customProperty FROM apartmentServices LEFT JOIN services on" +
                     " services.id = apartmentServices.serviceId WHERE apartmentsId = ?;")) {
            statement.setString(1, apartmentsId);
            try (var rs = statement.executeQuery()) {
                while (rs.next()) {
                    services.add(ServiceRepository.servicesBuilder(
                            rs.getString("servicename"),
                            rs.getString("customproperty"),
                            rs.getString("defaultproperty")).getName());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return services;
    }
    public int deleteById(String apartmentId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("DELETE FROM apartments WHERE id = ?")) {
            statement.setString(1, apartmentId);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Apartment save(Apartment apartment, String hotelId){
        if (findById(apartment.getId()) != null) {
            try (var connection = dataSource.getConnection();
                 var statement = connection.prepareStatement("UPDATE apartments SET price = ?, capacity = ?  WHERE id = ?")) {
                statement.setInt(1, apartment.getPrice());
                statement.setInt(2, apartment.getCapacity());
                statement.setString(3, apartment.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (var connection = dataSource.getConnection();
                 var statement = connection.prepareStatement("INSERT INTO apartments VALUES (?, ?, ?, ?, ?, ?)")) {
                statement.setString(1, apartment.getId());
                statement.setString(2, hotelId);
                statement.setInt(3, apartment.getRooms());
                statement.setInt(4, apartment.getRoomNumber());
                statement.setInt(5, apartment.getPrice());
                statement.setInt(6, apartment.getCapacity());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return apartment;
    }

    public ApartmentEntity findById(String apartmentId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, hotelId, rooms, numberofroom, price, capacity FROM apartments WHERE id = ?")) {
            statement.setString(1, apartmentId);
            var result = statement.executeQuery();
            if (result.next()) {
                ApartmentEntity apartmentEntity = new ApartmentEntity();
                apartmentEntity.setId(result.getString(1));
                apartmentEntity.setHotelId(result.getString(2));
                apartmentEntity.setRooms(result.getInt(3));
                apartmentEntity.setRoomNumber(result.getInt(4));
                apartmentEntity.setPrice(result.getInt(5));
                apartmentEntity.setCapacity(result.getInt(6));
                return apartmentEntity;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deleteAll() {
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM apartments;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

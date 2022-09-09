package org.course.hotels.repository;

import org.course.hotels.dto.Apartment;
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

    private final DataSource dataSource;

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
        apartment.setServices(allServicesInApartment(rs.getString(1)));
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

}

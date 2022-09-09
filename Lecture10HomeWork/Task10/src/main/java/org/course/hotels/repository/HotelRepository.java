package org.course.hotels.repository;

import org.course.hotels.dto.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class HotelRepository {
    private final DataSource dataSource;
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public HotelRepository(DataSource dataSource, ApartmentRepository apartmentRepository) {
        this.dataSource = dataSource;
        this.apartmentRepository = apartmentRepository;
    }
    public Hotel findHotelByName(String nameOfHotel, int numberOfGuests) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, name, starttime FROM hotels WHERE UPPER(name) = UPPER(?)")) {
            statement.setString(1, nameOfHotel);
            try (var rs = statement.executeQuery()) {
                if (rs.next()) {
                    var id = rs.getString(1);
                    var name = rs.getString(2);
                    var startTime = rs.getString(3);
                    var apartments = apartmentRepository.suitableApartments(rs.getString(1),numberOfGuests);
                    return new Hotel(id, name, startTime, apartments);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }
    public Hotel findById(String hotelId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, name, starttime FROM hotels WHERE id = ?")) {
            statement.setString(1, hotelId);
            var result = statement.executeQuery();
            if (result.next()) {
                var hotel = new Hotel();
                hotel.setId(result.getString(1));
                hotel.setName(result.getString(2));
                hotel.setStartTime(result.getString(3));
                hotel.setApartments(apartmentRepository.allApartmentsInHotel(result.getString(1)));
                return hotel;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
package org.course.hotels.repository;

import org.course.hotels.dto.Hotel;
import org.course.hotels.entity.HotelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class HotelRepository {
    private DataSource dataSource;
    private ApartmentRepository apartmentRepository;
    private static HotelRepository instance;


    @Autowired
    public HotelRepository(DataSource dataSource, ApartmentRepository apartmentRepository) {
        this.dataSource = dataSource;
        this.apartmentRepository = apartmentRepository;
    }

    public HotelRepository() {
    }

    public static HotelRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (HotelRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new HotelRepository();
                }
            }
        }
        return localInstance;
    }
    public HotelEntity findHotelByName(String nameOfHotel) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, name, starttime FROM hotels WHERE UPPER(name) = UPPER(?)")) {
            statement.setString(1, nameOfHotel);
            try (var rs = statement.executeQuery()) {
                if (rs.next()) {
                    HotelEntity hotelEntity = new HotelEntity();
                    hotelEntity.setId(rs.getString(1));
                    hotelEntity.setName(rs.getString(2));
                    hotelEntity.setStartTime(rs.getString(3));
                    return hotelEntity;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }
    public HotelEntity findById(String hotelId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, name, starttime FROM hotels WHERE id = ?")) {
            statement.setString(1, hotelId);
            var result = statement.executeQuery();
            if (result.next()) {
                HotelEntity hotelEntity = new HotelEntity();
                hotelEntity.setId(result.getString(1));
                hotelEntity.setName(result.getString(2));
                hotelEntity.setStartTime(result.getString(3));
                return hotelEntity;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Hotel save (Hotel hotel){
        if (findById(hotel.getId()) != null) {
            try (var connection = dataSource.getConnection();
                 var statement = connection.prepareStatement("UPDATE hotels SET name = ?, starttime = ? WHERE id = ?")) {
                statement.setString(1, hotel.getName());
                statement.setString(2, hotel.getStartTime());
                statement.setString(3, hotel.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (var connection = dataSource.getConnection();
                 var statement = connection.prepareStatement("INSERT INTO hotels VALUES (?, ?, ?)")) {
                statement.setString(1, hotel.getId());
                statement.setString(2, hotel.getName());
                statement.setString(3, hotel.getStartTime());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return hotel;
    }
    public int deleteById(String hotelId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("DELETE FROM hotels WHERE id = ?")) {
            statement.setString(1, hotelId);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll(){
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM hotels;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
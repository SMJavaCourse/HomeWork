package org.course.hotels.repository;

import lombok.SneakyThrows;
import org.course.hotels.entity.HotelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class HotelRepository {
    private final DataSource dataSource;

    @Autowired
    public HotelRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @SneakyThrows
    public HotelEntity getById(String id) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(
                     "select * from hotels where id = ?")) {
            statement.setString(1, id);
            try (var rs = statement.executeQuery()) {
                if (rs.next()) {
                    var hotelEntity = new HotelEntity();
                    hotelEntity.setId(rs.getString("id"));
                    hotelEntity.setName(rs.getString("name"));
                    hotelEntity.setStartTime(rs.getString("start_time"));
                    return hotelEntity;
                }
                return null;
            }
        }
    }
}

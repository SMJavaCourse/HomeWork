package org.course.cities.repository.jdbc;

import lombok.SneakyThrows;
import org.course.cities.entity.CityEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CitiesJdbcRepository {
    private DataSource dataSource;

    @SneakyThrows
    public CityEntity getById(String id) {
        try (var statement = dataSource.getConnection()
                .prepareStatement("select * from cities where id = ?")) {
            statement.setString(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }
                var cityEntity = new CityEntity();
                cityEntity.setId(resultSet.getString("id"));
                cityEntity.setName(resultSet.getString("name"));
                cityEntity.setRegionId(resultSet.getString("region_id"));
                return cityEntity;
            }
        }
    }
}

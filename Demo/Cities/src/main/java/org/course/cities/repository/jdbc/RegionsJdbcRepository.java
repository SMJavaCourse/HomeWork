package org.course.cities.repository.jdbc;

import lombok.SneakyThrows;
import org.course.cities.entity.RegionEntity;

import javax.sql.DataSource;

public class RegionsJdbcRepository {
    private DataSource dataSource;

    public RegionsJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @SneakyThrows
    public RegionEntity getById(String id) {
        try (var statement = dataSource.getConnection()
                .prepareStatement("select * from regions where id = ?")) {
            statement.setString(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }
                var regionEntity = new RegionEntity();
                regionEntity.setId(resultSet.getString("id"));
                regionEntity.setName(resultSet.getString("name"));
                regionEntity.setCountryId(resultSet.getString("country_id"));
                return regionEntity;
            }
        }
    }
}

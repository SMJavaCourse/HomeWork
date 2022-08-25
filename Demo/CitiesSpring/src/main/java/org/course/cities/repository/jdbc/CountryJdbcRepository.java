package org.course.cities.repository.jdbc;

import lombok.SneakyThrows;
import org.course.cities.entity.CountryEntity;

import javax.sql.DataSource;

public class CountryJdbcRepository {
    private DataSource dataSource;

    public CountryJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @SneakyThrows
    public CountryEntity getById(String id) {
        try (var statement = dataSource.getConnection()
                .prepareStatement("select * from countries where id = ?")) {
            statement.setString(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }
                var countryEntity = new CountryEntity();
                countryEntity.setId(resultSet.getString("id"));
                countryEntity.setName(resultSet.getString("name"));
                return countryEntity;
            }
        }
    }
}

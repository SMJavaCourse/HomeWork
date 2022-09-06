package org.course.cities.repository.jdbc;

import lombok.SneakyThrows;
import org.course.cities.entity.CityEntity;
import org.course.cities.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@ConditionalOnProperty(name = "cities.repo.jdbc", havingValue = "true")
public class CitiesJdbcRepository implements CitiesRepository {
    private final DataSource dataSource;

    @Autowired
    public CitiesJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
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

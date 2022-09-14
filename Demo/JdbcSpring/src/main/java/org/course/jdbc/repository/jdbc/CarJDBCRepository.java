package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.CarEntity;
import org.course.jdbc.repository.CarRepository;
import org.course.jdbc.repository.mapper.CarMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
@RequiredArgsConstructor
public class CarJDBCRepository implements CarRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public CarEntity getById(String id) {
        return jdbcTemplate.queryForObject("select vin, make, model from cars where vin=?", CarMapper.getInstance(), id);
    }
}

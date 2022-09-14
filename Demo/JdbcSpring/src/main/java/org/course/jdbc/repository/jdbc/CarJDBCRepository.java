package org.course.jdbc.repository.jdbc;

import org.course.jdbc.entity.CarEntity;
import org.course.jdbc.repository.CarRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
public class CarJDBCRepository implements CarRepository {
    @Override
    public CarEntity getById(String id) {
        return null;
    }
}

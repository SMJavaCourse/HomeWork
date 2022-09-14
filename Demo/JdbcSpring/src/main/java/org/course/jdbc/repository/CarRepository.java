package org.course.jdbc.repository;

import org.course.jdbc.entity.CarEntity;

public interface CarRepository {
    CarEntity getById(String id);
}

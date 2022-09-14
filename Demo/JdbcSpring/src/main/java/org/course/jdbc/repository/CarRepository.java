package org.course.jdbc.repository;

import org.course.jdbc.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> {
    CarEntity getById(String id);
}

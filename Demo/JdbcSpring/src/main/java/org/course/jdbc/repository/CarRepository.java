package org.course.jdbc.repository;

import org.course.jdbc.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> {
    Optional<CarEntity> findById(String id);
}

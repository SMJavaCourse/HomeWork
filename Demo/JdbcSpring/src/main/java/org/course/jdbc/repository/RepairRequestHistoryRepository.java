package org.course.jdbc.repository;

import org.course.jdbc.entity.RepairRequestHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepairRequestHistoryRepository extends JpaRepository<RepairRequestHistoryEntity, String> {
    Optional<RepairRequestHistoryEntity> findById(String id);
}

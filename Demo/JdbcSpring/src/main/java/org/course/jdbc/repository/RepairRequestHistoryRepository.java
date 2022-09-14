package org.course.jdbc.repository;

import org.course.jdbc.entity.RepairRequestHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRequestHistoryRepository extends JpaRepository<RepairRequestHistoryEntity, String> {
    RepairRequestHistoryEntity getById(String id);
}

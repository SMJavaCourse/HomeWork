package org.course.jdbc.repository;

import org.course.jdbc.entity.RepairRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRequestRepository extends JpaRepository<RepairRequestEntity, String> {
    RepairRequestEntity getById(String id);
}

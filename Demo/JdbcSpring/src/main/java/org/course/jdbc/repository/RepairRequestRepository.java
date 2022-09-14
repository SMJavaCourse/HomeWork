package org.course.jdbc.repository;

import org.course.jdbc.entity.RepairRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepairRequestRepository extends JpaRepository<RepairRequestEntity, String> {
    Optional<RepairRequestEntity> findById(String id);

    List<RepairRequestEntity> findAllByClientId(String clientId);
}

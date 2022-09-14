package org.course.jdbc.repository.jdbc;

import org.course.jdbc.entity.RepairRequestEntity;
import org.course.jdbc.repository.RepairRequestRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
public class RepairRequestJDBCRepository implements RepairRequestRepository {
    @Override
    public RepairRequestEntity getById(String id) {
        return null;
    }
}

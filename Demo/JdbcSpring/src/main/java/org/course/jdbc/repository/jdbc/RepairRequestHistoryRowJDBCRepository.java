package org.course.jdbc.repository.jdbc;

import org.course.jdbc.entity.RepairRequestHistoryRowEntity;
import org.course.jdbc.repository.RepairRequestHistoryRowRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
public class RepairRequestHistoryRowJDBCRepository implements RepairRequestHistoryRowRepository {
    @Override
    public RepairRequestHistoryRowEntity getById(String id) {
        return null;
    }
}

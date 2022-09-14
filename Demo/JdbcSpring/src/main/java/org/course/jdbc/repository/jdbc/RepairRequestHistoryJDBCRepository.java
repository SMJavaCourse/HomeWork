package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.RepairRequestHistoryEntity;
import org.course.jdbc.repository.RepairRequestHistoryRepository;
import org.course.jdbc.repository.mapper.RepairRequestHistoryMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
@RequiredArgsConstructor
public class RepairRequestHistoryJDBCRepository implements RepairRequestHistoryRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public RepairRequestHistoryEntity getById(String id) {
        return jdbcTemplate.queryForObject("select id, repair_request_id, from_status, to_status, comment, created_ts from repair_request_history where id=?", RepairRequestHistoryMapper.getInstance(), id);
    }
}

package org.course.jdbc.repository.mapper;

import org.course.jdbc.entity.ClientEntity;
import org.course.jdbc.entity.RepairRequestHistoryEntity;
import org.course.jdbc.entity.RepairRequestStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairRequestHistoryMapper implements RowMapper<RepairRequestHistoryEntity> {
    private static RepairRequestHistoryMapper INSTANCE = null;

    private RepairRequestHistoryMapper() {
    }

    public static RepairRequestHistoryMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RepairRequestHistoryMapper();
            return INSTANCE;
        }
        return INSTANCE;
    }

    @Override
    public RepairRequestHistoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        RepairRequestHistoryEntity entity = new RepairRequestHistoryEntity();
        entity.setId(rs.getString("id"));
        entity.setRepairRequestId(rs.getString("repair_request_id"));
        entity.setFromStatus(RepairRequestStatus.valueOf(rs.getString("from_status")));
        entity.setToStatus(RepairRequestStatus.valueOf(rs.getString("to_status")));
        entity.setComment(rs.getString("comment"));
        entity.setCreatedTs(rs.getTimestamp("created_ts").toLocalDateTime());
        return entity;
    }
}

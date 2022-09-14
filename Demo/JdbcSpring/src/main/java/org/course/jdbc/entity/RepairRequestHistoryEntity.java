package org.course.jdbc.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RepairRequestHistoryEntity {
    private String id;
    private String repairRequestId;
    private RepairRequestStatus fromStatus;
    private RepairRequestStatus toStatus;
    private String comment;
    private LocalDateTime createdTs;
}

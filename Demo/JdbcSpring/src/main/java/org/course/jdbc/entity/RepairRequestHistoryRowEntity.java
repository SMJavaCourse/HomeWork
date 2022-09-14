package org.course.jdbc.entity;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class RepairRequestHistoryRowEntity {
    private String id;
    private String repairRequestId;
    private RepairRequestStatus fromStatus;
    private RepairRequestStatus toStatus;
    private String comment;
    private OffsetDateTime createdTs;
}

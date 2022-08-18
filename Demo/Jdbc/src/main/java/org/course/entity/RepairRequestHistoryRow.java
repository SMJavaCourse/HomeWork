package org.course.entity;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class RepairRequestHistoryRow {
    private String id;
    private String repairRequestId;
    private RepairRequestStatus fromStatus;
    private RepairRequestStatus toStatus;
    private String comment;
    private OffsetDateTime createdTs;
}

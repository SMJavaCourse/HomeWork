package org.course.jdbc.dto;

import lombok.Builder;
import lombok.Data;
import org.course.jdbc.entity.RepairRequestStatus;

@Data
@Builder
public class RepairRequestHistoryRowDto {
    private String id;
    private RepairRequestStatus fromStatus;
    private RepairRequestStatus toStatus;
    private String comment;
}

package org.course.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class RepairRequest {
    private String id;
    private RepairRequestStatus status;
    private String clientId;
    private String carVin;
    private OffsetDateTime createdTs;
}

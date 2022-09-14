package org.course.jdbc.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RepairRequestEntity {
    private String id;
    private RepairRequestStatus status;
    private String clientId;
    private String carVin;
    private LocalDateTime createdTs;
}

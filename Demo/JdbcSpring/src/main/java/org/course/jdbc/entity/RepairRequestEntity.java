package org.course.jdbc.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = RepairRequestEntity.TABLE)
public class RepairRequestEntity {
    public static final String TABLE = "repair_request";

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private RepairRequestStatus status;
    private String clientId;
    private String carVin;
    @CreationTimestamp
    private LocalDateTime createdTs;
}

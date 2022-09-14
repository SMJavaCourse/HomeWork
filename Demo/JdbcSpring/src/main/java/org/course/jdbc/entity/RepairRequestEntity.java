package org.course.jdbc.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = RepairRequestEntity.TABLE)
public class RepairRequestEntity {
    public static final String TABLE = "repair_request";

    @Id
    private String id;
    private RepairRequestStatus status;
    private String clientId;
    private String carVin;
    @CreationTimestamp
    private LocalDateTime createdTs;
}

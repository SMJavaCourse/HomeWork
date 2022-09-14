package org.course.jdbc.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = RepairRequestHistoryEntity.TABLE)
public class RepairRequestHistoryEntity {
    public static final String TABLE = "repair_request_history";

    @Id
    private String id;
    private String repairRequestId;
    private RepairRequestStatus fromStatus;
    private RepairRequestStatus toStatus;
    private String comment;
    @CreationTimestamp
    private LocalDateTime createdTs;
}

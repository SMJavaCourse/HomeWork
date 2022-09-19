package org.course.jdbc.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = RepairRequestHistoryEntity.TABLE)
public class RepairRequestHistoryEntity {
    public static final String TABLE = "repair_request_history";

    @Id
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "repair_request_id", nullable = false)
    private RepairRequestEntity repairRequest;
    @Enumerated(EnumType.STRING)
    private RepairRequestStatus fromStatus;
    @Enumerated(EnumType.STRING)
    private RepairRequestStatus toStatus;
    private String comment;
    @CreationTimestamp
    private LocalDateTime createdTs;
}

package org.course.jdbc.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = RepairRequestEntity.TABLE)
public class RepairRequestEntity {
    public static final String TABLE = "repair_request";

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private RepairRequestStatus status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_vin", referencedColumnName = "vin")
    private CarEntity car;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "repairRequest", fetch = FetchType.EAGER)
    private List<RepairRequestHistoryEntity> histories;
    @CreationTimestamp
    private LocalDateTime createdTs;
}

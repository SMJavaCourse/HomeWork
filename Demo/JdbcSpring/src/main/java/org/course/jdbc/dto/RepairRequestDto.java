package org.course.jdbc.dto;

import lombok.Data;
import org.course.jdbc.entity.RepairRequestStatus;

import java.util.List;

@Data
public class RepairRequestDto {
    private String id;
    private RepairRequestStatus status;
    private String carVin;
    private List<RepairRequestHistoryRowDto> histories;
}

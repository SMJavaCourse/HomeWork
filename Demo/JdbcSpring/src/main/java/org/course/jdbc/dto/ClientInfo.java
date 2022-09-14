package org.course.jdbc.dto;

import lombok.Builder;
import lombok.Data;
import org.course.jdbc.entity.RepairRequestEntity;

import java.util.List;

@Data
@Builder
public class ClientInfo {
    private ClientDto client;
    private List<CarDto> cars;
    private List<RepairRequestDto> repairRequests;
}

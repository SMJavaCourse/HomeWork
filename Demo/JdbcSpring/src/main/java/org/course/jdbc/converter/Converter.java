package org.course.jdbc.converter;

import org.course.jdbc.dto.CarDto;
import org.course.jdbc.dto.ClientDto;
import org.course.jdbc.dto.RepairRequestDto;
import org.course.jdbc.dto.RepairRequestHistoryRowDto;
import org.course.jdbc.entity.CarEntity;
import org.course.jdbc.entity.ClientEntity;
import org.course.jdbc.entity.RepairRequestEntity;
import org.course.jdbc.entity.RepairRequestHistoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Converter {
    public ClientDto toDto(ClientEntity client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .build();
    }

    public List<CarDto> toDto(List<CarEntity> cars) {
        return cars.stream()
                .map(carEntity -> {
                    return CarDto.builder()
                            .vin(carEntity.getVin())
                            .make(carEntity.getMake())
                            .model(carEntity.getModel())
                            .build();
                }).collect(Collectors.toList());
    }

    public List<RepairRequestDto> toRepairDto(List<RepairRequestEntity> repairRequests) {
        return repairRequests.stream()
                .map(repairRequestEntity -> {
                    return RepairRequestDto.builder()
                            .id(repairRequestEntity.getId())
                            .status(repairRequestEntity.getStatus())
                            .carVin(repairRequestEntity.getCar().getVin())
                            .histories(toHistoryDto(repairRequestEntity.getHistories()))
                            .build();
                }).collect(Collectors.toList());
    }

    private List<RepairRequestHistoryRowDto> toHistoryDto(List<RepairRequestHistoryEntity> histories) {
        return histories.stream()
                .map(historyEntity -> {
                    return RepairRequestHistoryRowDto.builder()
                            .id(historyEntity.getId())
                            .fromStatus(historyEntity.getFromStatus())
                            .toStatus(historyEntity.getToStatus())
                            .comment(historyEntity.getComment())
                            .build();
                }).collect(Collectors.toList());
    }
}

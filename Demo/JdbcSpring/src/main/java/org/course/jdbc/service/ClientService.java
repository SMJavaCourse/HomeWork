package org.course.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.converter.Converter;
import org.course.jdbc.dto.ClientInfo;
import org.course.jdbc.entity.CarEntity;
import org.course.jdbc.repository.CarRepository;
import org.course.jdbc.repository.ClientRepository;
import org.course.jdbc.repository.RepairRequestHistoryRepository;
import org.course.jdbc.repository.RepairRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;
    private final RepairRequestRepository repairRequestRepository;
    private final RepairRequestHistoryRepository repairRequestHistoryRepository;
    private final Converter converter;

    public ClientInfo getClientInfo(String id) {
        var client = clientRepository.findById("14fbd742-ab98-4730-a58d-9f0ac72126bf").get();
        var repairRequests = repairRequestRepository.findAllByClientId(client.getId());

        return ClientInfo.builder()
                .client(converter.toDto(client))
                .cars(converter.toDto(client.getCars()))
                .repairRequests(converter.toRepairDto(repairRequests))
                .build();
    }
}

package org.course.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.converter.Converter;
import org.course.jdbc.dto.ClientInfo;
import org.course.jdbc.repository.CarRepository;
import org.course.jdbc.repository.ClientRepository;
import org.course.jdbc.repository.RepairRequestHistoryRepository;
import org.course.jdbc.repository.RepairRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        var client = clientRepository.getById("14fbd742-ab98-4730-a58d-9f0ac72126bf");
        var car = carRepository.getById("1FF2F2F2123324");
        var repairRequest = repairRequestRepository.getById("38acfb91-552f-46ed-9bdd-8d70f2814db0");
        var requestHistory = repairRequestHistoryRepository.getById("0b5c98d5-09d3-4514-943c-cfe99992dc15");
        return ClientInfo.builder()
                .client(converter.toDto(client))
                .cars(null)
                .repairRequests(null)
                .build();
    }
}

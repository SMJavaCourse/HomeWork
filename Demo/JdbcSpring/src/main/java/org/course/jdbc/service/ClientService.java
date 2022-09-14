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
        var client = clientRepository.getById(id);
        return ClientInfo.builder()
                .client(converter.toDto(client))
                .cars(null)
                .repairRequests(null)
                .build();
    }
}

package org.course.jdbc.service;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.converter.Converter;
import org.course.jdbc.dto.ClientInfo;
import org.course.jdbc.repository.ClientRepository;
import org.course.jdbc.repository.RepairRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final RepairRequestRepository repairRequestRepository;
    private final Converter converter;

    public ClientInfo getClientInfo(String id) {
        var optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            return null;
        }
        var client = optionalClient.get();
        var repairRequests = repairRequestRepository.findAllByClientId(client.getId());

        return ClientInfo.builder()
                .client(converter.toDto(client))
                .cars(converter.toDto(client.getCars()))
                .repairRequests(converter.toRepairDto(repairRequests))
                .build();
    }
}

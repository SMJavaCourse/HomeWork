package org.course.jdbc.converter;

import org.course.jdbc.dto.ClientDto;
import org.course.jdbc.entity.ClientEntity;
import org.springframework.stereotype.Service;

@Service
public class Converter {
    public ClientDto toDto(ClientEntity client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .build();
    }
}

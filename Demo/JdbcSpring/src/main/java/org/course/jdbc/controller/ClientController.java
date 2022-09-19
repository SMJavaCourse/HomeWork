package org.course.jdbc.controller;

import org.course.jdbc.dto.ClientInfo;
import org.course.jdbc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientInfo> getClientInfo(@PathVariable String id) {
        return ResponseEntity.of(Optional.ofNullable(clientService.getClientInfo(id)));
    }
}

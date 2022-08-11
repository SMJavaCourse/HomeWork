package org.course.service;

import org.apache.commons.collections4.CollectionUtils;
import org.course.dao.CarRepository;
import org.course.dao.ClientRepository;
import org.course.dto.ClientWithCars;
import org.course.entity.Client;
import org.course.entity.RepairRequest;

import java.util.List;
import java.util.NoSuchElementException;

public class ClientService {

    private static final ClientRepository CLIENT_REPOSITORY = ClientRepository.getInstance();
    private static final CarRepository CAR_REPOSITORY = CarRepository.getInstance();
    private static final RepairRequestService REPAIR_REQUEST_SERVICE = new RepairRequestService();

    public Client saveClient(Client client) {
        return CLIENT_REPOSITORY.save(client);
    }

    public Client getById(String clientId) {
        var client = CLIENT_REPOSITORY.byId(clientId);
        if (client == null) {
            throw new NoSuchElementException("Couldn't find client with id: " + clientId);
        }
        return client;
    }

    public List<Client> getAll() {
        return CLIENT_REPOSITORY.all();
    }

    public ClientWithCars getClientWithCars(String clientId) {
        var clientWithCarBuilder = ClientWithCars.builder();
        var client = getById(clientId);
        clientWithCarBuilder.client(client);
        var repairRequests = REPAIR_REQUEST_SERVICE.getClientRequests(clientId);
        if (CollectionUtils.isEmpty(repairRequests)) {
            return clientWithCarBuilder.build();
        }
        var carVins = repairRequests.stream().map(RepairRequest::getCarVin).toList();
        clientWithCarBuilder.cars(CAR_REPOSITORY.find(carVins));
        return clientWithCarBuilder.build();
    }


}

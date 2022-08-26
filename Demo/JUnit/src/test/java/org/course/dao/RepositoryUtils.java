package org.course.dao;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RepositoryUtils {
    private final CarRepository carRepository = CarRepository.getInstance();
    private final ClientRepository clientRepository = ClientRepository.getInstance();
    private final RepairRequestHistoryRepository repairRequestHistoryRepository = RepairRequestHistoryRepository.getInstance();
    private final RepairRequestRepository repairRequestRepository = RepairRequestRepository.getInstance();


    public void deleteAll(Repository repository){
        repository.deleteAll();
    }
    public void deleteAllCars() {
        carRepository.deleteAll();
    }

    public void deleteAllClients() {
        clientRepository.deleteAll();
    }

    public void deleteAllRepairRequestHistories() {
        repairRequestHistoryRepository.deleteAll();
    }

    public void deleteAllRepairRequests() {
        repairRequestRepository.deleteAll();
    }
}

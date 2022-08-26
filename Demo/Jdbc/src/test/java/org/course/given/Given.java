package org.course.given;

import org.course.dao.CarRepository;
import org.course.dao.ClientRepository;
import org.course.dao.RepairRequestHistoryRepository;
import org.course.dao.RepairRequestRepository;
import org.course.entity.Car;
import org.course.entity.Client;
import org.course.entity.RepairRequest;
import org.course.entity.RepairRequestHistoryRow;
import org.course.util.EasyRandomTestUtils;
import org.jeasy.random.EasyRandom;

import java.util.UUID;

public class Given {
    private final EasyRandom easyRandom = EasyRandomTestUtils.create();

    public EntityBuilder<Car, String> cars() {
        return new EntityBuilder<>(Car.class, CarRepository.getInstance(), easyRandom,
                car -> {
                    car.setVin(UUID.randomUUID().toString());
                });
    }

    public EntityBuilder<Client, String> clients() {
        return new EntityBuilder<>(Client.class, ClientRepository.getInstance(), easyRandom,
                client -> {
                    client.setId(UUID.randomUUID().toString());
                });
    }

    public EntityBuilder<RepairRequest, String> repairRequests() {
        return new EntityBuilder<>(RepairRequest.class, RepairRequestRepository.getInstance(), easyRandom,
                rr -> {
                    rr.setId(UUID.randomUUID().toString());
                });
    }

    public EntityBuilder<RepairRequestHistoryRow, String> repairRequestsHistory() {
        return new EntityBuilder<>(RepairRequestHistoryRow.class, RepairRequestHistoryRepository.getInstance(), easyRandom,
                rrhr -> {
                    rrhr.setId(UUID.randomUUID().toString());
                });
    }

}

package org.course.dao;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.course.entity.RepairRequest;
import org.course.entity.RepairRequestStatus;

import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

public class RepairRequestRepository extends Repository<RepairRequest, String> {
    private static final Map<String, RepairRequest> requestById = new HashMap<>();
    private static volatile RepairRequestRepository instance;

    public static RepairRequestRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (ClientRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RepairRequestRepository();
                }
            }
        }
        return localInstance;
    }

    private RepairRequestRepository() {
    }

    public List<RepairRequest> all() {
        return requestById.values().stream().sorted(defaultComparator()).toList();
    }

    public List<RepairRequest> find(List<String> ids,
                                    String clientId,
                                    String carVin) {
        var stream = requestById.values().stream();
        if (CollectionUtils.isNotEmpty(ids)) {
            stream = stream.filter(rr -> ids.contains(rr.getId()));
        }
        if (StringUtils.isNotBlank(clientId)) {
            stream = stream.filter(rr -> clientId.equalsIgnoreCase(rr.getClientId()));
        }
        if (StringUtils.isNotBlank(carVin)) {
            stream = stream.filter(rr -> carVin.equalsIgnoreCase(rr.getCarVin()));
        }
        return stream.sorted(defaultComparator()).toList();
    }

    public RepairRequest save(RepairRequest repairRequest) {
        if (repairRequest.getId() == null) {
            repairRequest.setId(UUID.randomUUID().toString());
        }
        if(repairRequest.getCreatedTs() == null) {
            repairRequest.setCreatedTs(OffsetDateTime.now());
        }
        requestById.put(repairRequest.getId(), repairRequest);
        return repairRequest;
    }

    public RepairRequest byId(String id) {
        return requestById.get(id);
    }

    @Override
    void deleteAll() {
        requestById.clear();
    }

    public RepairRequest changeStatus(String id, RepairRequestStatus status) {
        var request = requestById.get(id);
        if (request == null) {
            throw new NoSuchElementException("Not found repair request with id: " + id);
        }
        request.setStatus(status);
        return request;
    }

    public RepairRequest delete(String id) {
        return requestById.remove(id);
    }

    private Comparator<RepairRequest> defaultComparator() {
        return Comparator.comparing(RepairRequest::getCreatedTs);
    }
}

package org.course.service;

import org.course.dao.RepairRequestRepository;
import org.course.entity.RepairRequest;
import org.course.entity.RepairRequestHistoryRow;
import org.course.entity.RepairRequestStatus;
import org.course.exception.ValidationCode;
import org.course.exception.ValidationException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class RepairRequestService {

    private static final Map<RepairRequestStatus, List<RepairRequestStatus>> ALLOWED_TRANSITIONS = Map.of(
            RepairRequestStatus.NEW, List.of(RepairRequestStatus.ON_APPROVE, RepairRequestStatus.IN_PROGRESS, RepairRequestStatus.FINISHED),
            RepairRequestStatus.ON_APPROVE, List.of(RepairRequestStatus.IN_PROGRESS, RepairRequestStatus.FINISHED),
            RepairRequestStatus.IN_PROGRESS, List.of(RepairRequestStatus.ON_APPROVE, RepairRequestStatus.FINISHED),
            RepairRequestStatus.FINISHED, Collections.emptyList()
    );

    private static final RepairRequestRepository REPAIR_REQUEST_REPOSITORY = RepairRequestRepository.getInstance();
    private final RepairRequestHistoryService historyService = new RepairRequestHistoryService();

    public RepairRequest saveRepairRequest(RepairRequest repairRequest) {
        return REPAIR_REQUEST_REPOSITORY.save(repairRequest);
    }

    public List<RepairRequest> getCarRequests(String carVin) {
        return REPAIR_REQUEST_REPOSITORY.find(null, null, carVin);
    }

    public List<RepairRequest> getClientRequests(String clientId) {
        return REPAIR_REQUEST_REPOSITORY.find(null, clientId, null);
    }

    public RepairRequest getById(String repairRequestId) {
        return REPAIR_REQUEST_REPOSITORY.byId(repairRequestId);
    }

    public List<RepairRequest> getAll() {
        return REPAIR_REQUEST_REPOSITORY.all();
    }

    public RepairRequest changeStatus(
            String repairRequestId,
            RepairRequestStatus status,
            String comment
    ) {
        var repairRequest = REPAIR_REQUEST_REPOSITORY.byId(repairRequestId);
        if (repairRequest == null) {
            throw new NoSuchElementException("Not found repair request with id: " + repairRequestId);
        }
        var historyRow = RepairRequestHistoryRow.builder()
                .repairRequestId(repairRequestId)
                .fromStatus(repairRequest.getStatus())
                .toStatus(status)
                .comment(comment)
                .build();
        if (!ALLOWED_TRANSITIONS.get(repairRequest.getStatus()).contains(status)) {
            throw new ValidationException("Status", ValidationCode.INVALID);
        }
        var updatedRepairRequest = REPAIR_REQUEST_REPOSITORY.changeStatus(repairRequestId, status);
        historyService.saveRepairRequest(historyRow);
        return updatedRepairRequest;
    }

}

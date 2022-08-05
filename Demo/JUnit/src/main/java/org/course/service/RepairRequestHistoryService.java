package org.course.service;

import org.course.dao.RepairRequestHistoryRepository;
import org.course.entity.RepairRequestHistoryRow;
import org.course.validators.RepairRequestHistoryRowValidator;

import java.util.List;

public class RepairRequestHistoryService {
    private static final RepairRequestHistoryRepository REPAIR_REQUEST_HISTORY_REPOSITORY = RepairRequestHistoryRepository.getInstance();
    private static final RepairRequestHistoryRowValidator VALIDATOR = new RepairRequestHistoryRowValidator();

    public RepairRequestHistoryRow saveRepairRequest(RepairRequestHistoryRow historyRow) {
        VALIDATOR.validate(historyRow);
        return REPAIR_REQUEST_HISTORY_REPOSITORY.save(historyRow);
    }

    public List<RepairRequestHistoryRow> getByRepairRequestId(String repairRequestId) {
        return REPAIR_REQUEST_HISTORY_REPOSITORY.byRepairRequestId(repairRequestId);
    }

}

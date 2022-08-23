package org.course.validators;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.course.entity.RepairRequestHistoryRow;
import org.course.exception.ValidationCode;
import org.course.exception.ValidationException;

public class RepairRequestHistoryRowValidator {

    @SneakyThrows
    public void validate(RepairRequestHistoryRow historyRow) {
        if (StringUtils.isBlank(historyRow.getRepairRequestId())) {
            throw new ValidationException("repairRequestId", ValidationCode.EMPTY);
        }
        if (historyRow.getFromStatus() == null) {
            throw new ValidationException("fromStatus", ValidationCode.EMPTY);
        }
        if (historyRow.getToStatus() == null) {
            throw new ValidationException("toStatus", ValidationCode.EMPTY);
        }
    }
}

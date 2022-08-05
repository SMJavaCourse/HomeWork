package org.course.validators;

import org.course.entity.RepairRequestHistoryRow;
import org.course.entity.RepairRequestStatus;
import org.course.exception.ValidationCode;
import org.course.exception.ValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepairRequestHistoryRowValidatorTest {

    private final RepairRequestHistoryRowValidator validator = new RepairRequestHistoryRowValidator();

    @Test
    public void validate_shouldReturnErrorOnEmptyRepairRequestId() {
        var repairRequestHistoryRow = RepairRequestHistoryRow
                .builder()
                .build();
        var exception = assertThrows(ValidationException.class, () -> validator.validate(repairRequestHistoryRow));
        assertEquals("repairRequestId", exception.getField());
        assertEquals(ValidationCode.EMPTY, exception.getCode());
    }

    @Test
    public void validate_shouldReturnErrorOnEmptyFromStatus() {
        var repairRequestHistoryRow = RepairRequestHistoryRow
                .builder()
                .repairRequestId(UUID.randomUUID().toString())
                .build();
        var exception = assertThrows(ValidationException.class, () -> validator.validate(repairRequestHistoryRow));
        assertEquals("fromStatus", exception.getField());
        assertEquals(ValidationCode.EMPTY, exception.getCode());
    }

    @Test
    public void validate_shouldReturnErrorOnEmptyToStatus() {
        var repairRequestHistoryRow = RepairRequestHistoryRow
                .builder()
                .repairRequestId(UUID.randomUUID().toString())
                .fromStatus(RepairRequestStatus.NEW)
                .build();
        var exception = assertThrows(ValidationException.class, () -> validator.validate(repairRequestHistoryRow));
        assertEquals("toStatus", exception.getField());
        assertEquals(ValidationCode.EMPTY, exception.getCode());
    }

}

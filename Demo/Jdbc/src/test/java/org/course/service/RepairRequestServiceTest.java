package org.course.service;

import org.course.TestBase;
import org.course.entity.RepairRequestStatus;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepairRequestServiceTest extends TestBase {

    private final RepairRequestService service = new RepairRequestService();

    @ParameterizedTest
    @EnumSource
    public void changeStatus_shouldChangeStatusFromNewToAnyOther(RepairRequestStatus newStatus) {
        Assumptions.assumeFalse(newStatus == RepairRequestStatus.NEW, "Do not need move from NEW to NEW statuses");
        var repairRequest = given.repairRequests().with(rr -> rr.setStatus(RepairRequestStatus.NEW)).buildSingle();
        var updatedRepairRequest = service.changeStatus(repairRequest.getId(), newStatus, null);
        assertEquals(repairRequest.getId(), updatedRepairRequest.getId());
        assertEquals(newStatus, updatedRepairRequest.getStatus());
    }

    @ParameterizedTest
    @EnumSource(value = RepairRequestStatus.class, names = {"IN_PROGRESS", "FINISHED"})
    public void changeStatus_shouldChangeStatusFromOnApproveToAnyOther(RepairRequestStatus newStatus) {
        var repairRequest = given.repairRequests().with(rr -> rr.setStatus(RepairRequestStatus.ON_APPROVE)).buildSingle();
        var updatedRepairRequest = service.changeStatus(repairRequest.getId(), newStatus, null);
        assertEquals(repairRequest.getId(), updatedRepairRequest.getId());
        assertEquals(newStatus, updatedRepairRequest.getStatus());
    }

    @ParameterizedTest
    @EnumSource(value = RepairRequestStatus.class, mode = EnumSource.Mode.EXCLUDE, names = {"NEW", "IN_PROGRESS"})
    public void changeStatus_shouldChangeStatusFromInProgressToAnyOther(RepairRequestStatus newStatus) {
        var repairRequest = given.repairRequests().with(rr -> rr.setStatus(RepairRequestStatus.IN_PROGRESS)).buildSingle();
        var updatedRepairRequest = service.changeStatus(repairRequest.getId(), newStatus, null);
        assertEquals(repairRequest.getId(), updatedRepairRequest.getId());
        assertEquals(newStatus, updatedRepairRequest.getStatus());
    }

    @ParameterizedTest
    @CsvSource({
            "ON_APPROVE",
            "FINISHED"
    })
    public void changeStatus_shouldChangeStatusFromInProgressToAnyOtherWithCsvSource(RepairRequestStatus newStatus) {
        var repairRequest = given.repairRequests().with(rr -> rr.setStatus(RepairRequestStatus.IN_PROGRESS)).buildSingle();
        var updatedRepairRequest = service.changeStatus(repairRequest.getId(), newStatus, null);
        assertEquals(repairRequest.getId(), updatedRepairRequest.getId());
        assertEquals(newStatus, updatedRepairRequest.getStatus());
    }

}

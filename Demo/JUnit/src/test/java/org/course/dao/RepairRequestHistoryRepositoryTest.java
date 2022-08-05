package org.course.dao;

import org.course.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RepairRequestHistoryRepositoryTest extends TestBase {
    private final RepairRequestHistoryRepository repository = RepairRequestHistoryRepository.getInstance();

    @RepeatedTest(3)
    @DisplayName("Should successfully save random history rows several times")
    void save_shouldSuccessfullySaveRandomRows() {
        var historyRow = given.repairRequestsHistory().withAny().buildSingle();
        var savedHistoryRow = repository.save(historyRow);
        assertNotNull(savedHistoryRow, "History row can't to save");
    }
}

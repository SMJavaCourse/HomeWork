package org.course.dao;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.course.entity.RepairRequestHistoryRow;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class RepairRequestHistoryRepository extends Repository<RepairRequestHistoryRow, String> {
    private static final Map<String, List<RepairRequestHistoryRow>> historyByRepairRequestId = new HashMap<>();
    private static volatile RepairRequestHistoryRepository instance;

    public static RepairRequestHistoryRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (ClientRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RepairRequestHistoryRepository();
                }
            }
        }
        return localInstance;
    }

    private RepairRequestHistoryRepository() {
    }

    @Override
    public List<RepairRequestHistoryRow> all() {
        return historyByRepairRequestId.values()
                .stream()
                .flatMap(List::stream)
                .toList();
    }

    @SneakyThrows
    public RepairRequestHistoryRow save(RepairRequestHistoryRow historyRow) {
        if (StringUtils.isBlank(historyRow.getRepairRequestId())) {
            throw new Exception("RepairRequestId cannot be blank");
        }
        if (historyRow.getId() == null) {
            historyRow.setId(UUID.randomUUID().toString());
        }
        if (historyRow.getCreatedTs() == null) {
            historyRow.setCreatedTs(OffsetDateTime.now());
        }
        if (!historyByRepairRequestId.containsKey(historyRow.getRepairRequestId())) {
            historyByRepairRequestId.put(historyRow.getRepairRequestId(), new ArrayList<>());
        }
        historyByRepairRequestId.get(historyRow.getRepairRequestId()).add(historyRow);
        return historyRow;
    }

    @Override
    public RepairRequestHistoryRow byId(String id) {
        return historyByRepairRequestId.values()
                .stream()
                .flatMap(List::stream)
                .filter(historyRow -> historyRow.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    void deleteAll() {
        historyByRepairRequestId.clear();
    }

    public List<RepairRequestHistoryRow> byRepairRequestId(String id) {
        return Optional.ofNullable(historyByRepairRequestId.get(id))
                .orElse(Collections.emptyList())
                .stream()
                .sorted(defaultComparator())
                .toList();
    }

    private Comparator<RepairRequestHistoryRow> defaultComparator() {
        return Comparator.comparing(RepairRequestHistoryRow::getCreatedTs);
    }
}

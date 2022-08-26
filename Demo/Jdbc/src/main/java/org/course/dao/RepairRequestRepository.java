package org.course.dao;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.course.entity.RepairRequest;
import org.course.entity.RepairRequestStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class RepairRequestRepository extends Repository<RepairRequest, String> {
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
        try (var connection = DataSource.getConnection();
             var statement = connection.createStatement();
             var rs = statement.executeQuery("SELECT * FROM repair_request")) {
            var result = new ArrayList<RepairRequest>();
            while (rs.next()) {
                result.add(extractRepairRequest(rs));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private RepairRequest extractRepairRequest(ResultSet rs) throws SQLException {
        var repairRequest = new RepairRequest();
        repairRequest.setId(rs.getString(1));
        repairRequest.setStatus(RepairRequestStatus.valueOf(rs.getString(2)));
        repairRequest.setClientId(rs.getString(3));
        repairRequest.setCarVin(rs.getString(4));
        var ts = rs.getTimestamp(5);
        var dataTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(ts.getTime()), ZoneId.of("UTC"));
        repairRequest.setCreatedTs(dataTime);
        return repairRequest;
    }

    public List<RepairRequest> find(List<String> ids,
                                    String clientId,
                                    String carVin) {
        var result = new ArrayList<RepairRequest>();
        var query = "SELECT * FROM repair_request";
        if (CollectionUtils.isNotEmpty(ids) || StringUtils.isNotBlank(clientId) || StringUtils.isNotBlank(carVin)) {
            query += " WHERE";
            var whereConditions = new ArrayList<String>();
            if (CollectionUtils.isNotEmpty(ids)) {
                whereConditions.add(" id in (" + String.join(", ", ids) +")");
            }
            if (StringUtils.isNotBlank(clientId)) {
                whereConditions.add(" client_id = ?");
            }
            if (StringUtils.isNotBlank(carVin)) {
                whereConditions.add(" car_vin = ?");
            }
            query += String.join(" AND", whereConditions);
        }
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement(query)) {
            int shift = 1;
            if (StringUtils.isNotBlank(clientId)) {
                statement.setString(shift, clientId);
                shift++;
            }
            if (StringUtils.isNotBlank(carVin)) {
                statement.setString(shift, clientId);
                shift++;
            }
            try (var rs = statement.executeQuery()) {
                while (rs.next()) {
                    result.add(extractRepairRequest(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public RepairRequest save(RepairRequest repairRequest) {
        if (repairRequest.getId() == null) {
            repairRequest.setId(UUID.randomUUID().toString());
        }
        if (repairRequest.getCreatedTs() == null) {
            repairRequest.setCreatedTs(OffsetDateTime.now());
        }
        if (byId(repairRequest.getId()) != null) {
            try (var connection = DataSource.getConnection();
                 var statement = connection.prepareStatement("UPDATE repair_request SET status = ?, clientId = ?, carVin = ? WHERE id = ?")) {
                statement.setString(1, repairRequest.getStatus().name());
                statement.setString(2, repairRequest.getClientId());
                statement.setString(3, repairRequest.getCarVin());
                statement.setString(4, repairRequest.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (var connection = DataSource.getConnection();
                 var statement = connection.prepareStatement("INSERT INTO repair_request VALUES (?, ?, ?, ?, ?)")) {
                statement.setString(1, repairRequest.getId());
                statement.setString(2, repairRequest.getStatus().name());
                statement.setString(3, repairRequest.getClientId());
                statement.setString(4, repairRequest.getCarVin());
                var ts = Timestamp.valueOf(repairRequest.getCreatedTs().atZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime());
                statement.setTimestamp(5, ts);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return byId(repairRequest.getId());
    }

    public RepairRequest byId(String id) {
        RepairRequest result = null;
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement("SELECT * FROM repair_request WHERE id = ?")) {
            statement.setString(1, id);
            try (var rs = statement.executeQuery()) {
                if (rs.next()) {
                    result = extractRepairRequest(rs);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    void deleteAll() {
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement("DELETE FROM repair_request")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RepairRequest changeStatus(String id, RepairRequestStatus status) {
        if (byId(id) != null) {
            try (var connection = DataSource.getConnection();
                 var statement = connection.prepareStatement("UPDATE repair_request SET status = ? WHERE id = ?")) {
                statement.setString(1, status.name());
                statement.setString(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new NoSuchElementException("Not found repair request with id: " + id);
        }
        return byId(id);
    }

    public RepairRequest delete(String id) {
        var result = byId(id);
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement("DELETE FROM repair_request WHERE id = ?")) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Comparator<RepairRequest> defaultComparator() {
        return Comparator.comparing(RepairRequest::getCreatedTs);
    }
}

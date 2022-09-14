package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.RepairRequestHistoryEntity;
import org.course.jdbc.repository.RepairRequestHistoryRepository;
import org.course.jdbc.repository.mapper.RepairRequestHistoryMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@ConditionalOnProperty(name = "course.implement", havingValue = "true")
@RequiredArgsConstructor
public class RepairRequestHistoryJDBCRepository implements RepairRequestHistoryRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<RepairRequestHistoryEntity> findAll() {
        return null;
    }

    @Override
    public List<RepairRequestHistoryEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RepairRequestHistoryEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RepairRequestHistoryEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(RepairRequestHistoryEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends RepairRequestHistoryEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RepairRequestHistoryEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RepairRequestHistoryEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RepairRequestHistoryEntity> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends RepairRequestHistoryEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RepairRequestHistoryEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RepairRequestHistoryEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RepairRequestHistoryEntity getOne(String s) {
        return null;
    }

    @Override
    public RepairRequestHistoryEntity getById(String id) {
        return jdbcTemplate.queryForObject("select id, repair_request_id, from_status, to_status, comment, created_ts from repair_request_history where id=?", RepairRequestHistoryMapper.getInstance(), id);
    }

    @Override
    public RepairRequestHistoryEntity getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends RepairRequestHistoryEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RepairRequestHistoryEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RepairRequestHistoryEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RepairRequestHistoryEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RepairRequestHistoryEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RepairRequestHistoryEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RepairRequestHistoryEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

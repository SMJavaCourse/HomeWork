package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.RepairRequestEntity;
import org.course.jdbc.repository.RepairRequestRepository;
import org.course.jdbc.repository.mapper.RepairRequestMapper;
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
public class RepairRequestJDBCRepository implements RepairRequestRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<RepairRequestEntity> findAll() {
        return null;
    }

    @Override
    public List<RepairRequestEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<RepairRequestEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<RepairRequestEntity> findAllById(Iterable<String> strings) {
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
    public void delete(RepairRequestEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends RepairRequestEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends RepairRequestEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RepairRequestEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RepairRequestEntity> findById(String s) {
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
    public <S extends RepairRequestEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends RepairRequestEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<RepairRequestEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public RepairRequestEntity getOne(String s) {
        return null;
    }

    @Override
    public RepairRequestEntity getById(String id) {
        return jdbcTemplate.queryForObject("select id, status, client_id, car_vin, created_ts from repair_request where id=?", RepairRequestMapper.getInstance(), id);
    }

    @Override
    public RepairRequestEntity getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends RepairRequestEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends RepairRequestEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends RepairRequestEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends RepairRequestEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends RepairRequestEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends RepairRequestEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends RepairRequestEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

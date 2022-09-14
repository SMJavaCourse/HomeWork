package org.course.jdbc.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.course.jdbc.entity.CarEntity;
import org.course.jdbc.repository.CarRepository;
import org.course.jdbc.repository.mapper.CarMapper;
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
public class CarJDBCRepository implements CarRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CarEntity> findAll() {
        return null;
    }

    @Override
    public List<CarEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CarEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CarEntity> findAllById(Iterable<String> strings) {
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
    public void delete(CarEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends CarEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CarEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CarEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CarEntity> findById(String s) {
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
    public <S extends CarEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends CarEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CarEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CarEntity getOne(String s) {
        return null;
    }

    @Override
    public CarEntity getById(String id) {
        return jdbcTemplate.queryForObject("select vin, make, model from cars where vin=?", CarMapper.getInstance(), id);
    }

    @Override
    public CarEntity getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends CarEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CarEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CarEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CarEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CarEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CarEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends CarEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

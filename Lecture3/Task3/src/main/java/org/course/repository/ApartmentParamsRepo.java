package org.course.repository;

import org.course.entity.ApartmentParamsEntity;

import javax.sql.DataSource;
import java.util.List;

public class ApartmentParamsRepo extends Repository<ApartmentParamsEntity, String>{
    private DataSource dataSource;

    public ApartmentParamsRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List all() {
        return null;
    }

    @Override
    public ApartmentParamsEntity save(ApartmentParamsEntity o) {
        return null;
    }

    @Override
    public ApartmentParamsEntity getById(String id) {
        return new ApartmentParamsEntity();
    }
}

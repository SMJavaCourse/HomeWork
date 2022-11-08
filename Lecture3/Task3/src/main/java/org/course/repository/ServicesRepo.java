package org.course.repository;

import org.course.entity.ServicesEntity;

import javax.sql.DataSource;
import java.util.List;

public class ServicesRepo extends Repository<ServicesEntity, String>{
    private DataSource dataSource;

    public ServicesRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List all() {
        return null;
    }

    @Override
    public ServicesEntity save(ServicesEntity o) {
        return null;
    }

    @Override
    public ServicesEntity getById(String id) {
        return new ServicesEntity();
    }
}

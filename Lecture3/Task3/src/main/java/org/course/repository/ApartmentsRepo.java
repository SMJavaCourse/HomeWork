package org.course.repository;

import org.course.entity.ApartmentEntity;

import javax.sql.DataSource;
import java.util.List;

public class ApartmentsRepo extends Repository<ApartmentEntity, String>{
    private DataSource dataSource;
    public ApartmentsRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<ApartmentEntity> all() {
        return null;
    }

    @Override
    public ApartmentEntity save(ApartmentEntity o) {
        return null;
    }

    @Override
    public ApartmentEntity getById(String id) {
        return new ApartmentEntity();
    }

    public List<ApartmentEntity> getByHotelId(String hotelId) {
        return List.of(new ApartmentEntity());
    }
}

package org.course.repository;

import java.util.List;

public abstract class Repository<ENTITY, ID> {

    public abstract List<ENTITY> all();
    public abstract ENTITY save(ENTITY entity);
    public abstract ENTITY getById(ID id);

    public <S extends ENTITY> List<S> saveAll(Iterable<S> entities) {
        for (ENTITY entity : entities) {
            save(entity);
        }
        return (List<S>) entities;
    }
}

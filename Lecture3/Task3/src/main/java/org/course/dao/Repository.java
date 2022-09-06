package org.course.dao;

import java.util.List;

public abstract class Repository<ENTITY, ID> {

    public abstract List<ENTITY> all();
    public abstract ENTITY save(ENTITY entity);
    public abstract ENTITY byId(ID id);

    public <S extends ENTITY> List<S> saveAll(Iterable<S> entities) {
        for (ENTITY entity : entities) {
            save(entity);
        }
        return (List<S>) entities;
    }
}

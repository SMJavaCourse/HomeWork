package org.course.given;

import lombok.RequiredArgsConstructor;
import org.course.dao.Repository;
import org.jeasy.random.EasyRandom;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class EntityBuilder<Entity, Id> {

    private final Class<Entity> type;
    private final Repository<Entity, Id> repository;
    private final EasyRandom random;
    private final List<Entity> entityList = new LinkedList<>();
    private Consumer<Entity> initialSetup = entity -> {
    };

    public EntityBuilder(Class<Entity> type,
                         Repository<Entity, Id> repository,
                         EasyRandom random,
                         Consumer<Entity> initialSetup) {
        this(type, repository, random);
        this.initialSetup = initialSetup;
    }

    public EntityBuilder<Entity, Id> with(Consumer<Entity> customizer) {
        var entity = random.nextObject(type);
        initialSetup.accept(entity);
        customizer.accept(entity);
        entityList.add(entity);
        return this;
    }

    public EntityBuilder<Entity, Id> withAny() {
        return with(r -> {
        });
    }

    public EntityBuilder<Entity, Id> withSome(int count) {
        IntStream.range(0, count).forEach(i -> withAny());
        return this;
    }

    public EntityBuilder<Entity, Id> withSome(int count, Function<Integer, Consumer<Entity>> customFunction) {
        IntStream.range(0, count).forEach(i -> with(customFunction.apply(i)));
        return this;
    }

    public List<Entity> build() {
        return repository.saveAll(entityList);
    }

    public Entity buildSingle() {
        if (entityList.size() != 1) {
            throw new IllegalStateException("buildSingle expects one value to be added");
        }
        return build().get(0);
    }
}

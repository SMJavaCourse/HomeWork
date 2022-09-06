package org.course.cities.repository.stub;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.course.cities.entity.RegionEntity;
import org.course.cities.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
@ConditionalOnProperty(name = "cities.repository.stub", havingValue = "true")
public class RegionsStubRepository implements RegionsRepository {
    @Value("classpath:stub/regions.json")
    private Resource resource;
    private Map<String, RegionEntity> regions;
    private final ObjectMapper objectMapper;

    @Autowired
    public RegionsStubRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @PostConstruct
    void parseFile() {
        var content = objectMapper.readValue(resource.getFile(), RegionsContent.class);
        regions = content.getContent().stream()
                .collect(Collectors.toMap(RegionEntity::getId, Function.identity()));
    }

    @Override
    public RegionEntity getById(String id) {
        return regions.get(id);
    }

    @Data
    private static class RegionsContent {
        private List<RegionEntity> content;
    }
}

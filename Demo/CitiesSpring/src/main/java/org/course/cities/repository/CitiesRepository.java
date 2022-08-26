package org.course.cities.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.course.cities.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class CitiesRepository {
    @Value("classpath:stub/cities.json")
    private Resource resource;
    private Map<String, CityEntity> cities;
    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @PostConstruct
    void parseFile() {
        var citiesContent = objectMapper.readValue(resource.getFile(), CitiesContent.class);
        cities = citiesContent.getContent().stream()
                .collect(Collectors.toMap(CityEntity::getId, Function.identity()));
    }

    public CityEntity getById(String id) {
        return cities.get(id);
    }

    @Data
    private static class CitiesContent {
        private List<CityEntity> content;
    }
}

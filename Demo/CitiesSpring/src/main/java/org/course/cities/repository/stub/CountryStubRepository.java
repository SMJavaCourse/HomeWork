package org.course.cities.repository.stub;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.course.cities.entity.CountryEntity;
import org.course.cities.repository.CountryRepository;
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
public class CountryStubRepository implements CountryRepository {
    @Value("classpath:stub/countries.json")
    private Resource resource;
    private Map<String, CountryEntity> countries;
    private final ObjectMapper objectMapper;

    public CountryStubRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @PostConstruct
    void parseFile() {
        var content = objectMapper.readValue(resource.getFile(), CountriesContent.class);
        countries = content.getContent().stream()
                .collect(Collectors.toMap(CountryEntity::getId, Function.identity()));
    }

    @Override
    public CountryEntity getById(String id) {
        return countries.get(id);
    }

    @Data
    private static class CountriesContent {
        private List<CountryEntity> content;
    }
}

package org.course.cities.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.course.cities.repository.CountryRepository;
import org.course.cities.repository.RegionsRepository;
import org.course.cities.repository.jdbc.CitiesJdbcRepository;
import org.course.cities.repository.stub.CitiesStubRepository;
import org.course.cities.service.CitiesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfiguration {
    @Value("${cities.repo.stub}")
    private Boolean stubEnabled;

    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }
}

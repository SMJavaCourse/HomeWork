package org.course.cities.controller;

import org.course.cities.dto.City;
import org.course.cities.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CitiesController {
    private final CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> helloworld(@PathVariable String id) {
        return ResponseEntity.of(Optional.ofNullable(citiesService.getCity(id)));
    }
}

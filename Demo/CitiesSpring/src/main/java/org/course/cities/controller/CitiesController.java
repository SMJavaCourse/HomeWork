package org.course.cities.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {
    @GetMapping("/cities/{id}")
    public ResponseEntity<String> helloworld() {
        return ResponseEntity.ok("Hello world");
    }
}

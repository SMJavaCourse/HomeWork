package org.course.dto;

import lombok.Builder;
import lombok.Data;
import org.course.entity.Car;
import org.course.entity.Client;

import java.util.List;

@Data
@Builder
public class ClientWithCars {
    private Client client;
    private List<Car> cars;
}

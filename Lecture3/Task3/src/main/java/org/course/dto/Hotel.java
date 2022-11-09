package org.course.dto;

import lombok.Data;
import org.course.entity.ApartmentEntity;

import java.util.List;

@Data
public class Hotel {
    private String id;
    private String name;
    private List<ApartmentEntity> apartments; // или тут должны быть только простые типы?

}

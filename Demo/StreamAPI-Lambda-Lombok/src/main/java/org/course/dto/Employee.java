package org.course.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Position position;

    public int getId() {
        System.out.println(id);
        return id;
    }
}

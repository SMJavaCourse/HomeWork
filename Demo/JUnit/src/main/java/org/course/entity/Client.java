package org.course.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private String id;
    private String firstName;
    private String lastName;
}

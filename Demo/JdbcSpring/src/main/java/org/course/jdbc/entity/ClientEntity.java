package org.course.jdbc.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientEntity {
    private String id;
    private String firstName;
    private String lastName;
}

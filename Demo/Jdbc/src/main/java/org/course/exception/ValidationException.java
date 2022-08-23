package org.course.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationException extends RuntimeException {
    private String field;
    private ValidationCode code;
}

package org.course.hotels.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private int statusCode;
    private String message;

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
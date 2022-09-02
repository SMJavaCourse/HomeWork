package org.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hotel {
    private String id;
    private String name;
    private String startTime;

    @Override
    public String toString() throws NullPointerException {
        StringBuilder hotelToString = new StringBuilder()
                .append("Отель \"")
                .append(name)
                .append("\nВремя заселение/выселения: ")
                .append(startTime);
        return hotelToString.toString();
    }
}

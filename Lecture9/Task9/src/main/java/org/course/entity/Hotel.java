package org.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private String id;
    private String name;
    private String startTime;

    @Override
    public String toString() {
        StringBuilder hotelToString = new StringBuilder()
                .append("Отель \"")
                .append(name)
                .append("\nВремя заселение/выселения: ")
                .append(startTime);
        return hotelToString.toString();
    }
}

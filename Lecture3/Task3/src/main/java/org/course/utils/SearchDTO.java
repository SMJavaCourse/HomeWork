package org.course.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchDTO {
    String nameOfHotel;
    String command;
    String errorMessage;
    int numberOfGuests;
}

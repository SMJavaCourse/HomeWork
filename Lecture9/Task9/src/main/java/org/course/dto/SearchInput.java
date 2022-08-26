package org.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchInput {
    String nameOfHotel;
    String command;
    String errorMessage;
    int numberOfGuests;
}

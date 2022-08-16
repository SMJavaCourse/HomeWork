package org.course.utils;

import lombok.Getter;

@Getter
public class SearchDTO {
    String nameOfHotel;
    String command;
    String errorMessage;
    int numberOfGuests;

    public SearchDTO(String nameOfHotel, String command, int numberOfGuests, String errorMessage) {
        this.nameOfHotel = nameOfHotel;
        this.command = command;
        this.numberOfGuests = numberOfGuests;
        this.errorMessage = errorMessage;
    }
}

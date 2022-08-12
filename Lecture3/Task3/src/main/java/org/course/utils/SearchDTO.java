package org.course.utils;

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

    public String getNameOfHotel() {
        return nameOfHotel;
    }

    public String getCommand() {
        return command;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

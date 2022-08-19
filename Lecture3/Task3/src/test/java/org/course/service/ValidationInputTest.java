package org.course.service;

import org.course.dto.SearchInput;
import org.junit.jupiter.api.Test;

import static org.course.service.ValidationInput.validator;
import static org.junit.jupiter.api.Assertions.*;

class ValidationInputTest {
    String inputString;
    String nameOfHotel = null;
    String command = null;
    String errorMessage = null;
    int numberOfGuests = 0;

    @Test
    void emptyInput() {
        inputString = "";
        String actual = validator(inputString).getErrorMessage();
        String expected = "Пустая строка. Повторите ввод";
        assertEquals(actual,expected);
    }

    @Test
    void exitCommand() {
        inputString = "выход";
        String actual = validator(inputString).getCommand();
        String expected = "exit";
        assertEquals(actual,expected);
    }

    @Test
    void nonPositiveNumberOfGuests() {
        inputString = "-10";
        String actual = validator(inputString).getErrorMessage();
        String expected = "Количество гостей не может быть меньше 1, повторите ввод:";
        assertEquals(actual,expected);
    }

    @Test
    void zeroNumberOfGuests() {
        inputString = "0";
        String actual = validator(inputString).getErrorMessage();
        String expected = "Количество гостей не может быть меньше 1, повторите ввод:";
        assertEquals(actual,expected);
    }

    @Test
    void stringInsteadOfInt() {
        inputString = "string";
        String actual = validator(inputString).getErrorMessage();
        String expected = "Количество гостей это число, повторите ввод:";
        assertEquals(actual,expected);
    }

    @Test
    void unknownCommand() {
        inputString = "unknownCommand шашлычок";
        errorMessage = "Количество гостей это число, повторите ввод:";
        SearchInput actual = validator(inputString);
        SearchInput expected = new SearchInput(nameOfHotel, command, errorMessage, numberOfGuests);
        assertEquals(actual.getErrorMessage(),expected.getErrorMessage());
    }

    @Test
    void validInputWithCommand() {
        inputString = "удобства шашлычок";
        nameOfHotel = "шашлычок";
        command = "удобства";
        SearchInput actual = validator(inputString);
        SearchInput expected = new SearchInput(nameOfHotel, command, errorMessage, numberOfGuests);
        assertEquals(actual.getErrorMessage(),expected.getErrorMessage());
        assertEquals(actual.getCommand(),expected.getCommand());
        assertEquals(actual.getNameOfHotel(),expected.getNameOfHotel());
        assertEquals(actual.getNumberOfGuests(),expected.getNumberOfGuests());
    }

    @Test
    void validInputWithNumber() {
        inputString = "77 отель";
        nameOfHotel = "отель";
        numberOfGuests = 77;
        SearchInput actual = validator(inputString);
        SearchInput expected = new SearchInput(nameOfHotel, command, errorMessage, numberOfGuests);
        assertEquals(actual.getErrorMessage(),expected.getErrorMessage());
        assertEquals(actual.getCommand(),expected.getCommand());
        assertEquals(actual.getNameOfHotel(),expected.getNameOfHotel());
        assertEquals(actual.getNumberOfGuests(),expected.getNumberOfGuests());
    }

}
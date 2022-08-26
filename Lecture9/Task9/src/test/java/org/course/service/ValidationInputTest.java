package org.course.service;

import org.course.dto.SearchInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.course.service.ValidationInput.validator;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidationInputTest {
    String inputString;
    String nameOfHotel;
    String command;
    String errorMessage;
    int numberOfGuests;

    @Test
    void emptyInput() {
        inputString = "";
        String actual = validator(inputString).getErrorMessage();
        assertEquals("Пустая строка. Повторите ввод",actual);
    }

    @Test
    void exitCommand() {
        inputString = "выход";
        String actual = validator(inputString).getCommand();
        assertEquals("exit",actual);
    }

    @Test
    void nonPositiveNumberOfGuests() {
        inputString = "-10";
        errorMessage = "Количество гостей не может быть меньше 1, повторите ввод:";
        numberOfGuests = -10;
        SearchInput actual = validator(inputString);
        assertEquals(errorMessage,actual.getErrorMessage());
        assertEquals(numberOfGuests,actual.getNumberOfGuests());
    }

    @Test
    void zeroNumberOfGuests() {
        inputString = "0";
        errorMessage = "Количество гостей не может быть меньше 1, повторите ввод:";
        String actual = validator(inputString).getErrorMessage();
        assertEquals(errorMessage,actual);
    }

    @Test
    void stringInsteadOfInt() {
        inputString = "string";
        errorMessage = "Количество гостей это число, повторите ввод:";
        String actual = validator(inputString).getErrorMessage();
        assertEquals(errorMessage,actual);
    }

    @Test
    void unknownCommand() {
        inputString = "unknownCommand шашлычок";
        errorMessage = "Количество гостей это число, повторите ввод:";
        SearchInput actual = validator(inputString);
        assertEquals(errorMessage,actual.getErrorMessage());
    }

    @Test
    void validInputWithCommand() {
        inputString = "удобства шашлычок";
        nameOfHotel = "шашлычок";
        command = "удобства";
        SearchInput actual = validator(inputString);
        assertNull(actual.getErrorMessage());
        assertEquals(command,actual.getCommand());
        assertEquals(nameOfHotel,actual.getNameOfHotel());
        assertEquals(0,actual.getNumberOfGuests());
    }

    @Test
    void validInputWithNumber() {
        inputString = "77 отель";
        nameOfHotel = "отель";
        numberOfGuests = 77;
        SearchInput actual = validator(inputString);
        assertNull(actual.getErrorMessage());
        assertNull(actual.getCommand());
        assertEquals(nameOfHotel,actual.getNameOfHotel());
        assertEquals(numberOfGuests,actual.getNumberOfGuests());
    }

}
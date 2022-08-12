package org.course.utils;

import org.apache.commons.lang3.StringUtils;

public class ScannerCheck {

    public static SearchDTO validator(String inputString) {

        String nameOfHotel = null;
        String command = null;
        String errorMessage = null;
        int numberOfGuests = 0;
        int firstSpaceIndex = inputString.indexOf(" ");

        if (StringUtils.isBlank(inputString)) {
            errorMessage = "Пустая строка. Повторите ввод";
        } else if ("exit".equalsIgnoreCase(inputString) || "выход".equalsIgnoreCase(inputString)) {
            command = "exit";
        } else {
            if (firstSpaceIndex == -1) {
                if (isNumber(inputString)) {
                    numberOfGuests = Integer.parseInt(inputString);
                    if (numberOfGuests < 1) errorMessage = "Количество гостей не может быть меньше 1, повторите ввод:";
                } else errorMessage = "Количество гостей это число, повторите ввод:";
            } else {
                if (isNumber(inputString.substring(0, firstSpaceIndex))) {
                    numberOfGuests = Integer.parseInt(inputString.substring(0, firstSpaceIndex));
                    nameOfHotel = inputString.substring(firstSpaceIndex + 1);
                    if (numberOfGuests < 1) errorMessage = "Количество гостей не может быть меньше 1, повторите ввод:";
                } else errorMessage = "Количество гостей это число, повторите ввод:";
            }
        }
        return new SearchDTO(nameOfHotel,command,numberOfGuests,errorMessage);
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

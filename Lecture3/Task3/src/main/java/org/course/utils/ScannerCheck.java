package org.course.utils;//    public SearchDTO(String nameOfHotel, String command, int numberOfGuests, String errorMessage) {
//        this.nameOfHotel = nameOfHotel;
//        this.command = command;
//        this.numberOfGuests = numberOfGuests;
//        this.errorMessage = errorMessage;
//    }

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
                    if (numberOfGuests < 1) {
                        errorMessage = "Количество гостей не может быть меньше 1, повторите ввод:";
                    }
                } else {
                    errorMessage = "Количество гостей это число, повторите ввод:";
                }
            } else {
                if (isNumber(inputString.substring(0, firstSpaceIndex))) {
                    numberOfGuests = Integer.parseInt(inputString.substring(0, firstSpaceIndex));
                    if (numberOfGuests < 1) {
                        errorMessage = "Количество гостей не может быть меньше 1, повторите ввод:";
                    }
                } else {
                    for (CommandsEnum commandEnum : CommandsEnum.values()) {
                        if (commandEnum.getName().equalsIgnoreCase(inputString.substring(0, firstSpaceIndex).toLowerCase())) {
                            command = inputString.substring(0, firstSpaceIndex).toLowerCase();
                            break;
                        }
                    }
                    if (command == null){
                        errorMessage = "Количество гостей это число, повторите ввод:";
                    }
                }
                nameOfHotel = inputString.substring(firstSpaceIndex + 1).toLowerCase();
            }
        }
        return new SearchDTO(nameOfHotel, command, errorMessage, numberOfGuests);
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

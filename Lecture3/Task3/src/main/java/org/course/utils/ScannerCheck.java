package org.course.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class ScannerCheck {

    public static ArrayList validator(String inputString) {
        ArrayList commandLine = new ArrayList<>();
        if (StringUtils.isBlank(inputString)) {
            commandLine.add("Пустая строка. Повторите ввод");
        } else if ("exit".equalsIgnoreCase(inputString) || "выход".equalsIgnoreCase(inputString)) {
            commandLine.add("exit");
        } else {
            int firstSpaceIndex = inputString.indexOf(" ");
            if (firstSpaceIndex == -1) {
                if (isNumber(inputString)) {
                    if (Integer.parseInt(inputString) < 1) {
                        commandLine.add("Количество гостей не может быть меньше 1, повторите ввод:");
                    } else {
                        commandLine.add(Integer.parseInt(inputString));
                        commandLine.add(null);
                    }
                } else {
                    commandLine.add("Количество гостей это число, повторите ввод:");
                }
            } else {
                if (isNumber(inputString.substring(0, firstSpaceIndex))) {
                    if (Integer.parseInt(inputString.substring(0, firstSpaceIndex)) < 1) {
                        commandLine.add("Количество гостей не может быть меньше 1, повторите ввод:");
                    } else {
                        commandLine.add(inputString.substring(0, firstSpaceIndex));
                        commandLine.add(inputString.substring(firstSpaceIndex + 1));
                    }
                } else {
                    commandLine.add("Количество гостей это число, повторите ввод:");
                }
            }
        }
        return commandLine;
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

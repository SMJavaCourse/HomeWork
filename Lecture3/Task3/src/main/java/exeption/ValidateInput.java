package exeption;

import dto.Command;
import dto.MainData;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static dto.Command.*;

public class ValidateInput {

    public static MainData validateInput(String input) {
        String nameOfHotels;
        Command commandInput = null;
        String errorMessage = null;
        int numberOfGuests = 0;
        List<String> EXIT_COMMANDS = List.of(EXIT_EN.name, EXIT_RU.name);

        if (StringUtils.isBlank(input)) {
            errorMessage = "Пустая строка. Необходимо ввести данные для поиска";
            return MainData.errorMainData(errorMessage);
        } else if (EXIT_COMMANDS.contains(input.toLowerCase())) {
            return MainData.commandMainData(EXIT_EN);
        }

        List<String> inputAll = List.of(input.split(" "));


        if (inputAll.size() == 1) {
            return generateSingleParamMainData(input);
        } else {
            if (inputAll.get(0).equals(Command.FACILITIES.name)) {
                commandInput = FACILITIES;
            } else {
                return generateManyParamMainData(inputAll);
            }
        }
        nameOfHotels = getHotelName(inputAll);
        return new MainData(nameOfHotels, commandInput, errorMessage, numberOfGuests);
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String getHotelName(List<String> inputs) { //склеиваем имя отеля из введенных слов
        if (inputs.size() <= 1) {
            return null;
        }
        String hotelName = "";
        for (int i = 1; i < inputs.size(); i++) {
            hotelName = hotelName + " " + inputs.get(i);
        }
        return hotelName.trim();
    }

    private static MainData generateSingleParamMainData(String input) {
        int numberOfGuests;
        String errorMessage = "";
        if (isNumber(input)) {
            numberOfGuests = Integer.parseInt(input);
            if (numberOfGuests <= 0) {
                errorMessage = "Введенное количество гостей должно быть больше нуля!\nПовторите ввод:";
                return MainData.errorMainData(errorMessage);
            }
        } else {
            errorMessage = "Количество гостей это число!\nПовторите ввод:";
            return MainData.errorMainData(errorMessage);
        }
        return MainData.numberOfGuestsMainData(numberOfGuests);
    }

    private static MainData generateManyParamMainData(List<String> inputAll) {
        int numberOfGuests;
        String errorMessage = "";
        if (isNumber(inputAll.get(0))) {
            numberOfGuests = Integer.parseInt(inputAll.get(0));
            if (numberOfGuests <= 0) {
                errorMessage = "Введенное количество гостей должно быть больше нуля!\nПовторите ввод:";
                return MainData.errorMainData(errorMessage);
            }
        } else {
            errorMessage = "Количество гостей это число!\nПовторите ввод:";
            return MainData.errorMainData(errorMessage);
        }
        return MainData.numberOfGuestsMainData(numberOfGuests);
    }
}



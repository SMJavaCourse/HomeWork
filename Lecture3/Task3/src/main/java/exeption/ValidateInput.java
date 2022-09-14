package exeption;

import dto.Command;
import dto.MainData;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ValidateInput {

    public static MainData validateInput(String input) {
        String nameOfHotels = null;
        String commandInput = null;
        String errorMessage = null;
        int numberOfGuests = 0;
        List<String> inputAll = List.of(input.split(" "));
        int inputIndex = input.indexOf(" ");

        if (StringUtils.isBlank(input)) {
            errorMessage = "Пустая строка. Необходимо ввести данные для поиска";
        } else if ("exit".equalsIgnoreCase(input) || "выход".equalsIgnoreCase(input)) {
            commandInput = "выход";
        } else {
            if (inputIndex == -1) {
                if (isNumber(input)) {
                    numberOfGuests = Integer.parseInt(input);
                    if (numberOfGuests <= 0) {
                        errorMessage = "Введенное количество гостей должно быть больше нуля!\nПовторите ввод:";
                    }
                } else {
                    errorMessage = "Количество гостей это число!\nПовторите ввод:";
                }
            } else {
                if (inputAll.get(0).equals(Command.FACILITIES.name)) {
                    commandInput = inputAll.get(0);
                } else {
                    if (isNumber(inputAll.get(0))) {
                        numberOfGuests = Integer.parseInt(inputAll.get(0));
                        if (numberOfGuests <= 0) {
                            errorMessage = "Введенное количество гостей должно быть больше нуля!\nПовторите ввод:";
                        }
                    } else {
                            errorMessage = "Количество гостей это число!\nПовторите ввод:";
                        }
                    }
                }
                nameOfHotels = getHotelName(inputAll);
            }
        return new MainData(nameOfHotels, commandInput, errorMessage, numberOfGuests);
    }

        private static boolean isNumber (String input){
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private static String getHotelName (List < String > inputs) { //склеиваем имя отеля из введенных слов
            if (inputs.size() <= 1) {
                return null;
            }
            String hotelName = "";
            for (int i = 1; i < inputs.size(); i++) {
                hotelName = hotelName + " " + inputs.get(i);
            }
            return hotelName.trim();
        }
    }

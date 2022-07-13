package org.course;

import org.apache.commons.lang3.StringUtils;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String startTime;
    private static final String cantFindApartmentsString = "Подходящих номеров не найдено";

    public Hotel(String name, String startTime, Apartment[] apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    @Override
    public String toString() throws NullPointerException {
        StringBuilder text = new StringBuilder("Отель \"" + name + "\"\nКоличество номеров: " + apartments.length +
                "\nВремя заселение/выселения: " + startTime + "\nНомера:\n");
        for (Apartment apartment : apartments) {
            text.append(apartment.toString());
        }
        return text.toString();
    }

    public static String findHotels(Hotel[] hotels, String nameOfHotel, int numberOfGuests) {
        if (numberOfGuests == 0) {
            return "Количество гостей равно нулю, повторите ввод:";
        } else if (numberOfGuests < 0) {
            return "Количество гостей не может быть отрицательным, повторите ввод:";
        }
        String findHotel = "";
        String findApartment = "";
        int numberOfMatches = 0;
        for (int i = 0; i < hotels.length; i++) {
            if (StringUtils.equalsIgnoreCase(nameOfHotel, hotels[i].getName())) {
                findHotel += "Отель \"" + hotels[i].name + "\"\n";

                for (int j = 0; j < hotels[i].getApartments().length; j++) {
                    if (numberOfGuests <= hotels[i].getApartments()[j].getCapacity()) {
                        findApartment += hotels[i].getApartments()[j].toString();
                        numberOfMatches += 1;
                    }
                }
                if (numberOfMatches == 0) {
                    return "В отеле \"" + nameOfHotel + "\" " + cantFindApartmentsString.toLowerCase() + ". Повторите ввод:";
                } else
                    return findHotel + "Подходящих номеров: " + numberOfMatches + "\nНомера:\n" + findApartment + "\nСледующий поиск:";
            }
        }
        return "У нас нет информации по отелю \"" + nameOfHotel + "\", повторите ввод:";
    }
}

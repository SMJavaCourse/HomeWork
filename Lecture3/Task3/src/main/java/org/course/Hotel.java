package org.course;

import org.apache.commons.lang3.StringUtils;

public class Hotel {
    private String name;
    private Apartment[] apartments;
    private String startTime;

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
            return "Количество гостей равно нулю";
        } else if (numberOfGuests < 0) {
            return "Количество гостей не может быть отрицательным";
        }
        int numberOfMatches = 0;
        for (int i = 0; i < hotels.length; i++) {
            if (StringUtils.equalsIgnoreCase(nameOfHotel, hotels[i].getName())) {
                String findHotel = "Отель \"" + hotels[i].name + "\"\n";
                String findApartment = "";
                for (int j = 0; j < hotels[i].getApartments().length; j++) {
                    if (numberOfGuests <= hotels[i].getApartments()[j].getCapacity()) {
                        findApartment += hotels[i].getApartments()[j].toString();
                        numberOfMatches += 1;
                    }
                }
                if (numberOfMatches == 0) {
                    return "В отеле \"" + nameOfHotel + "\" подходящих номеров не найдено.";
                } else {
                    return findHotel + "Подходящих номеров: " + numberOfMatches + "\nНомера:\n" + findApartment;
                }
            }
        }
        return "У нас нет информации по отелю \"" + nameOfHotel + "\"";
    }
}

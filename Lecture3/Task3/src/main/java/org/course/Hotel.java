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

    @Override
    public String toString() {
        String text = "Отель \"" + name + "\"\nКоличество номеров: " + apartments.length +
                "\nВремя заселение/выселения: " + startTime + "\nНомера:\n";
        for (int i = 0; i < apartments.length; i++) {
            text += apartments[i].toString();
        }
        return text;
    }

    public static String findHotels(Hotel[] hotels, String nameOfHotel, int numberOfGuests) {
        String findHotel = "";
        for (int i = 0; i < hotels.length; i++) {
            if (StringUtils.equalsIgnoreCase(nameOfHotel, (CharSequence) hotels[i].getName())) {
                findHotel += "Отель \"" + hotels[i].name + "\"\n";
                if (hotels[i].findApartments(numberOfGuests).equals(cantFindApartmentsString)) {
                    return "В отеле \"" + nameOfHotel + "\" подходящих номеров не найдено";
                } else {
                    return findHotel + hotels[i].findApartments(numberOfGuests);
                }
            }
        }
        return "У нас нет информации по отелю \"" + nameOfHotel + "\"";
    }

    public String findApartments(int numberOfGuests) {
        String findApartment = "";
        int numberOfMatches = 0;
        for (int i = 0; i < apartments.length; i++) {
            if (numberOfGuests <= apartments[i].getCapacity()) {
                findApartment += apartments[i].toString();
                numberOfMatches += 1;
            }
        }
        if (numberOfMatches == 0) {
            return cantFindApartmentsString;
        } else return "Подходящих номеров: " + numberOfMatches + "\nНомера:\n" + findApartment;
    }

    public Object getName() {
        return name;
    }
}

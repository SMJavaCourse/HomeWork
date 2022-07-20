package org.course;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Apartment> apartments;
    private String startTime;

    public Hotel(String name, String startTime, ArrayList<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    @Override
    public String toString() throws NullPointerException {
        StringBuilder text = new StringBuilder("Отель \"" + name + "\"\nКоличество номеров: " + apartments.size() +
                "\nВремя заселение/выселения: " + startTime + "\nНомера:\n");
        for (Apartment apartment : apartments) {
            text.append(apartment.toString());
        }
        return text.toString();
    }

    public static String findHotel(ArrayList<Hotel> hotels, String nameOfHotel, int numberOfGuests) {
        int numberOfApartmentsFinded = 0;
        String findHotel = "";
        String findApartment = "";

        if (numberOfGuests == 0) {
            return "Количество гостей равно нулю";
        } else if (numberOfGuests < 0) {
            return "Количество гостей не может быть отрицательным";
        } else if (nameOfHotel == null) {
            int numberOfHotelsFinded = 0;
            for (int i = 0; i < hotels.size(); i++) {
                findHotel += "Отель \"" + hotels.get(i).name + "\"\n";
                for (int j = 0; j < hotels.get(i).getApartments().size(); j++) {
                    if (numberOfGuests <= hotels.get(i).getApartments().get(j).getCapacity()) {
                        findApartment += hotels.get(i).getApartments().get(j).toString();
                        numberOfApartmentsFinded += 1;
                    }
                }
                if (numberOfApartmentsFinded == 0) {
                    findHotel = "";
                } else {
                    numberOfHotelsFinded += 1;
                    findHotel += "Подходящих номеров: " + numberOfApartmentsFinded + "\nНомера:\n" + findApartment;
                }
            }
            return "Найдено отелей: " + numberOfHotelsFinded + "\n" + findHotel;
        }
        for (int i = 0; i < hotels.size(); i++) {
            if (StringUtils.equalsIgnoreCase(nameOfHotel, hotels.get(i).getName())) {
                findHotel += "Отель \"" + hotels.get(i).name + "\"\n";
                for (int j = 0; j < hotels.get(i).getApartments().size(); j++) {
                    if (numberOfGuests <= hotels.get(i).getApartments().get(j).getCapacity()) {
                        findApartment += hotels.get(i).getApartments().get(j).toString();
                        numberOfApartmentsFinded += 1;
                    }
                }
                if (numberOfApartmentsFinded == 0) {
                    return "В отеле \"" + nameOfHotel + "\" подходящих номеров не найдено.";
                } else {
                    return findHotel + "Подходящих номеров: " + numberOfApartmentsFinded + "\nНомера:\n" + findApartment;
                }
            }
        }
        return "У нас нет информации по отелю \"" + nameOfHotel + "\"";
    }


}

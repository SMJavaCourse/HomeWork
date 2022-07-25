package org.course;

import org.apache.commons.lang3.StringUtils;
import org.course.exception.BookingException;

import java.util.Collection;
import java.util.List;

public class Hotel {
    private String name;



    private List<Apartment> apartments;
    //private Collection<Apartment> apartments1;
    private final String checkInTime;


    public String getCheckInTime() {
        return checkInTime;
    }

    public Hotel(String name, List<Apartment> apartments, String checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
    }

    public String getName() {
        return name;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public void setName(String name) {
        this.name = name;
    }





    public static String findRooms(Hotel[] hotels, String hotelsName, int numberOfPeople) throws BookingException {
        String text = "";
        String visibleHotelsName = "";
        boolean roomIsFound = false;
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelsName)) {
                visibleHotelsName = hotel.getName();
                text += "Название отеля: \"" + visibleHotelsName + "\"" + System.lineSeparator()
                        + "Вам подходят номера: " + System.lineSeparator();
                for (Apartment apartment : hotel.getApartments()) {
                    if (numberOfPeople <= apartment.getNumberOfPeople()) {
                        text += apartment + System.lineSeparator();
                        roomIsFound = true;
                    }
                }
            }
        }
        if (StringUtils.isEmpty((text))) {
            throw new BookingException("Отель с таким названием не найден");
        } else if (!roomIsFound) {
            throw new BookingException("Номеров на выбранное количество человек в отеле \"" + visibleHotelsName + "\" не найдено" );
        }

        return text;

    }

    @Override
    public String toString() {
        String text = "Отель: " + this.getName() + System.lineSeparator() +
                "Время заселения: " + this.getCheckInTime() + System.lineSeparator() +
                "Количество номеров: " + apartments.length + System.lineSeparator() +
                "Номера: " + System.lineSeparator();
        for (Apartment apartment : apartments) {
            text += apartment.toString() + System.lineSeparator() +
                    " - Время заселение/выселения: " + this.getCheckInTime() + System.lineSeparator();
        }
        return text;
    }
}

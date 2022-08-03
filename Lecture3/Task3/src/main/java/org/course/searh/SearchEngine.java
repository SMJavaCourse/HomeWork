package org.course.searh;

import org.course.Hotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchEngine {
    private final String query;
    private final ArrayList<Hotel> hotels;
    private final String QUOTES = "\"|\"$";
    private String queryHotelName;
    private int queryCustomerNumber;
    private ArrayList<Hotel> hotelResult = new ArrayList<>();


    public SearchEngine(String query, ArrayList<Hotel> hotels) {
        this.query = query;
        this.hotels = hotels;
    }

    public String search() {
        if (query == null)
            return "Ошибка в запросе";
        String[] queryValues = query.trim().split(",");
        try {
            queryCustomerNumber = Integer.parseInt(queryValues[0].trim());
        } catch (NumberFormatException nfe) {
            return "Ошибка в запросе";
        }
        if (queryValues.length > 1)
            queryHotelName = queryValues[1].trim().replaceAll(QUOTES, "");
        return searchApartment();
    }

    private String searchApartment() {
        ArrayList<String> apartmentsByHotel = new ArrayList<>();
        String result = "";
        if (searchHotel() == null)
            hotelResult.addAll(hotels);
        else if (hotelResult.isEmpty())
            return "У нас нет информации по отелю \""  + queryHotelName + "\"";
        hotelResult.sort(Comparator.comparing(Hotel::getName));
        for (int i = 0; i < hotelResult.size(); i++) {
            for (int j = 0; j < hotelResult.get(i).getApartments().size(); j++) {
                if (queryCustomerNumber <= (hotelResult.get(i).getApartments().get(j).getCapacity())) {
                    apartmentsByHotel.add(hotelResult.get(i).getApartments().get(j).apartmentInfo());
                }
            }
            if (apartmentsByHotel.isEmpty()) {
                hotelResult.remove(i);
                i--;
            } else {
                result = result + ("\nОтель " + hotelResult.get(i).getName() + ": \nПодходящих номеров: " + apartmentsByHotel.size() + String.join("", apartmentsByHotel));
                apartmentsByHotel.clear();
            }
        }
        return "Найдено отелей: " + hotelResult.size() + result;
    }

    private ArrayList<Hotel> searchHotel() {
        if (queryHotelName == null)
            return null;
        for (int i = 0; i < hotels.size(); i++) {
            if (queryHotelName.equalsIgnoreCase(hotels.get(i).getName().replaceAll(QUOTES, ""))) {
                hotelResult.add(hotels.get(i));
            }
        }
        return hotelResult;
    }
}


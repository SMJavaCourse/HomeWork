package org.course.searh;

import org.course.Hotel;

public class SearchEngine {
    private String query;
    private Hotel[] hotels;
    private String hotelResult = null;
    private String[] apartmentsResult = null;
    private String[] apartmentResultFin = null;
    private String searchResult = null;


    public SearchEngine(String query, Hotel[] hotels) {
        this.query = query;
        this.hotels = hotels;
    }

    public String search() {
        int i = 0;
        boolean queryValue1Int = true;
        String[] queryValues = query.trim().replaceAll("^\"|\"$", "").split(",");
        if (queryValues.length == 2 && queryValues[1] != null) {
            try {
                Integer.parseInt(queryValues[1].trim());
            } catch (NumberFormatException nfe) {
                queryValue1Int = false;
            }
        }
        for (int j = 0; j < hotels.length; j++) {
            if (queryValues.length != 2 || queryValues[0] == null || queryValues[1] == null || !queryValue1Int) {
                searchResult = "Ошибка в запросе";
                break;
            } else if (queryValues[0].equalsIgnoreCase(hotels[j].getName().replaceAll("^\"|\"$", ""))) {
                apartmentsResult = new String[hotels[j].getApartments().length];
                hotelResult = hotels[j].getName();
                for (int k = 0; k < hotels[j].getApartments().length; k++) {
                    if (Integer.parseInt(queryValues[1].trim()) <= (hotels[j].getApartments()[k].getCapacity())) {
                        i++;
                        apartmentsResult[k] = hotels[j].getApartments()[k].apartmentInfo();
                    }
                }
                apartmentResultFin = new String[i];
                int m = 0;
                for (int l = 0; l < apartmentsResult.length; l++) {
                    if (apartmentsResult[l] != null) {
                        apartmentResultFin[m] = apartmentsResult[l];
                        m++;
                    }
                }
            }
        }
        if (searchResult == null) {
            if (hotelResult == null || apartmentResultFin.length < 1) {
                searchResult = "Совпадений не найдено";
            } else {
                searchResult = "Отель " + hotelResult + ":" + String.join("", apartmentResultFin);
            }
        }
        return searchResult;
    }
}

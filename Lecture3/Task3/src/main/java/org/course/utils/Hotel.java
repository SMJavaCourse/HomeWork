package org.course.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.course.services.Services;
import org.course.utils.Apartment;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Hotel {
    private String name;
    private ArrayList<Apartment> apartments;
    private String startTime;

    public Hotel(String name, String startTime, ArrayList<Apartment> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;

        var mostExpensiveApartment = apartments
                .stream()
                .max(Comparator.comparing(Apartment::getPrice))
                .get();
        mostExpensiveApartment.setName(mostExpensiveApartment.getName() + " LUXURY");
    }

    @Override
    public String toString() throws NullPointerException {
        StringBuilder hotelToString = new StringBuilder()
                .append("Отель \"")
                .append(name)
                .append("\"\nКоличество номеров: ")
                .append(apartments.size())
                .append("\nВремя заселение/выселения: ")
                .append(startTime)
                .append("\nНомера:\n");
        for (Apartment apartment : apartments) {
            hotelToString.append(apartment.toString());
        }
        return hotelToString.toString();
    }

    public String toStringTemp() throws NullPointerException {

        StringBuilder hotelToString = new StringBuilder()
                .append("Отель \"")
                .append(name)
                .append("\"\nКоличество номеров: ")
                .append(apartments.size())
                .append("\nВремя заселение/выселения: ")
                .append(startTime)
                .append("\nНомера:\n")
                .append(apartments
                        .stream()
                        .map(Apartment::toString)
                        .collect(Collectors.joining("")));

        return hotelToString.toString();
    }

    public static ArrayList<Apartment> findApartment(ArrayList<Apartment> apartments, int numberOfGuests) {
        ArrayList<Apartment> findApartmentsResult = new ArrayList<>();
        for (Apartment apartment : apartments) {
            if (numberOfGuests <= apartment.getCapacity()) {
                findApartmentsResult.add(apartment);
            }
        }
        return findApartmentsResult;
    }

    public static String printServices(ArrayList<Apartment> apartments) {
        HashMap<String, ArrayList<Apartment>> servicesMap = new HashMap<>();

        for (Apartment apartment : apartments) {
            for (Services service : apartment.getServices()) {
                ArrayList<Apartment> apartmentList = servicesMap.get(service.getName());
                if (apartmentList == null) {
                    apartmentList = new ArrayList<>();
                    servicesMap.put(service.getName(), apartmentList);
                }
                apartmentList.add(apartment);
            }
        }

        StringBuilder stringServices = new StringBuilder("Количество доступных удобств: " + servicesMap.size() + "\n");
        for (String key : servicesMap.keySet()) {
            ArrayList<Apartment> value = servicesMap.get(key);
            stringServices
                    .append("Удобство \"")
                    .append(key)
                    .append("\" доступно в номерах:\n\n");
            for (Apartment apartment : value) {
                stringServices
                        .append("\t\u2219")
                        .append(apartment.getName())
                        .append(" (комната номер ")
                        .append(apartment.getNumberOfRoom())
                        .append(")\n");
            }
        }
        return stringServices.toString();
    }
}

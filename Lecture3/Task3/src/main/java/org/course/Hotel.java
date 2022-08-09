package org.course;

import org.course.services.Services;

import java.util.*;

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
        String stringServices;

        for (Apartment apartment:apartments) {
            for (Services service:apartment.getServices()){
                ArrayList<Apartment> apartmentList = servicesMap.get(service.getName());
                if (apartmentList == null) {
                    apartmentList = new ArrayList<>();
                    servicesMap.put(service.getName(),apartmentList);
                }
                apartmentList.add(apartment);
            }
        }
        stringServices = "Количество доступных удобств: " + servicesMap.size() + "\n";
        List<String> keys = new ArrayList<>(servicesMap.keySet());
        for (String key : keys) {
            ArrayList<Apartment> value = servicesMap.get(key);
            stringServices += "Удобство \"" + key + "\" доступно в номерах:\n\n";
            for (Apartment apartment : value) {
                stringServices += "\t\u2219" + apartment.getName(apartment.getRooms()) + " (комната номер " + apartment.getNumberOfRoom() + ")\n";
            }
            stringServices += "\nПовторите ввод:";
        }
        return stringServices;
    }
}

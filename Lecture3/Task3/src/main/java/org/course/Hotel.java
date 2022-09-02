package org.course;

import lombok.Getter;

import java.util.*;

@Getter
public class Hotel {
    private final String name;
    private final List<Apartament> apartments;
    Map<Integer, List<Apartament>> apartmentByCapacity = new HashMap<>();
    private final String startTime;

    public Hotel(String name, String startTime, List<Apartament> apartments) {
        this.name = name;
        this.apartments = apartments;
        this.startTime = startTime;

        var apartLuxury = apartments
                .stream()
                .max(Comparator.comparing(Apartament::getPrice))
                .get();
        apartLuxury.setName(apartLuxury.getName() + " LUXURY");

        for (Apartament apartment : this.getApartments()) { //создаем мапу, где ключ - capacity, а value - апартаменты
            List<Apartament> apartsByCapacity = apartmentByCapacity.get(apartment.getCapacity());
            if (apartsByCapacity == null) {
                apartsByCapacity = new ArrayList<>();
                apartsByCapacity.add(apartment);
                apartmentByCapacity.put(apartment.getCapacity(), apartsByCapacity);
            } else {
                apartsByCapacity.add(apartment);
            }
        }
    }

    public static ArrayList<Apartament> searchRoom(int people, Map<Integer, List<Apartament>> apartsByCapacity) {
        if (people >= 0) {
            ArrayList<Apartament> roomList = new ArrayList<>();
            for (Map.Entry<Integer, List<Apartament>> entry : apartsByCapacity.entrySet()) {
                int apartCapacity = entry.getKey();
                if (people <= apartCapacity) {
                    List<Apartament> aparts = entry.getValue();
                    roomList.addAll(aparts);
                }
            }
            return roomList;
        }
        return null;
    }
}

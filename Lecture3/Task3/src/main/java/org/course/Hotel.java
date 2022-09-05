package org.course;

import lombok.Getter;
import services.Services;

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
            List<Apartament> apartsByCapacity = apartmentByCapacity.get(apartment.getCapacity()); //создаем лист с апартаментами по capacity
            if (apartsByCapacity == null) { //если лист пустой (такого capacity нет)
                apartsByCapacity = new ArrayList<>(); // то создаем новый лист
                apartsByCapacity.add(apartment); //добавляем туда найденный апартамент
                apartmentByCapacity.put(apartment.getCapacity(), apartsByCapacity); //добавляем в нашу мапу ключ - capacity и лист с апартаментом
            } else { //если лист не пустой (такой capacity уже есть)
                apartsByCapacity.add(apartment); //добавляем апартамент в лист с апартаментам по найденному ключу - capacity
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

    public static String searchServices(List<Apartament> apartments) {
        HashMap<String, List<Apartament>> mapOfServices = new HashMap<>(); //создаем мапу, где ключ - имя сервиса, а value - апартамент
        for (Apartament apartServices : apartments) { //проходимся по всем апартаментам
            for (Services services : apartServices.getServices()) { //проходимся по всем сервисам апартаментов
                List<Apartament> listApart = mapOfServices.get(services.getName()); //создаем лист апартов по конкретному сервису
                if (listApart == null) { //если лист пустой (такого сервиса нет)
                    listApart = new ArrayList<>(); // то создаем новый лист с апартами
                    listApart.add(apartServices);
                    mapOfServices.put(services.getName(), listApart); //добавляем в нашу мапу ключ - capacity и лист с апартаментом
                } else { //если лист не пустой (такой capacity уже есть)
                    listApart.add(apartServices); //добавляем апартамент в лист с апартаментам по найденному ключу - capacity
                }
            }
        }
        StringBuilder printServiceSearch = new StringBuilder("Количество доступных удобств: " + mapOfServices.keySet().size());
        for (String serviceKey : mapOfServices.keySet()) {
            List<Apartament> apartByServiceName = mapOfServices.get(serviceKey);
            printServiceSearch
                    .append("\n\nУдобство \"")
                    .append(serviceKey)
                    .append("\" доступно в номерах:");
            for (Apartament apart : apartByServiceName) {
                printServiceSearch
                        .append(" \n\t\t\u25e6")
                        .append(apart.getName())
                        .append(" (комната номер ")
                        .append(apart.getNumberOfApart())
                        .append(")");
            }

        }
        return printServiceSearch.toString();
    }
}
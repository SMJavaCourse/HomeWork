package org.course;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Hotel implements Hotels{
    private String name;
    private LocalTime checkInTime;
    private List<Apartment> apartments;
    private Integer roomsTotalCount;

    @Builder
    public Hotel(String name, List<Apartment> apartments, LocalTime checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
        try {
            if(apartments == null) {
                throw new HotelException("No apartments");
            }
            this.roomsTotalCount = apartments.size();
            apartments.forEach(a -> a.setCheckinTime(checkInTime));

        } catch (HotelException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Отель \"" + this.name + "\":\n" +
                "Количество номеров: " + this.roomsTotalCount + "\n" +
                "Номера: ";
    }

    public static List<Apartment> getApartmentsByParam(List<Hotel> hotels, String hotelName, int places) {
        try {
            if (hotels.size() != 0 && hotels.stream().anyMatch(h -> h != null)) {
                var listHotels = hotels.stream().filter(h -> h.getName().toLowerCase().equals(hotelName.toLowerCase()))
                        .collect(Collectors.toList());
                if (listHotels.size() == 1) {
                    var list = listHotels.get(0).getApartments()
                            .stream()
                            .filter(apartment -> apartment.getPlaces() == places)
                            .collect(Collectors.toList());
                    if (list.size() == 0) {
                        throw new ApartmentException("No apartments with specified parameters found (places: " + places + ")");
                    }
                    return list;
                } else {
                    throw new HotelException("No such hotel name \"" + hotelName + "\"");
                }
            } else {
                throw new HotelException("No hotels exists.");
            }
        } catch (ApartmentException e) {
            System.out.println(e.getContext() + ": " + e.getMessage());
        } catch (HotelException e) {
            System.out.println(e.getContext() + ": " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return List.of(new Apartment[0]);
    }
    public static Long getCountHotelsByParam(List<Hotel> hotels, int places) {
        var count = hotels.stream()
                .map(hotel -> hotel.getApartments()
                        .stream().filter(a -> a.getPlaces().equals(places))).count();
        return count;
    }
    public static List<Apartment> getApartmentsByParam(List<Hotel> hotels, int places) {
        List<Apartment> list = new ArrayList<>();
        hotels.forEach(h -> list.add(h.getApartments()
                .stream()
                .filter(a -> a.getPlaces().equals(places))
                .findAny().orElse(new ApartmentOneRoom()))
                //TODO: херня. переделать.
                //находит первый номер в отеле, остальных в списке не будет
        );
        return list;
    }

//    public static List<List<Apartment>> getApartmentsByParam(List<Hotel> hotels, int places) {
//
//        var list =  hotels.stream()
//                .map(hotel -> hotel.getApartments()
//                        .stream().filter(a -> a.getPlaces().equals(places))
//                        .toList()).collect(Collectors.toList());
//        return list;
//    }
    public static List<HashMap<String, List<Apartment>>> getApartmentsByParam2(List<Hotel> hotels, int places) {
        // returns list of maps: <hotelName, List<Apartment>>
        List<HashMap<String, List<Apartment>>> listHotelApartments = new ArrayList<>();

        hotels.stream().forEach(hotel -> {

        });
        return listHotelApartments;
    }

    public static void printAvailableApartmentByParams(List<Hotel> hotels, String hotelName, Integer places) {
        var listApartments = getApartmentsByParam(hotels, hotelName, places);
        if (listApartments.size() != 0) {
            System.out.println("Подходящих номеров: " + listApartments.size() + "\nНомера: ");
            listApartments.forEach(System.out::println);
            System.out.println("\n");
        }
    }

    public static void printAvailableApartmentByParams(List<Hotel> hotels, Integer places) {
        var listApartments = getApartmentsByParam(hotels, places);
        if (listApartments.size() != 0) {
            var countHotels = getCountHotelsByParam(hotels, places);
            System.out.println("Найдено отелей: " + countHotels);
            System.out.println("Подходящих номеров: " + listApartments.size() + "\nНомера: ");
            listApartments.forEach(System.out::println);
            System.out.println("\n");
        }
    }

}

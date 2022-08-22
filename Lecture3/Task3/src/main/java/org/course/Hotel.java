package org.course;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Getter
public class Hotel implements Hotels{
    private String name;
    private LocalTime checkInTime;
    private List<Apartment> apartments;
    private Integer roomsTotalCount;

//    private Map<String, Hotel> hotelIdMap = new HashMap<>();

//    public List<Hotel> getHotels() {
//        return Hotel.hotels;
//    }
//    public void setHotels(Hotel hotel) {
//        this.getHotels().add(hotel);
//    }

//    public Hotel findHotel(String hotelName) {
//        Hotel hotelResult = hotelIdMap.get(hotelName.toLowerCase());
//        if (hotelResult != null) {
//            return hotelResult;
//        }
//        throw new NoSuchElementException("Couldn't find hotel with name " + hotelName);
//    }

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
        return "Отель \"" + this.name + "\""  + ":\n" +
                "Количество номеров: " + this.roomsTotalCount + "\n" +
                "Номера: ";
    }

    public static Map<String, List<Apartment>> getApartmentsByParam(HotelsRepo hotelsRepo, String hotelName, int places) {
        Map<String, List<Apartment>> map = new TreeMap<>();
        List<Hotel> hotels = hotelsRepo.getHotels();
        try {
            if (hotels.size() != 0 && hotels.stream().anyMatch(h -> h != null)) {
                Hotel result = hotelsRepo.getHotel(hotelName);

//                var listHotels = hotels.stream().filter(h -> h.getName().toLowerCase().equals(hotelName.toLowerCase()))
//                        .collect(Collectors.toList());
//                var listHotels = hotels.stream().filter(h -> h.getHotelIdMap().get(hotelName.toLowerCase())
//                                .equals(hotelName.toLowerCase()))
//                        .collect(Collectors.toList());

                if (result != null) {
                    var list = result.getApartments()
                            .stream()
                            .filter(apartment -> apartment.getPlaces() == places)
                            .collect(Collectors.toList());
                    map.put(hotelName, list);
                    if (list.size() == 0) {
                        throw new ApartmentException("No apartments with specified parameters found (places: " + places + ")");
                    }
                    return map;
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
        return Map.of();
    }
    public static Long getCountHotelsByParam(List<Hotel> hotels, int places) {
        Long count = 0L;
        for (Hotel h : hotels) {
            if(h.getApartments().stream().filter(a -> a.getPlaces().equals(places)).count() > 0) {
                count+=1;
            }
        }
        return count;
    }
    public static Long getCountHotelsByParam(List<Hotel> hotels, String hotelName, int places) {
        var count = hotels.stream().filter(hotel -> hotel.getName().equals(hotelName)).map(hotel -> hotel.getApartments()
                .stream().filter(a -> a.getPlaces().equals(places))).count();

        return count;
    }

    public static Map<String, List<Apartment>> getApartmentsByParam(HotelsRepo hotelsRepo, int places) {
        Map<String, List<Apartment>> map = new TreeMap<>();
        for (Hotel hotel : hotelsRepo.getHotels()) {
            List<Apartment> list = new ArrayList<>();
            var apartments = hotel.getApartments();
            for (Apartment apartment : apartments) {
                if(apartment.getPlaces().equals(places)) {
                    list.add(apartment);
                    map.put(hotel.getName(), list);
                }
            }
        }
        return map;
    }

    public static void printAvailableApartmentByParams(HotelsRepo hotelsRepo, String hotelName, Integer places) {
        var mapHotelApartments = getApartmentsByParam(hotelsRepo, hotelName, places);
        if (!mapHotelApartments.isEmpty()) {
            var countHotels = hotelsRepo.getHotel(hotelName) != null ? 1 : null;
            System.out.println("Найдено отелей: " + countHotels);
            mapHotelApartments.forEach((hotel, apartments) ->
                    System.out.println("В отеле \"" + hotel + "\" " +
                            "количество подходящих номеров " + apartments.size() + "\n" +
                            "Описание номеров: \n" + apartments));
            System.out.println("\n");
        }
    }


    public static void printAvailableApartmentByParams(HotelsRepo hotelsRepo, Integer places) {
        var mapHotelApartments = getApartmentsByParam(hotelsRepo, places);
        if (!mapHotelApartments.isEmpty()) {
            var countHotels = getCountHotelsByParam(hotelsRepo.getHotels(), places);
            System.out.println("Найдено отелей (по заданным условиям): " + countHotels);
            mapHotelApartments.forEach((hotel, apartments) ->
                    System.out.println("В отеле \"" + hotel + "\" " +
                            "количество подходящих номеров " + apartments.size() + "\n" +
                            "Описание номеров: \n" + apartments));
            System.out.println("\n");
        }
    }

}

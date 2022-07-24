package org.course;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


public class Hotel implements Hotels{
    private String name;
    private LocalTime checkInTime;
    private List<Apartment> apartments;
    private int roomsTotalCount;

    public String getName() {
        return name;
    }

    public Hotel(String name, List<Apartment> apartments, LocalTime checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
        try {
            if(apartments == null) {
                throw new HotelException("No apartments");
            }
            this.roomsTotalCount = getRoomsTotalCount() + apartments.size();
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

    public List<Apartment> getAllApartments() {
        return apartments;
    }
    public int getRoomsTotalCount() {
        return roomsTotalCount;
    }

    public static List<Apartment> getAvailableApartmentByHotelName(List<Hotel> hotels, String hotelName, int places) {
        try {
            if (hotels.size() != 0 && hotels.stream().anyMatch(h -> h != null)) {
                var listHotels = hotels.stream().filter(h -> h.getName().toLowerCase().equals(hotelName.toLowerCase()))
                        .collect(Collectors.toList());
                if (listHotels.size() == 1) {
                    var list = listHotels.get(0).getAllApartments()
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

    public static void printAvailableApartmentByHotelName(List<Hotel> hotels, String apartmentName, int places) {
        var listApartments = getAvailableApartmentByHotelName(hotels, apartmentName, places);
        if (listApartments.size() != 0) {
            System.out.println("Подходящих номеров: " + listApartments.size() + "\nНомера: ");
            listApartments.forEach(System.out::println);
            System.out.println("\n");
        }
    }

}

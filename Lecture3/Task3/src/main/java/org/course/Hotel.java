package main.java.org.course;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Hotel implements Hotels{
    private String name;
    private LocalTime checkInTime;
    private Apartment[] apartments;
    private int roomsTotalCount;

    public String getName() {
        return name;
    }

    public Hotel(String name, Apartment[] apartments, LocalTime checkInTime) {
        this.name = name;
        this.apartments = apartments;
        this.checkInTime = checkInTime;
        this.roomsTotalCount = getRoomsTotalCount() + apartments.length;

        for (int i = 0; i < apartments.length; i++) {
            apartments[i].setCheckinTime(checkInTime);
        }

    }

    @Override
    public String toString() {
        return "Отель \"" + this.name + "\":\n" +
                "Количество номеров: " + this.roomsTotalCount + "\n" +
                "Номера: ";
    }

    public Apartment[] getAllApartments() {
        return apartments;
    }
    public int getRoomsTotalCount() {
        return roomsTotalCount;
    }

    private static List<Apartment> getAvailableApartmentByHotelName(Hotel[] hotels, String hotelName, int places) throws ApartmentException {
        try {
            if (hotels.length != 0 && Arrays.stream(hotels).anyMatch(h -> h != null)) {
                var listHotels = Arrays.stream(hotels).filter(h -> h.getName().equals(hotelName)).collect(Collectors.toList());
                if (listHotels.size() == 1) {
                    var list = Arrays.stream(listHotels.get(0).getAllApartments())
                            .filter(apartment -> apartment.getPlaces() == places)
                            .collect(Collectors.toList());
                    if (list.size() == 0) {
                        throw new ApartmentException("[ApartmentException]", 404, "No apartments with specified parameters found.");
                    }
                    return list;
                } else {
                    throw new HotelException("[HotelException]", 404, "No such hotel name.");
                }
            } else {
                throw new HotelException("[HotelException]", 404, "No hotels exists.");
            }
        } catch (ApartmentException e) {
            System.out.println(e.getContext() + ": " + e.getMessage());
        } catch (HotelException e) {
            System.out.println(e.getContext() + ": " + e.getMessage());
        }
        return List.of(new Apartment[0]);
    }

    public static void printAvailableApartmentByName(Hotel[] hotels, String apartmentName, int places) throws ApartmentException {
        var listApartments = getAvailableApartmentByHotelName(hotels, apartmentName, places);
        if (listApartments.size() != 0) {
            System.out.println("Подходящих номеров: " + listApartments.size() + "\nНомера: ");
            listApartments.forEach(System.out::println);
        }
    }

}

package org.course.service;

import lombok.SneakyThrows;
import org.course.GlobalStorage;
import org.course.dto.Hotel;
import org.course.repository.ApartmentParamsRepo;
import org.course.repository.ApartmentsRepo;
import org.course.repository.HotelsRepo;
import org.course.repository.ServicesRepo;

import javax.sql.DataSource;

public class HotelService {

//    private static final HotelsRepo HOTEL_REPOSITORY = HotelsRepo.getInstance();
    private final GlobalStorage globalStorage;
    private final HotelsRepo hotelsRepo;
    private final ApartmentsRepo apartmentsRepo;
    private final ApartmentParamsRepo apartmentParamsRepo;
    private final ServicesRepo servicesRepo;

    public HotelService(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
        hotelsRepo = globalStorage.getHotelsRepo();
        apartmentsRepo = globalStorage.getApartmentsRepo();
        apartmentParamsRepo = globalStorage.getApartmentParamsRepo();
        servicesRepo = globalStorage.getServicesRepo();
    }

    @SneakyThrows
    public Hotel getHotel(String id) {
        var hotelEntity = hotelsRepo.getById(id);
        if (hotelEntity == null) {
            return null;
        }
        var apartmentEntityList = apartmentsRepo.getByHotelId(hotelEntity.getId());
//        var apartmentParamsEntity = apartmentParamsRepo.getById();
//        var serviceEntity = servicesRepo.getById(apartmentParamsEntity.getServicesId());

        var hotel = new Hotel();
        hotel.setId(hotelEntity.getId());
        hotel.setName(hotelEntity.getName());
        hotel.setApartments(apartmentEntityList);

        return hotel;

//        var hotel = HOTEL_REPOSITORY.byId(id.toLowerCase(Locale.ROOT));
//        if (hotel == null) {
//            throw new HotelException("No such hotel with id=" + id);
//        }
//        return hotel;
    }

//    public Hotel saveHotel(Hotel hotel) {
//        return HOTEL_REPOSITORY.save(hotel);
//    }

//    public Integer removeHotels() {
//        return HOTEL_REPOSITORY.dropAll().size();
//    }

//    public List<Hotel> getAllHotels() throws HotelException {
//        if (HOTEL_REPOSITORY.all().size() == 0) {
//            throw new HotelException("There is no one hotel found");
//        }
//        System.out.println("Hotel list: \n");
//        return HOTEL_REPOSITORY.all();
//    }

//    public List<Hotel> generateHotels() {
//        HOTEL_REPOSITORY.generateHotels();
//        return HOTEL_REPOSITORY.all();
//    }

//    public List<Hotel> generateMoreHotels() {
//        HOTEL_REPOSITORY.generateMoreHotels();
//        return HOTEL_REPOSITORY.all();
//    }

//    public Map<String, List<Apartment>> getApartmentsByParam(String hotelName, int places) {
//        Map<String, List<Apartment>> map = new TreeMap<>();
//        List<Hotel> hotels = HOTEL_REPOSITORY.all();
//        try {
//            if (hotels.size() != 0 && hotels.stream().anyMatch(h -> h != null)) {
//                Hotel result = HOTEL_REPOSITORY.byId(hotelName); // new HotelException("No such hotel name \"" + hotelName + "\"")
//                if (result != null) {
//                    var list = result.getApartments()
//                            .stream()
//                            .filter(apartment -> apartment.getPlaces() == places)
//                            .collect(Collectors.toList());
//                    map.put(hotelName, list);
//                    if (list.size() == 0) {
//                        throw new ApartmentException("No apartments with specified parameters found (places: " + places + ")");
//                    }
//                    return map;
//                } else {
//                    throw new HotelException("No such hotel name \"" + hotelName + "\"");
//                }
//            } else {
//                throw new HotelException("No hotels exists.");
//            }
//        } catch (ApartmentException e) {
//            System.out.println(e.getContext() + ": " + e.getMessage());
//        } catch (HotelException e) {
//            System.out.println(e.getContext() + ": " + e.getMessage());
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage());
//        }
//        return Map.of();
//    }

//    public Map<String, List<Apartment>> getApartmentsByParam(int places) {
//        Map<String, List<Apartment>> map = new TreeMap<>();
//        var hotels = HOTEL_REPOSITORY.all();
//        for (Hotel hotel : hotels) {
//            List<Apartment> list = new ArrayList<>();
//            var apartments = hotel.getApartments();
//            for (Apartment apartment : apartments) {
//                if(apartment.getPlaces().equals(places)) {
//                    list.add(apartment);
//                    map.put(hotel.getName(), list);
//                }
//            }
//        }
//        return map;
//    }

//    public void printAvailableApartmentByParams(String hotelName, Integer places) {
//        var mapHotelApartments = getApartmentsByParam(hotelName, places);
//        if (!mapHotelApartments.isEmpty()) {
//            var countHotels = HOTEL_REPOSITORY.byId(hotelName) != null ? 1 : null;
//            System.out.println("Найдено отелей: " + countHotels);
//            mapHotelApartments.forEach((hotel, apartments) ->
//                    System.out.println("В отеле \"" + hotel + "\" " +
//                            "количество подходящих номеров " + apartments.size() + "\n" +
//                            "Описание номеров: \n" + apartments));
//            System.out.println("\n");
//        }
//    }


//    public void printAvailableApartmentByParams(Integer places) {
//        var mapHotelApartments = getApartmentsByParam(places);
//        if (!mapHotelApartments.isEmpty()) {
//            var countHotels = getCountHotelsByParam(HOTEL_REPOSITORY.all(), places);
//            System.out.println("Найдено отелей (по заданным условиям): " + countHotels);
//            mapHotelApartments.forEach((hotel, apartments) ->
//                    System.out.println("В отеле \"" + hotel + "\" " +
//                            "количество подходящих номеров " + apartments.size() + "\n" +
//                            "Описание номеров: \n" + apartments));
//            System.out.println("\n");
//        }
//    }

//    public Long getCountHotelsByParam(List<Hotel> hotels, int places) {
//        Long count = 0L;
//        for (Hotel h : hotels) {
//            if(h.getApartments().stream().filter(a -> a.getPlaces().equals(places)).count() > 0) {
//                count+=1;
//            }
//        }
//        return count;
//    }
}

package org.course.dao;

import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.course.ApartmentOneRoom;
import org.course.Hotel;
import org.course.HotelException;
import org.course.HotelFactory;
import org.course.ServicesImpl;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HotelRepository extends Repository<Hotel, String>{
    private static final Map<String, Hotel> hotelByName = new HashMap<>();
    private static volatile HotelRepository instance;

    public static HotelRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (HotelRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new HotelRepository();
                }
            }
        }
        return localInstance;
    }

    private HotelRepository() {}

    @Override
    public List<Hotel> all() {
        return hotelByName.values().stream().sorted().toList();
    }

    @SneakyThrows
    public Hotel save(Hotel hotel) {
        if (StringUtils.isBlank(hotel.getName())) {
            throw new HotelException("Hotel name cannot be blank");
        }
        hotelByName.put(hotel.getName().toLowerCase(), hotel);
        return hotel;
    }

    public List<Hotel> save(List<Hotel> hotelsList) {
        var hotels = all();
        hotels.addAll(hotelsList);
        Map<String, Hotel> newMap = hotelsList.stream()
                .collect(Collectors.toMap(name -> name.getName().toLowerCase(), Function.identity()));
        hotelByName.putAll(newMap);

        return hotels;
    }

    @Override
    @SneakyThrows
    public Hotel byId(String id) { // id == hotelName in lowercase
        if (hotelByName.get(id.toLowerCase()) == null) {
            throw new HotelException("No such hotel name \"" + id + "\"");
        }
        return hotelByName.get(id.toLowerCase());
    }
//    public Optional<Hotel> getHotelByName(String id) {
//        return Optional.ofNullable(hotelByName.get(id.toLowerCase()));
//    }

    public List<Hotel> find(List<String> hotelNames) {
        var streamHotels = hotelByName.values().stream();
        if (CollectionUtils.isNotEmpty(hotelNames)) {
            streamHotels = streamHotels.filter(h -> hotelNames.contains(h.getName()));
        }
        return streamHotels.sorted().toList();
    }


    public void generateHotels() {
        save(HotelFactory.createHotel("У мамы лучше"));
        save(HotelFactory.createHotel("Шашлычок"));
        save(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(100000f, 1, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        save(Hotel.builder()
                .name("Бельбедер")
                .apartments(List.of(new ApartmentOneRoom(140000f, 4, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
    }

    public void generateMoreHotels() {
        /**
         * for test method duration
         */
        save(HotelFactory.createHotel("Шашлычок"));
        save(HotelFactory.createHotel("У мамы лучше"));
        save(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(100000f, 1, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        save(Hotel.builder()
                .name("Астория")
                .apartments(List.of(new ApartmentOneRoom(140000f, 4, 1)
                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
                .checkInTime(LocalTime.of(12, 0))
                .build());
        for (int i = 0; i < 1000000; i++) {
            save(Hotel.builder()
                    .name("hotelName" + i)
                    .apartments(List.of(new ApartmentOneRoom(1000f, 7, 13)
                            .setServices(new ServicesImpl().addBalcony().addCleaning())))
                    .checkInTime(LocalTime.of(12, 0))
                    .build());
        }
    }

}

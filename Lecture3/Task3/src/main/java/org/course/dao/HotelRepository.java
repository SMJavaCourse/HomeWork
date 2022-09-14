package org.course.dao;

import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.course.Apartment;
import org.course.ApartmentOneRoom;
import org.course.Hotel;
import org.course.HotelException;
import org.course.HotelFactory;
import org.course.ServicesImpl;
import org.course.utils.DbConnect;
import org.course.utils.DbUtils;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
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
        List<Hotel> hotelList = new ArrayList<>();
        List<Apartment> apartmentList = new ArrayList<>();
        try (var connection = DbConnect.getConnection()) {
            var statementHotel = connection.createStatement();

            var rsHotel = statementHotel.executeQuery("select * from hotels");

//            while (rsAparts.next()) {
//                apartmentList.add(ApartmentOneRoom.builder()
//                        .roomNumber(rsAparts.getInt(2))
//                        .price(rsAparts.getInt(3))
//                        .places(rsAparts.getInt(4))
//                        .build());
//            }
            while (rsHotel.next()) {
                var apId = rsHotel.getInt("apartments_id");
                var sql = "select * from apartments left join apartment_params ap " +
                        "on ap.id = apartments.apartment_params_id where apartments.id = ?";
                try (var statementAparts = connection.prepareStatement(sql)) {
                    statementAparts.setInt(1, apId);
                    statementAparts.execute();
                }
//                var rsAparts = statementAparts
//                        .setInt(apId)
//                        .executeQuery();
                hotelList.add(Hotel.builder()
                        .name(rsHotel.getString(2))
                        .apartments(apartmentList)
                        .checkInTime(rsHotel.getTime(4).toLocalTime())
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotelList;
    }

    @SneakyThrows
    public Hotel save(Hotel hotel) {
        try (var connection = DbConnect.getConnection()) {
            var hotelList = all();
            if (hotelList.stream().map(h -> h.getName()).collect(Collectors.toList()).contains(hotel.getName())) {
                throw new HotelException("Hotel with name " + hotel.getName() + " already exist");
            }
            var sql = "insert into hotels values (?, ?, ?, ?, ?)";
            try (var insertStatement = connection.prepareStatement(sql)) {
                insertStatement.setString(1, DbUtils.generateUniqueId());
                insertStatement.setString(2, hotel.getName());
                insertStatement.setInt(3, 1);
                insertStatement.setTime(4, Time.valueOf(hotel.getCheckInTime()));
                insertStatement.setInt(5, hotel.getRoomsTotalCount());
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Hotel.builder().build();
    }

    @SneakyThrows
    public List<Hotel> dropAll() {
        List<Hotel> hotelList = new ArrayList();
        try (var connection = DbConnect.getConnection()) {
            hotelList.addAll(all());
            var sql = "truncate hotels";
            var truncateStatement = connection.prepareStatement(sql);
            truncateStatement.executeUpdate();
        }
        return hotelList;
    }

//    @SneakyThrows
//    public Hotel save(Hotel hotel) {
//        if (StringUtils.isBlank(hotel.getName())) {
//            throw new HotelException("Hotel name cannot be blank");
//        }
//        hotelByName.put(hotel.getName().toLowerCase(), hotel);
//        return hotel;
//    }

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

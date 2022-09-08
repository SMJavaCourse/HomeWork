package org.course.hotels.repository;

import org.course.hotels.dto.Apartment;
import org.course.hotels.dto.CommandsEnum;
import org.course.hotels.dto.Hotel;
import org.course.hotels.entity.services.ServicesAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@Repository
public class HotelRepository {
    private final DataSource dataSource;
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public HotelRepository(DataSource dataSource, ApartmentRepository apartmentRepository) {
        this.dataSource = dataSource;
        this.apartmentRepository = apartmentRepository;
    }

//    private ArrayList<Hotel> findHotelByName(String nameOfHotel) {
//        ArrayList<Hotel> hotels = new ArrayList<>();
//        try (var connection = dataSource.getConnection();
//             var statement = connection.prepareStatement("SELECT id, name, starttime FROM hotels WHERE UPPER(name) = UPPER(?)")) {
//            statement.setString(1, nameOfHotel);
//            try (var rs = statement.executeQuery()) {
//                if (rs.next()) {
//                    var id = rs.getString(1);
//                    var name = rs.getString(2);
//                    var startTime = rs.getString(3);
//                    var apartments = apartmentRepository.allApartmentsInHotel(rs.getString(1));
//                    hotels.add(new Hotel(id, name, startTime, apartments));
//                }
//                return hotels;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    private ArrayList<Hotel> getAllHotels(){
//        ArrayList<Hotel> hotels = new ArrayList<>();
//        try (var connection = dataSource.getConnection();
//             var allResults = connection.createStatement().executeQuery("SELECT id, name, starttime FROM hotels")) {
//            while (allResults.next()) {
//                var id = allResults.getString(1);
//                var name = allResults.getString(2);
//                var startTime = allResults.getString(3);
//                var apartments = apartmentRepository.allApartmentsInHotel(allResults.getString(1));
//                hotels.add(new Hotel(id, name, startTime, apartments));
//            }
//            return hotels;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public String hotelFinder(String nameOfHotel, String nameOfCommand, int numberOfGuests) {
//        StringBuilder finderHotelString = new StringBuilder();
//        ArrayList<Hotel> searchResult;
//        int numberOfHotelsFound = 0;
//        if (nameOfHotel == null || "".equals(nameOfHotel)) {
//            searchResult = getAllHotels();
//        } else {
//            searchResult = findHotelByName(nameOfHotel);
//        }
//        if (searchResult.size() == 0) {
//            finderHotelString
//                    .append("У нас нет информации по отелю \"")
//                    .append(nameOfHotel)
//                    .append("\"\nНовый поиск:");
//            return finderHotelString.toString();
//        }
//        if (nameOfCommand == null) {
//            for (Hotel hotel : searchResult) {
//                var apartmentsInHotel = apartmentRepository.suitableApartments(hotel.getId(), numberOfGuests);
//                long numberCount = apartmentsInHotel.size();
//                if (numberCount > 0) {
//                    finderHotelString
//                            .append("Отель \"")
//                            .append(hotel.getName())
//                            .append("\":\nПодходящих номеров: ")
//                            .append(numberCount)
//                            .append("\nНомера:\n")
//                            .append(apartmentsInHotel
//                                    .stream()
//                                    .map(Apartment::toString)
//                                    .collect(Collectors.joining("\n")))
//                            .append("\n");
//                    numberOfHotelsFound += 1;
//                }
//            }
//        } else {
//            for (CommandsEnum commandsEnum : CommandsEnum.values()) {
//                if (commandsEnum.getName().equalsIgnoreCase(nameOfCommand)) {
//                    finderHotelString
//                            .append("Отель \"")
//                            .append(nameOfHotel)
//                            .append("\"\n")
//                            .append(printServices(searchResult.get(0).getId()));
//                    numberOfHotelsFound = searchResult.size();
//                    break;
//                }
//            }
//        }
//        if (("".equals(finderHotelString.toString()) && nameOfHotel == null) || !finderHotelString.toString().equals("")) {
//            return "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "Новый поиск:";
//        } else {
//            return "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
//        }
//    }

//    private String printServices(String hotelId) {
//        HashMap<String, ArrayList<Apartment>> servicesMap = new HashMap<>();
//        var allApartments = apartmentRepository.allApartmentsInHotel(hotelId);
//        if (allApartments.size() == 0) {
//            return "У отеля нет доступных номеров";
//        }
//        for (Apartment apartment : allApartments) {
//            var allServicesInApartments = apartmentRepository.allServicesInApartment(apartment.getId());
//            for(ServicesAbstract service : allServicesInApartments){
//                ArrayList<Apartment> apartmentList = servicesMap.get(service.getName());
//                if (apartmentList == null) {
//                    apartmentList = new ArrayList<>();
//                    servicesMap.put(service.getName(), apartmentList);
//                }
//                apartmentList.add(apartment);
//            }
//        }
//        StringBuilder stringServices = new StringBuilder("Количество доступных удобств: " + servicesMap.size() + "\n");
//        for (String key : servicesMap.keySet()) {
//            ArrayList<Apartment> value = servicesMap.get(key);
//            stringServices
//                    .append("Удобство \"")
//                    .append(key)
//                    .append("\" доступно в номерах:\n");
//            for (Apartment apartment : value) {
//                stringServices
//                        .append("\t\u2219")
//                        .append(apartment.getName())
//                        .append(" (комната номер ")
//                        .append(apartment.getRoomNumber())
//                        .append(")\n");
//            }
//        }
//        return stringServices.toString();
//    }

//    public Hotel save(Hotel hotel){
//        if (findById(hotel.getId()) != null) {
//            try (var connection = dataSource.getConnection();
//                 var statement = connection.prepareStatement("UPDATE hotels SET name = ?, starttime = ? WHERE id = ?")) {
//                statement.setString(1, hotel.getName());
//                statement.setString(2, hotel.getStartTime());
//                statement.setString(3, hotel.getId());
//                statement.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            try (var connection = dataSource.getConnection();
//                 var statement = connection.prepareStatement("INSERT INTO hotels VALUES (?, ?, ?)")) {
//                statement.setString(1, hotel.getId());
//                statement.setString(2, hotel.getName());
//                statement.setString(3, hotel.getStartTime());
//                statement.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return hotel;
//    }
//    public void deleteAll(){
//        try (var connection = dataSource.getConnection();
//             var statement = connection.createStatement()) {
//            statement.executeUpdate("DELETE FROM hotels;");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public int deleteById(String hotelId) {
//        try (var connection = dataSource.getConnection();
//             var statement = connection.prepareStatement("DELETE FROM hotels WHERE id = ?")) {
//            statement.setString(1, hotelId);
//            return statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public Hotel findById(String hotelId) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, name, starttime FROM hotels WHERE id = ?")) {
            statement.setString(1, hotelId);
            var result = statement.executeQuery();
            if (result.next()) {
                var hotel = new Hotel();
                hotel.setId(result.getString(1));
                hotel.setName(result.getString(2));
                hotel.setStartTime(result.getString(3));
                hotel.setApartments(apartmentRepository.allApartmentsInHotel(result.getString(1)));
                return hotel;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
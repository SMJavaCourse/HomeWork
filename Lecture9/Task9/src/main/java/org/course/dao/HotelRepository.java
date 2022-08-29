package org.course.dao;

import org.course.entity.Apartment;
import org.course.entity.CommandsEnum;
import org.course.entity.Hotel;
import org.course.entity.ServicesEnum;
import org.course.entity.properties.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class HotelRepository {
    private ArrayList<Hotel> findHotel(String nameOfHotel) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, name, starttime FROM hotels WHERE UPPER(name) = UPPER(?)")) {
            statement.setString(1, nameOfHotel);
            try (var rs = statement.executeQuery()) {
                if (rs.next()) {
                    var name = rs.getString(2);
                    var startTime = rs.getString(3);
                    var apartments = findHotelsApartments(rs.getString(1));
                    hotels.add(new Hotel(name, startTime, apartments));
                } else {
                    try (var allResults = connection.createStatement().executeQuery("SELECT id, name, starttime FROM hotels")) {
                        while (allResults.next()) {
                            var name = allResults.getString(2);
                            var startTime = allResults.getString(3);
                            var apartments = findHotelsApartments(allResults.getString(1));
                            hotels.add(new Hotel(name, startTime, apartments));
                        }
                    }
                }
                return hotels;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    private ArrayList<Apartment> findHotelsApartments(String hotelId) {
        ArrayList<Apartment> result = new ArrayList<>();
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement("SELECT id, rooms, numberofroom, price," +
                     " capacity FROM apartments WHERE hotelid = ?")) {
            statement.setString(1, hotelId);
            try (var rs = statement.executeQuery()) {
                while (rs.next()) {
                    var apartment = new Apartment(0, 0, 0, 0, null);
                    if (rs.getInt(2) == 1) {
                        apartment.setName("Однокомнатный номер");
                    } else if (rs.getInt(2) == 2) {
                        apartment.setName("Двухкомнатный номер");
                    } else if (rs.getInt(2) == 3) {
                        apartment.setName("Трехкомнатный номер");
                    }
                    apartment.setNumberOfRoom(rs.getInt(3));
                    apartment.setPrice(rs.getInt(4));
                    apartment.setCapacity(rs.getInt(5));
                    apartment.setServices(findApartmentsServices(rs.getString(1)));
                    result.add(apartment);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    private ArrayList<Services> findApartmentsServices(String apartmentsId) {
        ArrayList<Services> services = new ArrayList<>();
        try (var connection = DataSource.getConnection();
             var statement = connection.prepareStatement("SELECT serviceName, serviceNameRu, " +
                     "defaultProperty, customProperty FROM apartmentServices LEFT JOIN services on" +
                     " services.id = apartmentServices.serviceId WHERE apartmentsId = ?;")) {
            statement.setString(1, apartmentsId);
            try (var rs = statement.executeQuery()) {
                while (rs.next()) {
                    services.add(servicesBuilder(
                            rs.getString("servicename"),
                            rs.getString("customproperty"),
                            rs.getString("defaultproperty")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return services;
    }
    private Services servicesBuilder(String nameOfService, String customProperty, String defaultProperty) {
        switch (ServicesEnum.valueOf(nameOfService.toUpperCase())) {
            case BALCONY -> {
                return new Balcony();
            }
            case CLEANING -> {
                return new Cleaning();
            }
            case CONDITIONER -> {
                return new Conditioner();
            }
            case JACUZZI -> {
                return new Jacuzzi();
            }
            case MEAT -> {
                return new Meat();
            }
            case INTERNET -> {
                if (customProperty == null || "".equals(customProperty)) {
                    return new Internet(Integer.parseInt(defaultProperty));
                } else {
                    return new Internet(Integer.parseInt(customProperty));
                }
            }
        }
        throw new RuntimeException();
    }
    public String hotelFinder(String nameOfHotel, String nameOfCommand, int numberOfGuests) {
        StringBuilder finderHotelString = new StringBuilder();
        int numberOfHotelsFound = 0;
        ArrayList<Hotel> searchResult = findHotel(nameOfHotel);
        if (searchResult.size() == 0) {
            finderHotelString
                    .append("У нас нет информации по отелю \"")
                    .append(nameOfHotel)
                    .append("\"\nНовый поиск:");
            return finderHotelString.toString();
        }
        if (nameOfCommand == null) {
            for (Hotel hotel : searchResult) {
                long numberCount = hotel.findApartment(hotel.getApartments() ,numberOfGuests).size();
                if (numberCount > 0) {
                    finderHotelString
                            .append("Отель \"")
                            .append(hotel.getName())
                            .append("\":\nПодходящих номеров: ")
                            .append(numberCount)
                            .append("\nНомера:\n")
                            .append(hotel.findApartment(hotel.getApartments(), numberOfGuests)
                                    .stream()
                                    .map(Apartment::toString)
                                    .collect(Collectors.joining("")));
                    numberOfHotelsFound += 1;
                }
            }
        } else {
            for (CommandsEnum commandsEnum : CommandsEnum.values()) {
                if (commandsEnum.getName().equalsIgnoreCase(nameOfCommand)) {
                    finderHotelString
                            .append("Отель \"")
                            .append(nameOfHotel)
                            .append("\"\n")
                            .append(searchResult.get(0).printServices(searchResult.get(0).getApartments()));
                    numberOfHotelsFound = searchResult.size();
                    break;
                }
            }
        }
        if (("".equals(finderHotelString.toString()) && nameOfHotel == null) || !finderHotelString.toString().equals("")) {
            return "Найдено отелей: " + numberOfHotelsFound + "\n" + finderHotelString + "\nНовый поиск:";
        } else {
            return "В отеле \"" + nameOfHotel + "\" нет достаточного количества мест\nНовый поиск:";
        }
    }

    public Hotel saveHotel(Hotel hotel){

        return hotel;
    }

    public void deleteAll(){
        try (var connection = DataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.executeUpdate("drop table apartmentservices;\n" +
                    "drop table apartments;\n" +
                    "drop table hotels;\n" +
                    "drop table services;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

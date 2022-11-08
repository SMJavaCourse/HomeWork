package org.course;

import lombok.SneakyThrows;


public class App {
    private static final int serverPort = 8080;

    private static final String jdbcUrl = "jdbc:postgresql://localhost:5433/postgres";
    private static final String username = "hotels";
    private static final String password = "hotels";

    @SneakyThrows
    public static void main(String[] args) throws HotelException {
        var dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setJdbcUrl(jdbcUrl);
        dataSourceFactory.setUsername(username);
        dataSourceFactory.setPassword(password);
        var dataSource = dataSourceFactory.getDataSource();

        var webServer = new WebServer(serverPort, dataSource);
        webServer.start();

//        var hotelService = new HotelService();

//        hotelService.saveHotel(HotelImpl.builder()
//                .name("У мамы лучше")
//                .apartments(List.of(new ApartmentOneRoom(1000f, 1, 1)
//                        .setServices(new ServicesImpl().addBalcony().addCleaning().addInternet().addConditioner())))
//                .checkInTime(LocalTime.of(12, 0))
//                .build());
//
//        System.out.println(hotelService.getAllHotels());
//        System.out.println(hotelService.removeHotels());


    }

}

package org.course.cities;

import lombok.SneakyThrows;

public class Application {
    private static final int serverPort = 8080;
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "postgres";

    @SneakyThrows
    public static void main(String[] args) {
        var dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setJdbcUrl(jdbcUrl);
        dataSourceFactory.setUsername(username);
        dataSourceFactory.setPassword(password);
        var dataSource = dataSourceFactory.getDataSource();

        var webServer = new WebServer(serverPort);
        webServer.start();
    }
}

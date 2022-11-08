package org.course;

import org.course.repository.ApartmentParamsRepo;
import org.course.repository.ApartmentsRepo;
import org.course.repository.HotelsRepo;
import org.course.repository.ServicesRepo;

import javax.sql.DataSource;

public class GlobalStorage {
    private static final int serverPort = 8080;
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5433/postgres";
    private static final String username = "postgres";
    private static final String password = "postgres";

    private DataSource dataSource;
    private HotelsRepo hotelsRepo;
    private ApartmentParamsRepo apartmentParamsRepo;
    private ApartmentsRepo apartmentsRepo;
    private ServicesRepo servicesRepo;

    public GlobalStorage() {
        var dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setJdbcUrl(jdbcUrl);
        dataSourceFactory.setUsername(username);
        dataSourceFactory.setPassword(password);

        dataSource = dataSourceFactory.getDataSource();
        hotelsRepo = new HotelsRepo(dataSource);
    }
}

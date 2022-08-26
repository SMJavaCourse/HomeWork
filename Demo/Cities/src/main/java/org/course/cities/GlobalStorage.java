package org.course.cities;

import org.course.cities.repository.CitiesRepository;
import org.course.cities.repository.CountryRepository;
import org.course.cities.repository.RegionsRepository;
import org.course.cities.repository.jdbc.CitiesJdbcRepository;
import org.course.cities.repository.jdbc.CountryJdbcRepository;
import org.course.cities.repository.jdbc.RegionsJdbcRepository;
import org.course.cities.repository.stub.CitiesStubRepository;
import org.course.cities.repository.stub.CountryStubRepository;
import org.course.cities.repository.stub.RegionsStubRepository;

import javax.sql.DataSource;

public class GlobalStorage {
    private static final boolean useStubRepo = false;
    private static final int serverPort = 8080;
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "postgres";

    private DataSource dataSource;
    private CitiesRepository citiesRepository;
    private RegionsRepository regionsJdbcRepository;
    private CountryRepository countryJdbcRepository;


    public GlobalStorage() {
        var dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setJdbcUrl(jdbcUrl);
        dataSourceFactory.setUsername(username);
        dataSourceFactory.setPassword(password);
        dataSource = dataSourceFactory.getDataSource();
        citiesRepository = useStubRepo ? new CitiesStubRepository() : new CitiesJdbcRepository(dataSource);
        regionsJdbcRepository = useStubRepo ? new RegionsStubRepository() : new RegionsJdbcRepository(dataSource);
        countryJdbcRepository = useStubRepo ? new CountryStubRepository() : new CountryJdbcRepository(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public CitiesRepository getCitiesRepository() {
        return citiesRepository;
    }

    public RegionsRepository getRegionsJdbcRepository() {
        return regionsJdbcRepository;
    }

    public CountryRepository getCountryJdbcRepository() {
        return countryJdbcRepository;
    }

    public int getServerPort() {
        return serverPort;
    }
}

package org.course.cities;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {
    private HikariConfig config = new HikariConfig();

    public DataSourceFactory() {
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }

    public void setJdbcUrl(String jdbcUrl) {
        config.setJdbcUrl(jdbcUrl);
    }

    public void setUsername(String username) {
        config.setUsername(username);
    }

    public void setPassword(String password) {
        config.setPassword(password);
    }


    public DataSource getDataSource() {
        return new HikariDataSource(config);
    }
}

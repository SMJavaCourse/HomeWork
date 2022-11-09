package org.course;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {
    private HikariConfig hikariConfig = new HikariConfig();

    public DataSourceFactory() {
//        hikariConfig.addDataSourceProperty("cachePrepStats", "true");
//        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
//        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }

    public void setJdbcUrl(String jdbcUrl) {
        hikariConfig.setJdbcUrl(jdbcUrl);
    }

    public void setUsername(String username) {
        hikariConfig.setUsername(username);
    }

    public void setPassword(String password) {
        hikariConfig.setPassword(password);
    }

    public DataSource getDataSource() {
        return new HikariDataSource(hikariConfig);
    }
}

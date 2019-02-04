package com.ak4.config;

import com.ak4.exception.AppWebApplicationException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:datasource-${spring.profiles.active}.properties")
public class DataSourceConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.pool.maxSize}")
    private Integer poolMaxSize;

    @Value("${jdbc.pool.minSize}")
    private Integer poolMinSize;

    @Bean
    public DataSource mySqlDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driverClassName);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setJdbcUrl(url);
            dataSource.setMinPoolSize(poolMinSize);
            dataSource.setMaxPoolSize(poolMaxSize);
        } catch (Exception e) {
            throw new AppWebApplicationException("Not able to connect with DB, Please try again later");
        }
        return dataSource;
    }
}

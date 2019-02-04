package com.ak4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class AdapterConfig {

    @Bean
    public HibernateJpaVendorAdapter mySqlAdapter() {
        HibernateJpaVendorAdapter mySqlAdapter = new HibernateJpaVendorAdapter();
        mySqlAdapter.setDatabase(Database.MYSQL);
        mySqlAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        mySqlAdapter.setGenerateDdl(true);
        mySqlAdapter.setShowSql(true);
        return mySqlAdapter;
    }
}

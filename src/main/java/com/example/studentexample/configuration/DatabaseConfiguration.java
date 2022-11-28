package com.example.studentexample.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfiguration {

    @Value("${student-app.database.username}")
    private String username;

    @Value("${student-app.database.password}")
    private String password;

    @Value("${student-app.database.url}")
    private String url;

    @Bean
    @ConditionalOnProperty(prefix = "student-app", name = "connection-type", havingValue = "in-memory")
    public DataSource getDatabaseDataSourceInMemory() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:inmemoryH2DB")
                .username("martins")
                .password("")
                .build();

    }

    @Bean
    @ConditionalOnProperty(prefix = "student-app", name = "connection-type", havingValue = "postgresql")
    public DataSource getDatabaseDataSourcePostgreSQL() {

        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(url)
                .username(username)
                .password(password)
                .build();

    }


}

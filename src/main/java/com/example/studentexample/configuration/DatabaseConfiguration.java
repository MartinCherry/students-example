package com.example.studentexample.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfiguration {

    String username = "postgres";
    String password = "docker";
    String url = "jdbc:postgresql://localhost:5432/postgres";

    @Bean
    @ConditionalOnProperty(prefix = "student-app", name = "connection-type", havingValue = "postgresql")
    public DataSource getDatabaseDataSourceInDatabase() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(url)
                .username(username)
                .password(password)
                .build();

    }

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


}

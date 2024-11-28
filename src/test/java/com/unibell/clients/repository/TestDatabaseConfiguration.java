package com.unibell.clients.repository;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
public class TestDatabaseConfiguration {

    private static final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:17.0")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    static {
        postgreSQLContainer.start();

        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());
        System.setProperty("spring.datasource.password", postgreSQLContainer.getPassword());
        System.setProperty("spring.datasource.username", postgreSQLContainer.getUsername());
    }
}

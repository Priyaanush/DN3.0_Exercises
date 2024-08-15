package com.example.yourapp.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@Profile("h2")
@EnableJpaRepositories(
    basePackages = "com.example.yourapp.repository.h2",
    entityManagerFactoryRef = "h2EntityManagerFactory",
    transactionManagerRef = "h2TransactionManager"
)
public class H2DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties h2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource h2DataSource() {
        return h2DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(h2DataSource())
                .packages("com.example.yourapp.model.h2")
                .persistenceUnit("h2")
                .build();
    }

    @Bean
    public JpaTransactionManager h2TransactionManager(EntityManagerFactory h2EntityManagerFactory) {
        return new JpaTransactionManager(h2EntityManagerFactory);
    }
}

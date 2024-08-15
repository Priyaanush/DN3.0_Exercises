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
@Profile("mysql")
@EnableJpaRepositories(
    basePackages = "com.example.yourapp.repository.mysql",
    entityManagerFactoryRef = "mySqlEntityManagerFactory",
    transactionManagerRef = "mySqlTransactionManager"
)
public class MySqlDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSourceProperties mySqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource mySqlDataSource() {
        return mySqlDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mySqlDataSource())
                .packages("com.example.yourapp.model.mysql")
                .persistenceUnit("mysql")
                .build();
    }

    @Bean
    public JpaTransactionManager mySqlTransactionManager(EntityManagerFactory mySqlEntityManagerFactory) {
        return new JpaTransactionManager(mySqlEntityManagerFactory);
    }
}

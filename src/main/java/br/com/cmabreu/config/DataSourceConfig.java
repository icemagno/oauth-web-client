package br.com.cmabreu.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl( "jdbc:postgresql://localhost:5432/geoportal" );
        dataSource.setUsername( "postgres" );
        dataSource.setPassword( "admin" );
        return dataSource;
    }	
	
	
}

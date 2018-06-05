package br.com.cmabreu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.cmabreu.*"})
@EntityScan(basePackages = {"br.com.cmabreu.model"})
@EnableJpaRepositories(basePackages = {"br.com.cmabreu.repository"})
public class UiApplication extends SpringBootServletInitializer {


    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
    
    
}
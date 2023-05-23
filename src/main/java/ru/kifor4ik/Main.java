package ru.kifor4ik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.repository.AbonentRepository;
import ru.kifor4ik.service.low.AbonentServiceLow;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.SQLException;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru/kifor4ik/*")
@EntityScan
@EnableWebMvc
@EnableSwagger2
public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);

    }
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
}

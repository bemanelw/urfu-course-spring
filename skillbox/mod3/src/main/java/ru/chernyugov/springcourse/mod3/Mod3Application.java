package ru.chernyugov.springcourse.mod3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
@EnableJdbcAuditing
@EntityScan(basePackages = "ru.chernyugov.springcourse.mod3")
public class Mod3Application {

    public static void main(String[] args) {
        SpringApplication.run(Mod3Application.class, args);
    }

}

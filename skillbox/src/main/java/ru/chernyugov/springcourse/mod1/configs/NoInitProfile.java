package ru.chernyugov.springcourse.mod1.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("no-init")
public class NoInitProfile {
    // Пустой класс для профиля no-init
}


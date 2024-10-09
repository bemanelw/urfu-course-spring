package ru.chernyugov.springcourse.mod2.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    private Boolean initStudents;

    public Boolean getInitStudents() {
        return initStudents;
    }

    public void setInitStudents(Boolean initStudents) {
        this.initStudents = initStudents;
    }
}


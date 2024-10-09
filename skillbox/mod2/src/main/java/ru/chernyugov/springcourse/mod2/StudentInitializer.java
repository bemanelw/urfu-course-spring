package ru.chernyugov.springcourse.mod2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import ru.chernyugov.springcourse.mod2.models.Student;
import ru.chernyugov.springcourse.mod2.properties.ApplicationProperties;
import ru.chernyugov.springcourse.mod2.repositories.StudentRepository;

@Configuration
public class StudentInitializer {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ApplicationProperties applicationProperties;

    @EventListener(ApplicationReadyEvent.class)
    public void initStudents() {
        if (Boolean.TRUE.equals(applicationProperties.getInitStudents())) {
            studentRepository.save(new Student(null, "John", "Doe", 20));
            studentRepository.save(new Student(null, "Jane", "Smith", 22));
        }
    }
}

package ru.chernyugov.springcourse.mod2.events;

import org.springframework.context.ApplicationEvent;
import ru.chernyugov.springcourse.mod2.models.Student;

public class StudentCreatedEvent extends ApplicationEvent {
    private final Student student;

    public StudentCreatedEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}

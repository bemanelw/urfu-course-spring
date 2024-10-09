package ru.chernyugov.springcourse.mod2.events;

import org.springframework.context.ApplicationEvent;

public class StudentDeletedEvent extends ApplicationEvent {
    private final Long id;

    public StudentDeletedEvent(Object source, Long id) {
        super(source);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
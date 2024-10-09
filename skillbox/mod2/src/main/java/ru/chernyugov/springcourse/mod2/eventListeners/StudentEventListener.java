package ru.chernyugov.springcourse.mod2.eventListeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.chernyugov.springcourse.mod2.events.StudentCreatedEvent;
import ru.chernyugov.springcourse.mod2.events.StudentDeletedEvent;

@Component
public class StudentEventListener {

    @EventListener
    public void onStudentCreated(StudentCreatedEvent event) {
        System.out.println("Student created: " + event.getStudent());
    }

    @EventListener
    public void onStudentDeleted(StudentDeletedEvent event) {
        System.out.println("Student deleted with ID: " + event.getId());
    }
}

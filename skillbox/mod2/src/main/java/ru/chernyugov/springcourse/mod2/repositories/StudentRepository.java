package ru.chernyugov.springcourse.mod2.repositories;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;
import ru.chernyugov.springcourse.mod2.events.StudentCreatedEvent;
import ru.chernyugov.springcourse.mod2.events.StudentDeletedEvent;
import ru.chernyugov.springcourse.mod2.models.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {
    private final Map<Long, Student> students = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    private final ApplicationEventPublisher eventPublisher;

    public StudentRepository(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Student save(Student student) {
        student.setId(idGenerator.getAndIncrement());
        students.put(student.getId(), student);
        eventPublisher.publishEvent(new StudentCreatedEvent(this, student));
        return student;
    }

    public void delete(Long id) {
        if (students.containsKey(id)) {
            students.remove(id);
            eventPublisher.publishEvent(new StudentDeletedEvent(this, id));
        }
    }

    public void clear() {
        students.clear();
    }

    public Map<Long, Student> findAll() {
        return students;
    }
}

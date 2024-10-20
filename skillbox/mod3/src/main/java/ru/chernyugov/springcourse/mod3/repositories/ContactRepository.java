package ru.chernyugov.springcourse.mod3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.chernyugov.springcourse.mod3.models.Contact;
@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
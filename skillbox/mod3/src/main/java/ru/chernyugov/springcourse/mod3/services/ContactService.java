package ru.chernyugov.springcourse.mod3.services;

import ru.chernyugov.springcourse.mod3.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();
    Optional<Contact> findById(Long id);
    Contact save(Contact contact);
    void deleteById(Long id);
}

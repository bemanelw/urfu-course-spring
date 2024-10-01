package ru.chernyugov.springcourse.mod1.repositories;

import org.springframework.stereotype.Repository;
import ru.chernyugov.springcourse.mod1.models.Contact;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepository {
    private final List<Contact> contacts = new ArrayList<>();

    public List<Contact> findAll() {
        return contacts;
    }

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public void deleteByEmail(String email) {
        contacts.removeIf(contact -> contact.getEmail().equals(email));
    }
}
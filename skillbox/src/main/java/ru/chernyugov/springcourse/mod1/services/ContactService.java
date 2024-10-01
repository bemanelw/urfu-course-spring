package ru.chernyugov.springcourse.mod1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.chernyugov.springcourse.mod1.models.Contact;
import ru.chernyugov.springcourse.mod1.repositories.ContactRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Value("${contacts.save.path}")
    private String saveFilePath;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContactByEmail(String email) {
        contactRepository.deleteByEmail(email);
    }

    public void saveContactsToFile() {
        try (FileWriter writer = new FileWriter(saveFilePath, true)) {
            List<Contact> contacts = getAllContacts();
            for (Contact contact : contacts) {
                writer.write(contact.getFullName() + ";" + contact.getPhoneNumber() + ";" + contact.getEmail() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
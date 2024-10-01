package ru.chernyugov.springcourse.mod1;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import ru.chernyugov.springcourse.mod1.models.Contact;
import ru.chernyugov.springcourse.mod1.services.ContactService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class ContactInitializer {
    private final ContactService contactService;

    @Value("${contacts.file.path}")
    private String filePath;

    @Autowired
    public ContactInitializer(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void init() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    Contact contact = new Contact(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    contactService.addContact(contact);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
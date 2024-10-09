package ru.chernyugov.springcourse.mod1.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.chernyugov.springcourse.mod1.models.Contact;
import ru.chernyugov.springcourse.mod1.services.ContactService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


@Component
public class ContactConsole implements CommandLineRunner {
    private final ContactService contactService;
    @Autowired
    public ContactConsole(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести все контакты");
            System.out.println("2. Добавить новый контакт");
            System.out.println("3. Удалить контакт по email");
            System.out.println("4. Сохранить контакты в файл");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    printAllContacts();
                    break;
                case 2:
                    addNewContact(scanner);
                    break;
                case 3:
                    deleteContactByEmail(scanner);
                    break;
                case 4:
                    saveContactsToFile();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void printAllContacts() {
        String filePath = "skillbox/contacts.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Нет контактов.");
        }
    }

    private void addNewContact(Scanner scanner) {
        System.out.println("Введите контакт в формате: Ф. И. О.; номер телефона; адрес электронной почты");
        String input = scanner.nextLine();
        String[] parts = input.split(";");
        if (parts.length == 3) {
            Contact contact = new Contact(parts[0].trim(), parts[1].trim(), parts[2].trim());
            contactService.addContact(contact);
        } else {
            System.out.println("Неверный формат ввода.");
        }
    }

    private void deleteContactByEmail(Scanner scanner) {
        System.out.println("Введите email для удаления контакта:");
        String email = scanner.nextLine();
        contactService.deleteContactByEmail(email);
    }

    private void saveContactsToFile() {
        contactService.saveContactsToFile();
        System.out.println("Контакты сохранены в файл.");
    }
}
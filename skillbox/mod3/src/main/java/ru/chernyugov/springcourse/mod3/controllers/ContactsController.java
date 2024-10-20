package ru.chernyugov.springcourse.mod3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chernyugov.springcourse.mod3.services.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "contacts";
    }

}
package ru.chernyugov.springcourse.mod3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.chernyugov.springcourse.mod3.models.Contact;
import ru.chernyugov.springcourse.mod3.services.ContactService;

@Controller
@RequestMapping("/contactForm")
public class ContactFormController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/add")
    public String addContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contactForm";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String editContactForm(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.findById(id).orElse(null));
        return "contactForm";
    }

    @PostMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, @ModelAttribute Contact contact) {
        contact.setId(id);
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteById(id);
        return "redirect:/contacts";
    }
}
package ru.chernyugov.springcourse.mod2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.chernyugov.springcourse.mod2.models.Student;
import ru.chernyugov.springcourse.mod2.repositories.StudentRepository;


@ShellComponent
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @ShellMethod("Add a new student")
    public String addStudent(@ShellOption String firstName, @ShellOption String lastName, @ShellOption int age) {
        Student student = new Student(null, firstName, lastName, age);
        studentRepository.save(student);
        return "Student added: " + student;
    }

    @ShellMethod("Delete a student by ID")
    public String deleteStudent(@ShellOption Long id) {
        studentRepository.delete(id);
        return "Student deleted with ID: " + id;
    }

    @ShellMethod("Clear all students")
    public String clearStudents() {
        studentRepository.clear();
        return "All students cleared";
    }

    @ShellMethod("List all students")
    public String listStudents() {
        return studentRepository.findAll().values().toString();
    }
}

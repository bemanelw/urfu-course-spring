package ru.chernyugov.springcourse.mod1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String fullName;
    private String phoneNumber;
    private String email;
}

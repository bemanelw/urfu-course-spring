package ru.chernyugov.springcourse.mod3.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("contacts")
public class Contact {
    @Id
    private Long id;
    @Column("firstname")
    private String firstName;
    @Column("lastname")
    private String lastName;
    @Column("email")
    private String email;
    @Column("phone")
    private String phone;
}


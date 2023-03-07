package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idCard",nullable = false, length = 20)
    private String idCard;

    @Column(name = "name1",nullable = false, length = 20)
    private String name1;

    @Column(name = "name2",nullable = false, length = 20)
    private String name2;

    @Column(name = "lastName1",nullable = false, length = 20)
    private String lastName1;

    @Column(name = "lastName2",nullable = false, length = 20)
    private String LastName2;
    private Date birthDate;

    @Column(name = "numPhone",nullable = false, length = 20, unique = true)
    private String numPhone;

    @Column(name = "email",nullable = false, length = 40, unique = true)
    private String email;

    @Column(name = "password",nullable = false, length = 20)
    private String password;

    @ElementCollection
    private Map<String, String> address;
}

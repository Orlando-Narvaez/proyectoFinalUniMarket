package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idCard",nullable = false)
    private int idCard;

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

    @Column(name = "userName",nullable = false, length = 20, unique = true)
    private String userName;

    @Column(name = "email",nullable = false, length = 40, unique = true)
    private String email;

    @Column(name = "password",nullable = false, length = 20)
    private String password;

    @ElementCollection
    private Map<String, String> address;
}

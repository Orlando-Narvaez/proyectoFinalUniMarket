package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private int idCard;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "birthDate", nullable = false)
    private LocalDateTime birthDate;

    @Column(name = "address", nullable = false, length = 30)
    private String address;

    @Column(name = "numPhone", nullable = false, length = 20, unique = true)
    private String numPhone;

    @Column(name = "userName", nullable = false, length = 20, unique = true)
    private String userName;

    @Column(name = "email", nullable = false, length = 40, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    private String password;
}
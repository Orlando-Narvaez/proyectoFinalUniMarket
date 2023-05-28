package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idCard;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "address", nullable = false, length = 30)
    private String address;

    @Column(name = "numPhone", nullable = false, length = 20)
    private String numPhone;

    @Column(name = "userName", nullable = false, length = 50)
    private String userName;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 200)
    private String password;
}
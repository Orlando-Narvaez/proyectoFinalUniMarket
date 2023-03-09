package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private String address;

    @Column(name = "name",nullable = false, length = 20)
    private String name;

    @Column(name = "postalCode",nullable = false, length = 20)
    private String postalCode;

    @OneToMany(mappedBy = "address")
    private List<User> persons;
}

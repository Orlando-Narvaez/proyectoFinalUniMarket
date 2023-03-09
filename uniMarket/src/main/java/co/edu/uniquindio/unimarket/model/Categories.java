package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categories implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int idCategory;

    @Column(name = "name",nullable = false, length = 20)
    private String name;
}

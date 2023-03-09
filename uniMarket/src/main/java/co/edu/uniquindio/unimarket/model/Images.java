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
public class Images implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int idImage;

    @Column(name = "nameImage", nullable = false, length = 30)
    private String nameImage;

    @Column(name = "urlImage", nullable = false)
    private String urlImage;
}

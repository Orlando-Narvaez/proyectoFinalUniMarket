package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Trademark implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private  int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "model", nullable = false)
    private Date model;
}

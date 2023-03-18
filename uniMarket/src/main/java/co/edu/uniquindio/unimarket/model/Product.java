package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int idProduct;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "publicationDate", nullable = false)
    private LocalDateTime publicationDate;

    @Column(name = "limitedDate", nullable = false)
    private LocalDateTime limitedDate;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "state", nullable = false)
    private Boolean state;

    @Column(name = "amount", nullable = false)
    private int amount;

    @ElementCollection
    @ToString.Exclude
    private Map<String, String> images;
}
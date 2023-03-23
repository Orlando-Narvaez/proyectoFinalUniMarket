package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PublicationState implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "state", nullable = false)
    private boolean state;

    @ManyToOne
    private Moderator moderator;

    @ManyToOne
    private Product product;
}
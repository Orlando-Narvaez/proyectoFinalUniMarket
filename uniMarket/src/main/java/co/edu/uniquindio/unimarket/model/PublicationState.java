package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "reason", length = 100)
    private String reason;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ElementCollection
    @ToString.Exclude
    private List<State> stateList;

    @ToString.Exclude
    @ManyToOne
    private Moderator moderator;

    @ToString.Exclude
    @ManyToOne
    private Product product;
}
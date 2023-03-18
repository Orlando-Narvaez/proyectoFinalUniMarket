package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PQR implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "state", nullable = false)
    private Boolean state;

    @Column(name = "dateRequest", nullable = false)
    private LocalDateTime dateRequest;

    @ManyToOne
    private User user;

    @ManyToOne
    private Moderator moderator;
}
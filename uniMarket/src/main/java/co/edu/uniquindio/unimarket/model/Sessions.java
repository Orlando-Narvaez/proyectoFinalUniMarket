package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sessions implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idSessions", nullable = false, length = 20)
    private int idSessions;

    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "endingDate", nullable = false)
    private LocalDateTime endingDate;

    @ToString.Exclude
    @ManyToOne
    private User user;
}
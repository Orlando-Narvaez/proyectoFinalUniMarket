package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
}
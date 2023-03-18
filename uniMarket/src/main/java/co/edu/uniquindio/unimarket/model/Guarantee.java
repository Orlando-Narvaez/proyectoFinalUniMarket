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
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Guarantee implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int idGuarantee;

    @Column(name = "dataRequest", nullable = false)
    private LocalDateTime dataRequest;

    @Column(name = "dateDeliver", nullable = false)
    private LocalDateTime dateDeliver;

    @Column(name = "describe", nullable = false, length = 100)
    private String describe;

    @ElementCollection
    @ToString.Exclude
    private Map<String, String> images;
}
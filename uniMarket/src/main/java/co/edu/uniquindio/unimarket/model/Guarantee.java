package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
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
public class Guarantee implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int idGuarantee;

    @Column(name = "describeGuarantee", nullable = false, length = 200)
    private String describeGuarantee;

    @Column(name = "dataRequest", nullable = false)
    private LocalDateTime dataRequest;

    @ElementCollection
    @ToString.Exclude
    private Map<String, String> images;

    @ToString.Exclude
    @ManyToOne
    private Product product;

    @ToString.Exclude
    @ManyToOne
    private User user;
}
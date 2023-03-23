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
public class Comments implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "comment", nullable = false)
    private String comment;
    
    @Column(name = "dateComment", nullable = false)
    private LocalDateTime dateComment;

    @ToString.Exclude
    @ManyToOne
    private User user;

    @ToString.Exclude
    @ManyToOne
    private Product product;
}
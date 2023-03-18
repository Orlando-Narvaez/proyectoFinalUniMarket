package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetailCart implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "shipping", nullable = false)
    private double shipping;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "valueTotal", nullable = false)
    private double valueTotal;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;
}
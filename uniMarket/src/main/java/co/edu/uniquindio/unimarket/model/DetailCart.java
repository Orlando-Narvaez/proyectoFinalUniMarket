package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;

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
    private int idCart;

    @Column(name = "idProduct", nullable = false)
    private int idProduct;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "shipping", nullable = false)
    private double shipping;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "valueTotal", nullable = false)
    private double valueTotal;
}
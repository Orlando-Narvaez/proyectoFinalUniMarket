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
public class Cart implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idCart", nullable = false, length = 20)
    private int idCart;

    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "endingDate", nullable = false)
    private LocalDateTime endingDate;

    @Column(name = "idUser", nullable = false, length = 20)
    private String idUser;

    @Column(name = "totalValue", nullable = false)
    private double totalValue;

    @ManyToOne
    private User user;

    @ToString.Exclude
    @OneToMany(mappedBy = "cart")
    private List<DetailCart> detailCartList;
}
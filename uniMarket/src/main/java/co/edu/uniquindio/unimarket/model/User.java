package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User extends Person implements Serializable
{
    @Column(name = "idCard", nullable = false)
    private int idCard;

    @Column(name = "creationDate",nullable = false)
    private LocalDateTime creationDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Sessions> sessionsList;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<PQR> pqrList;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Cart> cartList;
}
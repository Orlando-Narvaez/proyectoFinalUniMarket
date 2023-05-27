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
public class User extends Person implements Serializable
{
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false)
    private int idUser;
    @Column(name = "creationDate",nullable = false)
    private LocalDateTime creationDate;

    @ToString.Exclude
    @ManyToMany
    private List<Product> productList;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Sessions> sessionsList;
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<PQR> pqrList;
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Cart> cartList;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Favorite> favorite;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Guarantee> guaranteeList;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Comments> commentsList;

    @ToString.Exclude
    @OneToMany(mappedBy = "seller")
    private List<Product> productPublicationList;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Address> addressList;
}
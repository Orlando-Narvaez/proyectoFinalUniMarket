package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User extends Person implements Serializable
{
    @Column(name = "idCard",nullable = false)
    private int idCard;

    @Column(name = "creationDate",nullable = false)
    private Date creationDate;

    @ManyToOne
    private Address address;
}

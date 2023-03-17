package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pqrs implements Serializable
{
    @Id
    @EqualsAndHashCode.Include

    @Column(name = "idMod",nullable = false)
    private int idMod;
    @Column(name = "idUser",nullable = false)
    private int idUser;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "state",nullable = false)
    private Boolean state;
    @Column(name = "dateRequest",nullable = false)
    private Date dateRequest;
}

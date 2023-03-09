package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Moderator extends Person implements Serializable
{
    @Column(name = "idMod",nullable = false)
    private int idMod;
}

package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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
}
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
public class User extends Person implements Serializable
{
    @Column(name = "idCard",nullable = false, length = 20)
    private String idCard;

    private Date creationDate;
}

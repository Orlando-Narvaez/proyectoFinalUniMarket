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
public class User implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idUser",nullable = false, length = 20)
    private String idUser;
    private Date creationDate;

    @Column(name = "userName",nullable = false, length = 20, unique = true)
    private String userName;

    @Column(name = "idCard",nullable = false, length = 20)
    private String idCard;
}

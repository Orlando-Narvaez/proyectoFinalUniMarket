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
public class Moderator implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idMod",nullable = false, length = 20)
    private String idMod;

    @Column(name = "userName",nullable = false, length = 20, unique = true)
    private String userName;

    @Column(name = "idCard",nullable = false, length = 20)
    private String idCard;
}

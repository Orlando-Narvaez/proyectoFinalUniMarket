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
public class Sessions implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idSessions",nullable = false, length = 20)
    private String idSessions;
    private Date startDate;
    private Date endingDate;

    @Column(name = "idUser",nullable = false, length = 20)
    private String idUser;
}

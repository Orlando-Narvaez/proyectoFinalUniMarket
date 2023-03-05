package co.edu.uniquindio.unimarket.model;

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
    private String idSessions;
    private Date startDate;
    private Date endingDate;
    private String idUser;
}

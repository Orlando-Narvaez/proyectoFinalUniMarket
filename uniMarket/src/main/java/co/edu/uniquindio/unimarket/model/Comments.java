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

public class Comments implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "comment",nullable = false)
    private String comment;
    @Column(name = "dateComment",nullable = false)
    private Date dateComment;

}

package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Moderator extends Person implements Serializable
{
    @ToString.Exclude
    @OneToMany(mappedBy = "moderator")
    private List<PQR> pqrList;

    @ToString.Exclude
    @OneToMany(mappedBy = "moderator")
    private List<PublicationState> publicationStateList;

    @ToString.Exclude
    @OneToMany(mappedBy = "moderator")
    private List<Address> addressList;
}

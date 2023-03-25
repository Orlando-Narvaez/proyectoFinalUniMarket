package co.edu.uniquindio.unimarket.model;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable
{
    @Id
    @EqualsAndHashCode.Include
    private int idProduct;
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Column(name = "value", nullable = false)
    private double value;
    @Column(name = "publicationDate", nullable = false)
    private LocalDateTime publicationDate;
    @Column(name = "limitedDate", nullable = false)
    private LocalDateTime limitedDate;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "state", nullable = false)
    private Boolean state;
    @Column(name = "amount", nullable = false)
    private int amount;
    @ElementCollection
    @ToString.Exclude
    private Map<String, String> images;
    @ElementCollection
    @ToString.Exclude
    private List<Categories> categoriesList;
    @ToString.Exclude
    @ManyToMany(mappedBy = "productList")
    private List<User> userList;
    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<DetailCart> detailCartList;

    @ToString.Exclude
    @ManyToOne
    private User user;

    @ToString.Exclude
    @ManyToOne
    private Trademark trademark;

    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<Comments> commentsList;
    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<PublicationState> publicationStateList;
}
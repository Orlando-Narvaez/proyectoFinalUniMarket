package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.State;
import co.edu.uniquindio.unimarket.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductGetDTO
{
    private int idProduct;

    private String name;

    private double price;

    private LocalDateTime publicationDate;

    private LocalDateTime limitedDate;

    private String description;

    private State state;

    private int sellerCode;

    private List<ImgDTO> images;

    private List<Categories> categories;
}
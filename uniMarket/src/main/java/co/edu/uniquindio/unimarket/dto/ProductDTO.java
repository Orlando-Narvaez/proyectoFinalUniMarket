package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.Categories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public class ProductDTO
{
    private String name;

    private String description;

    private int units;

    private float value;

    private int sellerCode;

    private List<String> images;

    private List<Categories> categories;
}

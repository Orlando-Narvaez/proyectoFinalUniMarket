package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.Categories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductGetDTO
{
    private int code;

    private boolean state;

    private LocalDateTime deadLine;

    private String name;

    private String description;

    private int units;

    private float price;

    private int sellerCode;

    private List<String> images;

    private List<Categories> categories;
}
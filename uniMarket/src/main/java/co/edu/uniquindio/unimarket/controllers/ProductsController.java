package co.edu.uniquindio.unimarket.controllers;

import co.edu.uniquindio.unimarket.dto.MessageDTO;
import co.edu.uniquindio.unimarket.dto.ProductDTO;
import co.edu.uniquindio.unimarket.model.Categories;
import co.edu.uniquindio.unimarket.model.State;
import co.edu.uniquindio.unimarket.services.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/productos")
@AllArgsConstructor
public class ProductsController
{
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<MessageDTO> crearProducto(@Valid @RequestBody ProductDTO productDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                productService.createProduct(productDTO)
        ));
    }
    @DeleteMapping("/{idProduct}")
    public ResponseEntity<MessageDTO> eliminarProducto(@PathVariable int idProduct) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                productService.delateProduct(idProduct)
        ));
    }
    @PutMapping("/{idProduct}")
    public ResponseEntity<MessageDTO> actualizarProducto(@PathVariable int idProduct, @Valid @RequestBody ProductDTO productDTO) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                productService.updateProduct(idProduct, productDTO)
        ));
    }
    @PutMapping("/{state}")
    public ResponseEntity<MessageDTO> actualizarProductoEstado(@PathVariable State state, @PathVariable int codigo) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(
                HttpStatus.CREATED,
                false,
                productService.updateForState(codigo, state)
        ));
    }
    @GetMapping("/{idProduct}/{state}")
    public ResponseEntity<MessageDTO> obtenerProducto(@PathVariable int idProduct, @PathVariable State state) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                productService.updateForState(idProduct, state)
        ));
    }
    @GetMapping("/{categorie}")
    public ResponseEntity<MessageDTO> listarProductosPorCategoria(@PathVariable Categories categorie) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                productService.listProductForCategorie(categorie)
        ));
    }
    @GetMapping("/{idCard}")
    public ResponseEntity<MessageDTO> listarProductoUsuario(@PathVariable int idCard) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                productService.listProductUser(idCard)
        ));
    }
    @GetMapping("/favoritos/{idCard}")
    public ResponseEntity<MessageDTO> listarProductoFavUsuario(@PathVariable int idCard) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                productService.listProductFavUser(idCard)
        ));
    }
    @GetMapping("/{preciomin}/{preciomax}")
    public ResponseEntity<MessageDTO> listarProductoPrecios(@PathVariable double preciomin, @PathVariable double preciomax) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                productService.listProductPrices(preciomin,preciomax)
        ));
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<MessageDTO> listarProductosPorNombre(@PathVariable String nombre) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(
                HttpStatus.OK,
                false,
                productService.listProductForNome(nombre)
        ));
    }
}
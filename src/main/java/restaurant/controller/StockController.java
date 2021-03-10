package restaurant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;
import restaurant.model.Product;
import restaurant.model.dto.ProductDto;
import restaurant.service.StockService;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class StockController {

    private final StockService stockService;

    @PostMapping
    public ResponseEntity<Product> putProduct(@RequestBody ProductDto productDto) {
        Product product = stockService.saveProductDto(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> showProductById(@PathVariable(name = "id") String id) {
        Product product = stockService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> showAllProduct() {
        List<Product> products = stockService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable(name = "id") String id) {
        stockService.deleteById(id);
    }
}

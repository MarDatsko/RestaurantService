package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import restaurant.model.Product;
import restaurant.repository.ProductRepository;
import restaurant.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Product was added" + product;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") String id) {
        return productService.findById(id);
    }

    @GetMapping()
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable(name = "id") String id) {
        productService.deleteById(id);
        return "Product with id " + id + "was deleted";
    }

    @PutMapping()
    public Product updateProductById(@RequestBody Product newProduct) {
        return productService.updateProduct(newProduct);
    }

}

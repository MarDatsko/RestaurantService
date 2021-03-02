package restaurant.service;

import java.util.List;

import restaurant.model.Product;

public interface ProductService {

    Product saveProduct(Product product);

    Product updateProduct(Product newProduct);

    Product findById(String id);

    List<Product> findAll();

    void deleteById(String id);

    Product findByName(String name);
}

package restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import restaurant.exception.NotFoundException;
import restaurant.model.Product;
import restaurant.repository.ProductRepository;
import restaurant.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product with ID - " + id + " doesn't exist"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}

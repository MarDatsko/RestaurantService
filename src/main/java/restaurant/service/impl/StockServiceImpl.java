package restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.exception.NotEnoughProductsInStock;
import restaurant.model.Product;
import restaurant.service.ProductService;
import restaurant.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    private final ProductService productService;

    @Autowired
    public StockServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product putProductsToStock(String id, Integer count) {
        Product product = productService.findById(id);
        Integer value = product.getCount() + count;
        product.setCount(value);
        return productService.saveProduct(product);
    }

    @Override
    public Product getProductsFromStock(String id, Integer count) {
        Product product = productService.findByName(id);
        int value = product.getCount() - count;
        if (value < 0 ){
            throw new NotEnoughProductsInStock("Not enough " + product.getName() + " in stock.");
        }
        product.setCount(value);
        return productService.saveProduct(product);
    }
}

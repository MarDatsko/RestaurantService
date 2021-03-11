package restaurant.service;

import java.util.List;

import restaurant.model.Bill;
import restaurant.model.Dish;
import restaurant.model.FirstOrder;
import restaurant.model.Order;
import restaurant.model.Product;
import restaurant.model.dto.ProductDto;

public interface StockService {

    Product saveProductDto(ProductDto productDto);

    Product saveProduct(Product productDto);

    Product findById(String id);

    List<Product> findAll();

    void deleteById(String id);

    Product findByName(String name);

    List<Product> findAllByNameOrderByExpirationDateDesc(String name);

    void delete(Product product);

    boolean canWeMakeDish(Dish dish, Integer count);

    FirstOrder canWeMakeListOfDish(List<Order> order);

    // once a day check product expiration date, and delete
    // * send ADMIN(email) notification how much

    // once a day check the availability of products (more than 5)
    // *  send request to suppliers (email) "different products have different suppliers"
}

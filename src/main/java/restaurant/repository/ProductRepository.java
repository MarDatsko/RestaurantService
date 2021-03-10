package restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import restaurant.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);    // optional

    List<Product> findAllByName(String name);

    List<Product> findAllByNameOrderByExpirationDateDesc(String name);
}

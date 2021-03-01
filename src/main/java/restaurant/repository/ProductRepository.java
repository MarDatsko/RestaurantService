package restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import restaurant.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    Product findByName(String name);
}

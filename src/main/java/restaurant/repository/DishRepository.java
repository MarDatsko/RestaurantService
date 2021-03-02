package restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import restaurant.model.Dish;

@Repository
public interface DishRepository extends MongoRepository<Dish,String> {
}

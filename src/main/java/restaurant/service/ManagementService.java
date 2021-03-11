package restaurant.service;

import java.util.List;

import restaurant.model.Bill;
import restaurant.model.Dish;
import restaurant.model.Order;
import restaurant.model.RestaurantMenu;

public interface ManagementService {

    Dish saveDish(Dish dish);

    Dish updateDish(Dish newDish);

    Dish findById(String id);

    List<Dish> findAll();

    void deleteById(String id);

    RestaurantMenu showRestaurantMenu();

    Dish getDishByName(String name);

    Bill makeOrder(List<Order> order);
}

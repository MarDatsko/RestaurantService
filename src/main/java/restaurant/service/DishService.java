package restaurant.service;

import java.util.List;

import restaurant.model.Dish;
import restaurant.model.dto.MenuDishDto;

public interface DishService {

    Dish saveDish(Dish dish);

    Dish updateDish(Dish newDish);

    Dish findById(String id);

    List<Dish> findAll();

    void deleteById(String id);

    List<MenuDishDto> showRestaurantMenu();
}

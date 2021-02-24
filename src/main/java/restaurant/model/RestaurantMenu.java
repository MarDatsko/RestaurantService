package restaurant.model;

import java.util.List;

import lombok.Data;

@Data
public class RestaurantMenu {
    private List<Dish> breakfast;
    private List<Dish> mainDishes;
    private List<Dish> soups;
    private List<Drink> drinks;
}

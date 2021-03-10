package restaurant.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import restaurant.model.dto.MenuDishDto;
import restaurant.model.enums.DishType;

@Data
public class RestaurantMenu {
    private List<MenuDishDto> breakfast;
    private List<MenuDishDto> mainDishes;
    private List<MenuDishDto> soups;
    private List<Drink> drinks;

    public RestaurantMenu() {
        breakfast = new ArrayList<>();
        mainDishes = new ArrayList<>();
        soups = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public void addToList(DishType dishType, MenuDishDto menuDishDto) {
        switch (dishType) {
            case BREAKFAST:
                breakfast.add(menuDishDto);
                break;
            case MAIN_DISH:
                mainDishes.add(menuDishDto);
                break;
            case SOUP:
                soups.add(menuDishDto);
                break;
        }
    }


}

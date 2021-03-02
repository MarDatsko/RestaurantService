package restaurant.model.dish;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Map;

import restaurant.model.Dish;
import restaurant.model.DishMaker;
import restaurant.service.StockService;

public class Hamburger extends Dish implements DishMaker {
    private static final Map<String, Integer> compositionOfDishes = Map.of("Bacon", 4, "Cheese", 3, "Buns", 1);

    private StockService stockService;

    @Autowired
    public Hamburger(Object stockService) {
        this.stockService = (StockService) stockService;
    }

    @Override
    public boolean makeDish() {
        for (var map : compositionOfDishes.entrySet()) {
            stockService.getProductsFromStock(map.getKey(), map.getValue());
        }
        return true;
    }
}

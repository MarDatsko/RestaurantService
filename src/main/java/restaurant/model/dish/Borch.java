package restaurant.model.dish;

import restaurant.model.Dish;
import restaurant.model.DishMaker;

public class Borch extends Dish implements DishMaker {

    @Override
    public boolean makeDish() {
        return false;
    }
}

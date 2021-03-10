package restaurant.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum DishEnum {

    HAMBURGER(Map.of("Bacon", 5, "Cheese", 15, "Buns", 20));

    private Map<String, Integer> dishContent;

    DishEnum(Map<String, Integer> dishContent) {
        this.dishContent = new HashMap<>(dishContent);
    }

    public Map<String, Integer> getDishContent() {
        return this.dishContent;
    }

}

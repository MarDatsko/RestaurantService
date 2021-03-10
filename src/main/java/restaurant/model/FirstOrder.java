package restaurant.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FirstOrder {
    List<String> canCook;
    List<String> canNotCook;

    public FirstOrder() {
        canCook = new ArrayList<>();
        canNotCook = new ArrayList<>();
    }

    public void addToCanCook(String value) {
        canCook.add(value);
    }

    public void addToCanNotCook(String value) {
        canNotCook.add(value);
    }

    public void addToList(boolean canWe, String dishName) {
        if (canWe){
            addToCanCook(dishName);
        }else {
            addToCanNotCook(dishName);
        }
    }
}

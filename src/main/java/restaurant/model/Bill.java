package restaurant.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bill {
    private List<BillObject> billObjectList;
    private BigDecimal totalPrice;

    public Bill(){
        billObjectList = new ArrayList<>();
        totalPrice = BigDecimal.ZERO;
    }

    public void addToBill(Dish dishByName, Integer count) {
        BillObject billObject = new BillObject(dishByName.getName(), count, dishByName.getPrice());
        addToBillObjectsList(billObject);
        totalPrice = totalPrice.add(billObject.getTotalPrice());
    }

    private void addToBillObjectsList(BillObject billObject){
        billObjectList.add(billObject);
    }
}

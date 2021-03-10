package restaurant.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.model.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListWrapper {
    List<Order> orderList = new ArrayList<>();
}

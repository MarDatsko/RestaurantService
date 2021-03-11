package restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import restaurant.model.RestaurantMenu;
import restaurant.model.Bill;
import restaurant.model.FirstOrder;
import restaurant.model.dto.OrderListWrapper;
import restaurant.service.ManagementService;
import restaurant.service.StockService;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
public class RestaurantMenuController {

    private final ManagementService managementService;
    private final StockService stockService;

    @GetMapping
    public RestaurantMenu showMenu() {
        return managementService.showRestaurantMenu();
    }

    @PostMapping("order/check")
    public FirstOrder checkOrder(@RequestBody OrderListWrapper order) {
        return stockService.canWeMakeListOfDish(order.getOrderList());
    }

    @PostMapping("order/make")
    public Bill makeOrder(@RequestBody OrderListWrapper order) {
        return managementService.makeOrder(order.getOrderList());
    }
}

package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import restaurant.model.RestaurantMenu;
import restaurant.model.dto.MenuDishDto;
import restaurant.service.DishService;
import restaurant.service.OrderService;

@RestController
@RequestMapping("/menu")
public class RestaurantMenuController {

    private final OrderService orderService;
    private final DishService dishService;

    @Autowired
    public RestaurantMenuController(OrderService orderService, DishService dishService) {
        this.orderService = orderService;
        this.dishService = dishService;
    }

    @GetMapping
    public List<MenuDishDto> showMenu(){
        return dishService.showRestaurantMenu();
    }

    @GetMapping("/")
    public String makeOrder(@RequestParam String order){
        orderService.makeOrder(List.of(order));
        return "good";
    }
}

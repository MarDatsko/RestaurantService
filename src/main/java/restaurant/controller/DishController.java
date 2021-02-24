package restaurant.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import restaurant.model.Dish;
import restaurant.service.DishService;

@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public String saveDish(@RequestBody Dish dish) {
        dishService.saveDish(dish);
        return "Dish was added" + dish;
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable(name = "id") String id) {
        return dishService.findById(id);
    }

    @GetMapping()
    public List<Dish> getAllDish() {
        return dishService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteDishById(@PathVariable(name = "id") String id) {
        dishService.deleteById(id);
        return "Dish with id " + id + "was deleted";
    }

    @PutMapping()
    public Dish updateDishById(@RequestBody Dish newDish) {
        return dishService.updateDish(newDish);
    }


}

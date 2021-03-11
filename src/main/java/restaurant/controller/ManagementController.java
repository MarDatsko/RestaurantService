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

import lombok.AllArgsConstructor;
import restaurant.model.Dish;
import restaurant.service.ManagementService;

@AllArgsConstructor
@RestController
@RequestMapping("/dish")
public class ManagementController {

    private final ManagementService managementService;

    @PostMapping
    public String saveDish(@RequestBody Dish dish) {
        managementService.saveDish(dish);
        return "Dish was added" + dish;
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable(name = "id") String id) {
        return managementService.findById(id);
    }

    @GetMapping()
    public List<Dish> getAllDish() {
        return managementService.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteDishById(@PathVariable(name = "id") String id) {
        managementService.deleteById(id);
        return "Dish with id " + id + "was deleted";
    }

    @PutMapping()
    public Dish updateDishById(@RequestBody Dish newDish) {
        return managementService.updateDish(newDish);
    }


}

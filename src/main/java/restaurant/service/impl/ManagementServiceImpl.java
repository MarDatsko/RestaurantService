package restaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.SneakyThrows;
import restaurant.model.Bill;
import restaurant.model.Dish;
import restaurant.model.Order;
import restaurant.model.RestaurantMenu;
import restaurant.model.dto.MenuDishDto;
import restaurant.repository.DishRepository;
import restaurant.service.KitchenService;
import restaurant.service.ManagementService;

@Service
public class ManagementServiceImpl implements ManagementService {

    private final DishRepository dishRepository;
    private final KitchenService kitchenService;
    private final ModelMapper modelMapper;

    public ManagementServiceImpl(DishRepository dishRepository, @Lazy KitchenService kitchenService, ModelMapper modelMapper) {
        this.dishRepository = dishRepository;
        this.kitchenService = kitchenService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Dish newDish) {
        return dishRepository.save(newDish);
    }

    @SneakyThrows
    @Override
    public Dish findById(String id) {
        return dishRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        dishRepository.deleteById(id);
    }

    @Override
    public Dish getDishByName(String name) {
        return dishRepository.getDishByName(name);
    }

    @Override
    public RestaurantMenu showRestaurantMenu() {
        RestaurantMenu restaurantMenu = new RestaurantMenu();
        List<Dish> all = dishRepository.findAll();
        for (Dish dish : all) {
            MenuDishDto menuDishDto = modelMapper.map(dish, MenuDishDto.class);
            restaurantMenu.addToList(dish.getType(), menuDishDto);
        }
        return restaurantMenu;
    }

    @Override
    public Bill makeOrder(List<Order> order) {
        Bill bill = new Bill();
        for (Order element : order) {
            Dish dishByName = getDishByName(element.getDishName());
            bill.addToBill(dishByName, element.getCount());
            kitchenService.makeDish(element);
        }
        return bill;
    }
}

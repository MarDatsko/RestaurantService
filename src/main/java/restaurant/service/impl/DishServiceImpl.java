package restaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import lombok.SneakyThrows;
import restaurant.model.Dish;
import restaurant.model.RestaurantMenu;
import restaurant.model.dto.MenuDishDto;
import restaurant.repository.DishRepository;
import restaurant.service.DishService;

@Service
@Transactional
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, ModelMapper modelMapper) {
        this.dishRepository = dishRepository;
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
}

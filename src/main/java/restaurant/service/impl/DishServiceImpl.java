package restaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import restaurant.exception.NotFoundException;
import restaurant.model.Dish;
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

    @Override
    public Dish findById(String id) {
        return dishRepository.findById(id).orElseThrow(() -> new NotFoundException("Dish with ID - " + id + " doesn't exist"));
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
    public List<MenuDishDto> showRestaurantMenu(){
        List<Dish> all = dishRepository.findAll();
        List<MenuDishDto> collect = all.stream().map(dish -> modelMapper.map(dish, MenuDishDto.class)).collect(Collectors.toList());
        return collect;
    }
}

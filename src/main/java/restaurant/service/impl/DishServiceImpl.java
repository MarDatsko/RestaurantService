package restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import restaurant.exception.NotFoundException;
import restaurant.model.Dish;
import restaurant.repository.DishRepository;
import restaurant.service.DishService;

@Service
@Transactional
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
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
}

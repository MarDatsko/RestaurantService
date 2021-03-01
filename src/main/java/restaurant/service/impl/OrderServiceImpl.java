package restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import restaurant.model.DishMaker;
import restaurant.model.dish.Hamburger;
import restaurant.service.DishService;
import restaurant.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final DishService dishService;
    private final ApplicationContext applicationContext;

    @Autowired
    public OrderServiceImpl(DishService dishService, ApplicationContext applicationContext) {
        this.dishService = dishService;
        this.applicationContext = applicationContext;
    }

    @Override
    public Boolean makeOrder(List<String> order) {
        List<DishMaker> listDishMakerObjects = createListDishMakerObjects(order);
        for (DishMaker list :listDishMakerObjects ) {
            list.makeDish();
        }
        return true;
    }

    private List<DishMaker> createListDishMakerObjects(List<String> order) {
        List<DishMaker> dishMakerList = new ArrayList<>();
        Object bean = applicationContext.getBean(StockServiceImpl.class);
        for (String dish : order) {
            if ("Hamburger".equals(dish)) {
                dishMakerList.add(new Hamburger(bean));
            }
        }

        return dishMakerList;
    }


}

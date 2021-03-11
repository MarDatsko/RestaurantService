package restaurant.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;
import restaurant.exception.NotEnoughProductsInStock;
import restaurant.model.Dish;
import restaurant.model.Ingredient;
import restaurant.model.Order;
import restaurant.model.Product;
import restaurant.service.ManagementService;
import restaurant.service.KitchenService;
import restaurant.service.StockService;

@Service
@AllArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private final ManagementService managementService;
    private final StockService stockService;

    @Override
    public void makeDish(Order order) {
        Dish dishByName = managementService.getDishByName(order.getDishName());
        if (stockService.canWeMakeDish(dishByName, order.getCount())) {
            Integer countPreviousElements = 0;
            List<Ingredient> ingredients = dishByName.getIngredients();
            for (Ingredient ing : ingredients) {
                List<Product> products = stockService.findAllByNameOrderByExpirationDateDesc(ing.getName());
                for (var element : products) {
                    if ((element.getCount()) + countPreviousElements <= (ing.getCount() * order.getCount())) {
                        countPreviousElements = countPreviousElements + element.getCount();
                        stockService.delete(element);
                    } else {
                        element.setCount((element.getCount() + countPreviousElements) - (ing.getCount()* order.getCount()));
                        stockService.saveProduct(element);
                    }
                }
                countPreviousElements = 0;
            }
        } else {
            throw new NotEnoughProductsInStock("Can not make " + dishByName.getName());   // робота після того як викинеться помилка?
        }                                                                                   // вернути помилку
    }
}

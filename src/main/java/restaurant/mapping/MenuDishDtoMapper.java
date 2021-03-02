package restaurant.mapping;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import restaurant.model.Dish;
import restaurant.model.Product;
import restaurant.model.dto.MenuDishDto;

@Component
public class MenuDishDtoMapper extends AbstractConverter<Dish,MenuDishDto> {

    @Override
    protected MenuDishDto convert(Dish dish) {
        return MenuDishDto.builder()
                .dishWeight(dish.getDishWeight())
                .description(dish.getDescription())
                .name(dish.getName())
                .price(dish.getPrice())
                .products(dish.getProducts().stream().map(Product::getName).collect(Collectors.toList()))
                .build();
    }
}

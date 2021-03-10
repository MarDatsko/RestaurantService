package restaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import restaurant.model.Dish;
import restaurant.model.Ingredient;
import restaurant.model.Order;
import restaurant.model.Product;
import restaurant.model.Bill;
import restaurant.model.FirstOrder;
import restaurant.model.dto.ProductDto;
import restaurant.repository.ProductRepository;
import restaurant.service.DishService;
import restaurant.service.KitchenService;
import restaurant.service.StockService;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final ProductRepository productRepository;
    private final DishService dishService;
    private final ModelMapper modelMapper;
    private final KitchenService kitchenService;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product saveProductDto(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return productRepository.save(product);
    }

    @SneakyThrows
    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(NotFoundException::new); // ?????
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAllByNameOrderByExpirationDateDesc(String name) {  // list validation?????
        return productRepository.findAllByNameOrderByExpirationDateDesc(name);
    }

    @Override
    public boolean canWeMakeDish(Dish dish, Integer count) {
        boolean result = false;
        List<Ingredient> ingredients = dish.getIngredients();
        for (Ingredient ing : ingredients) {
            result = enoughProductsForDish(count, ing.getName(), ing.getCount());
        }
        return result;
    }

    @Override
    public FirstOrder canWeMakeListOfDish(List<Order> order) {
        boolean canWe = false;
        FirstOrder firstOrder = new FirstOrder();
        for (Order element : order) {
            List<Ingredient> ingredients = dishService.getDishByName(element.getDishName()).getIngredients();
            for (Ingredient ing : ingredients) {
                canWe = enoughProductsForDish(element.getCount(), ing.getName(), ing.getCount());
                if (!canWe){
                    firstOrder.addToList(canWe, element.getDishName());
                    break;
                }
                firstOrder.addToList(canWe, element.getDishName());
            }
        }
        return firstOrder;
    }

    private boolean enoughProductsForDish(Integer dishCount, String product, Integer count) {
        List<Product> allByName = productRepository.findAllByName(product);
        Integer productsSum = allByName.stream()
                .map(Product::getCount)
                .reduce(0, Integer::sum);
        return productsSum >= (count * dishCount);
    }

    @Override
    public Bill makeOrder(List<Order> order) {
        Bill bill = new Bill();
        for (Order element : order) {
            Dish dishByName = dishService.getDishByName(element.getDishName());
            bill.addToBill(dishByName, element.getCount());
            kitchenService.makeDish(element);
        }
        return bill;
    }
}
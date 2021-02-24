package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restaurant.model.Product;
import restaurant.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/put-products/{id}")
    public Product putProductsToStock (@PathVariable(name = "id") String id, @RequestParam Integer count) {
        return stockService.putProductsToStock(id, count);
    }

    @PostMapping("/get-products/{id}")
    public Product getProductsFromStock (@PathVariable(name = "id") String id, @RequestParam Integer count) {
        return stockService.getProductsFromStock(id, count);
    }

}

package restaurant.service;

import restaurant.model.Product;

public interface StockService {

    Product getProductsFromStock(String id, Integer count);
    Product putProductsToStock(String id, Integer count);

    //getSomeProducts
    //getNumberOfLeftProduct
}

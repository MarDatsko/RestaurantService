package restaurant.service;

import restaurant.model.Product;

public interface StockService {

    Product getProductsFromStock(String id, Integer count);
    Product putProductsToStock(String id, Integer count);

    //getSomeProducts
    //getNumberOfLeftProduct

    // once a day check product expiration date, and delete
            // * send ADMIN(email) notification how much

    // once a day check the availability of products (more than 5)
            // *  send request to suppliers (email) "different products have different suppliers"
}

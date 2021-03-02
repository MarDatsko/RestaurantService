package restaurant.service;

import java.util.List;

public interface OrderService {

    Boolean makeOrder (List<String> order);
    // 1. check if we can make dish
    //     1.1 if "no" send exception (not enough products for this dish)
    //     1.2 if "yes" get all necessary products, create and save order.


    // opportunity add new dish to order
    // possibility to refuse the ordered dish



    // ROLE client/admin

    // delivery service
    // suppliers service
}

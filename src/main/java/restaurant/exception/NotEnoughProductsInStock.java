package restaurant.exception;

public class NotEnoughProductsInStock extends RuntimeException{
    public NotEnoughProductsInStock(String message) {
        super(message);
    }
}

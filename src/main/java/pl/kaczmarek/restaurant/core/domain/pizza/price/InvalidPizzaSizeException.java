package pl.kaczmarek.restaurant.core.domain.pizza.price;

public class InvalidPizzaSizeException extends RuntimeException {


    public InvalidPizzaSizeException() {
    }

    public InvalidPizzaSizeException(String message) {
        super(message);
    }
}

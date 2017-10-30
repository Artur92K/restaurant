package pl.kaczmarek.restaurant.core.domain.pizza;

public class PizzaNotFoundException extends RuntimeException {
    public PizzaNotFoundException() {
    }

    public PizzaNotFoundException(String message) {
        super(message);
    }
}

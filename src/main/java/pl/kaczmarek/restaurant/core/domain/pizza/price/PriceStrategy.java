package pl.kaczmarek.restaurant.core.domain.pizza.price;

public interface PriceStrategy {

    double getPrice(double basePrice);
}

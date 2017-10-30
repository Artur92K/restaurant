package pl.kaczmarek.restaurant.core.domain.pizza.price;

class SmallStrategy implements PriceStrategy {
    @Override
    public double getPrice(double basePrice) {
        return basePrice * 1.1;
    }
}

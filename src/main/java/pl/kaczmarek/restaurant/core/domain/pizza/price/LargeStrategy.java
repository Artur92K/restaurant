package pl.kaczmarek.restaurant.core.domain.pizza.price;


class LargeStrategy implements PriceStrategy {

    @Override
    public double getPrice(double basePrice) {
        return basePrice * 2;
    }
}

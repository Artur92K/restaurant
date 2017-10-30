package pl.kaczmarek.restaurant.core.domain.pizza.price;

class MediumStrategy implements PriceStrategy {

    @Override
    public double getPrice(double basePrice) {
        return basePrice * 1.5;
    }
}

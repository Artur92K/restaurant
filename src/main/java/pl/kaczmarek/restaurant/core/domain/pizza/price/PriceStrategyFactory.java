package pl.kaczmarek.restaurant.core.domain.pizza.price;

public class PriceStrategyFactory {

    public PriceStrategy getStrategy(Size size) {
        switch (size) {
            case SMALL:
                return new SmallStrategy();
            case MEDIUM:
                return new MediumStrategy();
            case LARGE:
                return new LargeStrategy();
            default:
                throw new InvalidPizzaSizeException();
        }
    }
}

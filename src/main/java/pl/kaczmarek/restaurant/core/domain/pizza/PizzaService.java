package pl.kaczmarek.restaurant.core.domain.pizza;

import org.modelmapper.ModelMapper;
import pl.kaczmarek.restaurant.core.domain.pizza.DTO.PizzaDTO;
import pl.kaczmarek.restaurant.core.domain.pizza.price.PriceStrategy;
import pl.kaczmarek.restaurant.core.domain.pizza.price.PriceStrategyFactory;
import pl.kaczmarek.restaurant.core.domain.pizza.price.Size;

import java.util.List;
import java.util.stream.Collectors;

public class PizzaService {

    private final PriceStrategyFactory priceStrategyFactory;
    private final PizzaRepository pizzaRepository;
    private final ModelMapper modelMapper;

    public PizzaService(PriceStrategyFactory priceStrategyFactory, PizzaRepository pizzaRepository, ModelMapper modelMapper) {
        this.priceStrategyFactory = priceStrategyFactory;
        this.pizzaRepository = pizzaRepository;
        this.modelMapper = modelMapper;
    }

    public double getPrice(Size size, Long pizzaId) {
        PriceStrategy strategy = priceStrategyFactory.getStrategy(size);
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(PizzaNotFoundException::new);
        return strategy.getPrice(pizza.getBasePrice());
    }

    public List<PizzaDTO> getAll() {
        pizzaRepository.findAll().stream().mapToDouble(Pizza::getBasePrice).max().getAsDouble();
        return pizzaRepository.findAll().stream().map(pizza -> modelMapper.map(pizza, PizzaDTO.class)).collect(Collectors.toList());

    }

    public PizzaDTO getPizza(Long id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(PizzaNotFoundException::new);
        return modelMapper.map(pizza, PizzaDTO.class);
    }

}

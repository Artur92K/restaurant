package pl.kaczmarek.restaurant.core.domain.pizza;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kaczmarek.restaurant.core.domain.pizza.price.PriceStrategyFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
class PizzaConfig {


    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private PizzaRepository pizzaRepository;


    @Bean
    PizzaService pizzaService(PizzaRepository pizzaRepository, ModelMapper modelMapper) {
        return new PizzaService(new PriceStrategyFactory(), pizzaRepository, modelMapper);
    }

    @PostConstruct
    void init() {

        List<Ingredient> list = new ArrayList<>();
        Ingredient cheese = new Ingredient("cheese", 5.5d);

        list.add(cheese);

        ingredientRepository.save(list);

        Pizza pizza = new Pizza("margarita", list);
        pizzaRepository.save(pizza);

    }
}

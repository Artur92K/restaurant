package pl.kaczmarek.restaurant.core.domain.pizza;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kaczmarek.restaurant.core.domain.pizza.price.Size;

@RestController
@RequestMapping("/pizzas")
public class PizzaQueryController {

    private PizzaService pizzaService;

    public PizzaQueryController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/{id}/size/{size}")
    ResponseEntity getPrice(@PathVariable("id") Long id, @PathVariable("size") Size size) {
        return ResponseEntity.ok(pizzaService.getPrice(size, id));
    }

    @GetMapping
    ResponseEntity getPizzas() {
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity getPizza(@PathVariable("id") Long id) {
        return ResponseEntity.ok(pizzaService.getPizza(id));
    }

}

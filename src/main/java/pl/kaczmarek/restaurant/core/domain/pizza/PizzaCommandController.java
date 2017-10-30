package pl.kaczmarek.restaurant.core.domain.pizza;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PizzaCommandController {

    PizzaService pizzaService;

    @PostMapping
    ResponseEntity createCustomPizza() {
//        pizzaService.createPizza();

        return ResponseEntity.ok().build();
    }
}

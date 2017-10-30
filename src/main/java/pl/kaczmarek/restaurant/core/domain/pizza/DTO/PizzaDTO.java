package pl.kaczmarek.restaurant.core.domain.pizza.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {

    private Long id;

    private String name;

    private String description;

    private IngredientDTO ingredientDTO;

}

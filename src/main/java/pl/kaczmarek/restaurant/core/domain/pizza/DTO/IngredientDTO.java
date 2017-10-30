package pl.kaczmarek.restaurant.core.domain.pizza.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {

    private Long id;
    private String name;
}

package pl.kaczmarek.restaurant.core.domain.order;

import lombok.Data;
import pl.kaczmarek.restaurant.core.domain.pizza.price.Size;

@Data
public class CreateOrderDTO {


    private Long pizzaId;
    private Long customerId;
    private Size size;
}

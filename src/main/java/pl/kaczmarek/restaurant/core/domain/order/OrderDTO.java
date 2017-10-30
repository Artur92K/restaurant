package pl.kaczmarek.restaurant.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.kaczmarek.restaurant.core.domain.pizza.price.Size;

@Data
@AllArgsConstructor
public class OrderDTO {

    private Long pizzaId;
    private Long customerId;
    private Size size;
    private double price;


    public static OrderDTOBuilder builder() {
        return new OrderDTOBuilder();
    }

    public static class OrderDTOBuilder {
        private Long pizzaId;
        private Long customerId;
        private Size size;
        private double price;

        public OrderDTOBuilder pizzaId(Long pizzaId) {
            this.pizzaId = pizzaId;
            return this;
        }

        public OrderDTOBuilder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public OrderDTOBuilder size(Size size) {
            this.size = size;
            return this;
        }

        public OrderDTOBuilder price(double price) {
            this.price = price;
            return this;
        }

        public OrderDTO build() {
            return new OrderDTO(pizzaId, customerId, size, price);
        }
    }

}

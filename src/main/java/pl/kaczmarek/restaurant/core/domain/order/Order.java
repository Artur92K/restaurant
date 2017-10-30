package pl.kaczmarek.restaurant.core.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerId;

    private Long pizzaId;

    private double price;

    private LocalDateTime localDateTime;

    public Order(Long customerId, Long pizzaId, double price, LocalDateTime localDateTime) {
        this.customerId = customerId;
        this.pizzaId = pizzaId;
        this.price = price;
        this.localDateTime = localDateTime;
    }
}

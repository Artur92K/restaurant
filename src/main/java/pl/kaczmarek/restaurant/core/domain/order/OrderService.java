package pl.kaczmarek.restaurant.core.domain.order;

import pl.kaczmarek.restaurant.core.domain.customer.CustomerDTO;
import pl.kaczmarek.restaurant.core.domain.customer.CustomerService;
import pl.kaczmarek.restaurant.core.domain.pizza.PizzaService;
import pl.kaczmarek.restaurant.core.domain.pizza.price.Size;

import java.time.LocalDateTime;

public class OrderService {


    private final CustomerService customerService;
    private final PizzaService pizzaService;
    private final OrderRepository orderRepository;


    public OrderService(PizzaService pizzaService, CustomerService customerService, OrderRepository orderRepository) {
        this.pizzaService = pizzaService;
        this.customerService = customerService;
        this.orderRepository = orderRepository;
    }

    public OrderDTO orderPizza(Long pizzaId, Size size, Long customerId) {
        double price = pizzaService.getPrice(size, pizzaId);
        CustomerDTO customer = customerService.getCustomer(customerId);
        Order order = createOrder(price, pizzaId, customer.getId());
        orderRepository.save(order);
        return OrderDTO.builder().build();
    }

    private Order createOrder(double price, Long pizzaId, Long customerId) {
        return new Order(customerId, pizzaId, price, LocalDateTime.now());
    }

    public OrderDTO getOrder(Long id) {
//        pizzaFacade.getPrice()
        return null;
    }

}

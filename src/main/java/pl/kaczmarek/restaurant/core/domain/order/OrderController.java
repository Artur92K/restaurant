package pl.kaczmarek.restaurant.core.domain.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
class OrderController {

    private OrderService orderService;


    @PostMapping
    public ResponseEntity orderPizza(@RequestBody CreateOrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.orderPizza(orderDTO.getPizzaId(), orderDTO.getSize(), orderDTO.getCustomerId()));

    }

    @GetMapping("/{id}")
    public ResponseEntity getOrder(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }


}

package pl.kaczmarek.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/test")
    public ResponseEntity hello() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/test2")
    public ResponseEntity hello2() {
        return ResponseEntity.ok(orderRepository.save(new Order("test")));
    }


}

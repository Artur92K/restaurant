import org.springframework.beans.factory.annotation.Autowired
import pl.kaczmarek.restaurant.core.domain.order.OrderRepository
import testapi.MockMvcSpec

class OrderSpec extends MockMvcSpec {
    @Autowired
    private OrderRepository orderRepository

}

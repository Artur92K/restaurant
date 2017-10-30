import org.springframework.beans.factory.annotation.Autowired
import testapi.MockMvcSpec

import javax.sql.DataSource

class PizzaSpec extends MockMvcSpec {

    @Autowired
    private DataSource dataSource

    def 'should return all kinds of pizza'() {

        given:
        when:
        def (response, json) = performGet("/test", new HashMap<String, Object>())
        def (response1, json1) = performGet("/test2", new HashMap<String, Object>())
        then:
        response.status == 200
        def all = orderRepository.findAll()
        print('dasda')
    }

    def 'should return pizza price'() {

    }

    def 'should return details about specific pizza'() {

    }
}

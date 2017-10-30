package testapi

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.context.WebApplicationContext
import pl.kaczmarek.restaurant.RestaurantApplication
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [RestaurantApplication])
class MockMvcSpec extends Specification {

    @Autowired
    protected WebApplicationContext context
    protected MockMvc mockMvc

    void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build()
    }

    def performGet(String url, Map<String, Object> params = [:]) {
        def paramsMap = new LinkedMultiValueMap()
        params.each { k, v ->
            if (v instanceof List) {
                def vStrings = v.collect { it.toString() }
                paramsMap.put(k, vStrings)
            } else {
                paramsMap.put(k, [v])
            }
        }
        def response = mockMvc.perform(MockMvcRequestBuilders.get(url).params(paramsMap)).andReturn().response
        def content = response.contentAsString ? new JsonSlurper().parseText(response.contentAsString) : ""
        return [response, content]
    }

    def performPost(String url, Object body) {
        def jsonBody = new JsonBuilder(body).toPrettyString()
        def response = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response
        def content = response.contentAsString ? new JsonSlurper().parseText(response.contentAsString) : ""
        return [response, content]
    }

    def performDelete(String url) {
        def response = mockMvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response
        def content = response.contentAsString ? new JsonSlurper().parseText(response.contentAsString) : ""
        return [response, content]
    }

    def performPut(String url, Object body) {
        def jsonBody = new JsonBuilder(body).toPrettyString()
        def response = mockMvc.perform(MockMvcRequestBuilders.put(url)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().response
        def content = response.contentAsString ? new JsonSlurper().parseText(response.contentAsString) : ""
        return [response, content]
    }


}


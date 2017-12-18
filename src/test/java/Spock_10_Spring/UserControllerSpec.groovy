package Spock_10_Spring

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Title
import spock.mock.DetachedMockFactory

import java.lang.Void as Should

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//Rename package
@Title("Tests for UserController")
@WebMvcTest
class UserControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    @Autowired
    UserFacade userFacade

    private final ObjectMapper objectMapper = new ObjectMapper()

    Should "add user to DB"() {
        given: "user to add"
            def userToAdd = new User()
        and: "added user with id"
            def addedUser = new User()
            addedUser.setId(1l)
        and: "returned"
            userFacade.add(userToAdd) >> addedUser
        when:
            def result = mvc.perform(post("/")
                    .content(objectMapper.writeValueAsString(userToAdd)))
        then:
            result.andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(addedUser)))
    }

    @TestConfiguration
    static class MockConfig {
        def detachedMockFactory = new DetachedMockFactory()

        @Bean
        UserFacade userFacade() {
            return detachedMockFactory.Stub(UserFacade)
        }
    }

}

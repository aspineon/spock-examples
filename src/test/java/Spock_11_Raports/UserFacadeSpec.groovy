package Spock_11_Raports

import spock.lang.Issue
import spock.lang.Specification
import spock.lang.Title
import java.lang.Void as Should

@Title("User facade is responsible for all operations related to users")
class UserFacadeSpec extends Specification {

    def userFacade = new UserFacade()

    @Issue("http://some-story-link")
    Should "add new user to DB" () {
        given: "new user to add"
            def userToAdd = new User()
        when: "new user is added to DB"
            def addedUser = userFacade.addUser(userToAdd)
        then: "user is returned from DB"
            addedUser
        and: "user ID is set"
            addedUser.getId() == 1
    }

}

class UserFacade {

    User addUser(User userToAdd) {
        userToAdd.setId(1l)
        return userToAdd
    }

}

class User {
    long id
}
package Spock_9_Extensions

import spock.lang.Issue
import spock.lang.Specification

/**
 * Issue example
 */
class IssueSpec extends Specification {

    @Issue("http://link-to-issue")
    def "Some issue fix" () {
        // some test logic
    }

}
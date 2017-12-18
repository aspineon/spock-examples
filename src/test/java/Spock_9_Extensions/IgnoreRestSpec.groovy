package Spock_9_Extensions

import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * Ignore rest example
 */
class IgnoreRestSpec extends Specification {

    def "This test will be ignored" () {
        //ignored test
    }

    @IgnoreRest
    def "This test will be executed" () {

    }

}
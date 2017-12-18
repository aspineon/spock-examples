package Spock_9_Extensions

import spock.lang.Ignore
import spock.lang.Specification

/**
 * Ignore spec
 */
class IgnoreSpec extends Specification {

    @Ignore
    def "Ignored feature" () {
        expect:
            println "Ignored"
    }

    def "Not ignored feature" () {
        expect:
            println "Not ignored"
    }

}
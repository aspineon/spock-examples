package Spock_9_Extensions

import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class StepwiseSpec extends Specification {

    def "This test will run as a first" () {
        //first
    }


    def "This test will run as a second" () {
        //second
    }

}
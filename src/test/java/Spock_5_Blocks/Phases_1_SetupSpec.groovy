package Spock_5_Blocks

import spock.lang.Specification

//Phase: Setup
//Setup for ours features

class Phases_1_SetupSpec extends Specification {

    def "Example with setup" () {
        setup:
            def variable = 10
    }

    def "Example with given as a alias for setup" () {
        given:
            def variable = 10
    }

    def "Example setup phase with and" () {
        given: "first variable"
            def variable = 10
        and: "second variable"
            def secondVariable = 20
    }

    def "Example setup phase as optional" () {
        when:
            def result = true
        then:
            result
    }

}
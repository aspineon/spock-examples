package Spock_5_Blocks

import spock.lang.Specification

//Phase: Stimulus

class Phases_2_StimulusSpec extends Specification {

    def classUnderTest = new SomeClassUnderTest()

    def "Example with when" () {
        when:
            def result = classUnderTest.someMethodUnderTest()
        then:
            result
    }

    def "Example with when and" () {
        when:
            def result = classUnderTest.someMethodUnderTest()
        then:
            result
        and:
            result == true
    }

    def "Example with expect" () {
        expect:
            classUnderTest.someMethodUnderTest()
    }

}

class SomeClassUnderTest {

    boolean someMethodUnderTest() {
        true
    }

}
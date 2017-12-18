package Spock_5_Blocks

import spock.lang.Specification

class Phases_3_ResponseSpec extends Specification {

    def classUnderTest = new SomeClassUnderTest()

    def "Then example" () {
        when:
            def result = classUnderTest.someMethodUnderTest()
        then:
            result
    }

    def "Expect example" () {
        expect:
            classUnderTest.someMethodUnderTest()
    }

    def "Condition example -> boolean expressions" () {
        given:
            def listUnderTest = ["One", "Two", "Three"]
        when:
            def result = listUnderTest.add("Four")
        then:
            result
            result == true
            listUnderTest.contains("Five")
    }

}



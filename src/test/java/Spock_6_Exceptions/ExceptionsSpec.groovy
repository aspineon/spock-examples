package Spock_6_Exceptions

import spock.lang.Specification

/**
 * Exception examples
 */
class ExceptionsSpec extends Specification {

    def "Example with thrown" () {
        given:
            def someThrowableClass = new SomeThrowableClass()
        when:
            someThrowableClass.someThrowableMethod()
        then:
            thrown(IllegalArgumentException)
    }

    def "Example with thrown as variable" () {
        given:
            def someThrowableClass = new SomeThrowableClass()
        when:
            someThrowableClass.someThrowableMethod()
        then:
            def exception = thrown(IllegalArgumentException)
            exception.message == "Message"
    }

    def "Example with thrown as variable inferred" () {
        given:
            def someThrowableClass = new SomeThrowableClass()
        when:
            someThrowableClass.someThrowableMethod()
        then: "an IllegalArgumentException is thrown"
            IllegalArgumentException exception = thrown()
            exception.message == "Message"
    }
    def "Example with notThrown" () {
        given:
            def someThrowableClass = new SomeThrowableClass()
        when:
            someThrowableClass.someNotThrowableMethod()
        then:
            notThrown(IllegalArgumentException)
    }


}

/**
 * Some throwable class
 */
class SomeThrowableClass {

    void someThrowableMethod() {
        throw new IllegalArgumentException("Message")
    }

    void someNotThrowableMethod() {

    }

}
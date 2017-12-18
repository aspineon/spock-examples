package Spock_8_Interactions

import spock.lang.Specification
import java.lang.Void as Should

/**
 * Mock examples
 */
class MockSpec extends Specification {

    Should "invoke dependency method" () {
        given:
            def mock = Mock(SomeDependencyClass)
            def classUnderTest = new SomeClassUnderTestWithDependency(mock)
        when:
            classUnderTest.someMethod()
        then:
            1 * mock.dependencyMethod()
//            0 * mock.dependencyMethod()
//            (1..3) * mock.dependencyMethod()
//            (1.._) * mock.dependencyMethod()
//            (_..3) * mock.dependencyMethod()
//            _ * mock.dependencyMethod()
    }



}
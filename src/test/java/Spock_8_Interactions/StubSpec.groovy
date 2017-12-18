package Spock_8_Interactions

import spock.lang.Specification
import java.lang.Void as Should


/**
 * Stub example
 */
class StubSpec extends Specification {

    Should "return false when dependencyMethod return null" () {
        given:
            def stub = Stub(SomeDependencyClass)
            stub.dependencyMethod() >> null
            def classUnderTest = new SomeClassUnderTestWithDependency(stub)
        when:
            def result = classUnderTest.someMethod()
        then:
            !result
    }

    Should "return true when dependencyMethod return not empty String" () {
        given:
            def stub = Stub(SomeDependencyClass)
            stub.dependencyMethod() >> "SomeString"
            def classUnderTest = new SomeClassUnderTestWithDependency(stub)
        when:
            def result = classUnderTest.someMethod()
        then:
            result
    }

    Should "throw exception from dependencyMethod" () {
        given:
            def stub = Stub(SomeDependencyClass)
            stub.dependencyMethod() >> { throw new IllegalArgumentException("Message")}
            def classUnderTest = new SomeClassUnderTestWithDependency(stub)
        when:
            classUnderTest.someMethod()
        then:
            def exception = thrown(IllegalArgumentException)
            exception.message == "Message"
    }

    Should "return true when dependencyParamMethod return true" () {
        given:
            def stub = Stub(SomeDependencyClass)
            stub.dependencyParamMethod(_) >> true
            def classUnderTest = new SomeClassUnderTestWithDependency(stub)
        when:
            def result = classUnderTest.someParamMethod("Param")
        then:
            result
    }

}

class SomeClassUnderTestWithDependency {

    private final SomeDependencyClass dependency

    SomeClassUnderTestWithDependency(SomeDependencyClass dependency) {
        this.dependency = dependency
    }

    boolean someMethod() {
        if (dependency.dependencyMethod()) {
            return true
        }
        false
    }

    boolean someParamMethod(String param) {
        if (dependency.dependencyParamMethod(param)) {
            return true
        }
        false
    }
}

class SomeDependencyClass {

    String dependencyMethod() {
        "Dependency"
    }

    boolean dependencyParamMethod(String text) {
        false
    }
}
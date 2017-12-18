package Spock_7_Data_Driven

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.lang.Void as Should

/**
 * Data driven examples
 */
class DataDrivenSpec extends Specification {

    @Shared
    EnterpriseCalculator calculator = new EnterpriseCalculator()

    def "Old approach"() {
        given:
            int number = 10
            int numberToAdd = 20
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == 30
    }

    def "Old approach with zeros"() {
        given:
            int number = 0
            int numberToAdd = 0
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == 0
    }

    def "Data variables"() {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == 0
        where:
            number = 0
            numberToAdd = 0
    }

    def "Data tables"() {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == expectedResult
        where:
            number | numberToAdd | expectedResult
            0      | 0           | 0
            10     | 20          | 30
    }

    def "Data tables with variables"(int number, int numberToAdd, int expectedResult) {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == expectedResult
        where:
            number | numberToAdd | expectedResult
            0      | 0           | 0
            10     | 20          | 30
    }

    def "Data tables more readability"() {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == expectedResult
        where:
            number | numberToAdd || expectedResult
            0      | 0           || 0
            10     | 20          || 30
    }

    def "Data tables only one column"() {
        given:
            Person person = new Person()
        when:
            person.setName(name)
        then:
            person.getName() == name
        where:
            name     | _
            "janusz" | _
            "marian" | _
    }

    def "Without Unrolling"() {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == expectedResult
        where:
            number | numberToAdd || expectedResult
            0      | 0           || 0
            10     | 20          || 10
            10     | 20          || 40
    }

    @Unroll
    def "Unrolling"() {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == expectedResult
        where:
            number | numberToAdd || expectedResult
            0      | 0           || 0
            10     | 20          || 10
            10     | 20          || 40
    }

    @Unroll("Add #number to #numberToAdd and return #expectedResult")
    Should "add two numbers"() {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == expectedResult
        where:
            number | numberToAdd || expectedResult
            0      | 0           || 0
            10     | 20          || 10
            10     | 20          || 40
    }

    @Unroll("Add #number to #numberToAdd and return #expectedResult")
    Should "add two numbers - Data pipes"() {
        when:
            def result = calculator.add(number, numberToAdd)
        then:
            result == expectedResult
        where:
            number << [0, 10, 10]
            numberToAdd << [0, 20, 30]
            expectedResult << [0, 30, 40]
    }

}

class EnterpriseCalculator {

    int add(int number, int numberToAdd) {
        number + numberToAdd
    }

}

class Person {
    String name
}
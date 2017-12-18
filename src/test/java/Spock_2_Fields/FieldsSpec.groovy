package Spock_2_Fields

import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDateTime


class FieldsSpec extends Specification {

    def notInSetup = LocalDateTime.now()
    def inSetup

    @Shared
    def inSetupSpec

    @Shared
    def sharedVariable = LocalDateTime.now()

    def setup() {
        inSetup = LocalDateTime.now()
    }

    def setupSpec() {
        inSetupSpec = LocalDateTime.now()
    }

    def "First feature" () {
        println "NotIntSetup:" + notInSetup + System.lineSeparator()
        println "InSetup:" + inSetup + System.lineSeparator()
        println "Shared:" + sharedVariable + System.lineSeparator()
        println "SetupSpec:" + inSetupSpec + System.lineSeparator()
        expect:
            true
    }

    def "Second feature" () {
        println "NotIntSetup:" + notInSetup + System.lineSeparator()
        println "InSetup:" + inSetup + System.lineSeparator()
        println "Shared:" + sharedVariable + System.lineSeparator()
        println "SetupSpec:" + inSetupSpec + System.lineSeparator()
        expect:
            true
    }

}
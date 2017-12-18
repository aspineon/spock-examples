package Spock_3_Fixture_Methods

import spock.lang.Specification

//Are optional

class FixtureMethodsSpec extends Specification {

    def setup() {}          // run before every feature method
    def cleanup() {}        // run after every feature method
    def setupSpec() {}     // run before the first feature method
    def cleanupSpec() {}   // run after the last feature method

}
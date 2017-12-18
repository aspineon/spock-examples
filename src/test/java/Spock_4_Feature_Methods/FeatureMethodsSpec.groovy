package Spock_4_Feature_Methods

import spock.lang.Specification
import java.lang.Void as Should


/**
 * Feature method example
 * Test means features in specification meaning
 *
 */
class FeatureMethodsSpec extends Specification {

    //Describe features
    //Very good names

    def "This is a feature method" () {
        // some logic here
    }

    void "This is a feature method with void" () {
        // some logic here
    }

    Void "This is a feature method with object void" () {
        // some logic here
    }

    Should "This is a feature method with should" () {
        // some logic here
    }

}
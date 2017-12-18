package Spock_9_Extensions

import spock.util.environment.OperatingSystem
import spock.lang.IgnoreIf
import spock.lang.Specification

/**
 * IgnoreIf example
 */
class IgnoreIfSpec extends Specification {

    @IgnoreIf({ OperatingSystem.getCurrent().isLinux()})
    def "This test will be ignored on Linux" () {
        expect:
            println "Windows"
    }

    @IgnoreIf({ OperatingSystem.getCurrent().isWindows()})
    def "This test will be ignored on Windows" () {
        expect:
            println "Linux"
    }

}
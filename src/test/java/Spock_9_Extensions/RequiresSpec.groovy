package Spock_9_Extensions

import spock.lang.Requires
import spock.lang.Specification
import spock.util.environment.OperatingSystem

/**
 * Requires example
 */
class RequiresSpec extends Specification {

    @Requires({ OperatingSystem.getCurrent().isWindows() })
    def "Test on windows" () {

    }

}
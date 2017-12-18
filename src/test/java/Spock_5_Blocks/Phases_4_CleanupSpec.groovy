package Spock_5_Blocks

import spock.lang.Specification


class Phases_4_CleanupSpec extends Specification {

    def "Cleanup example" () {
        given:
            def file = new File("path")
        when:
            def result = file.createNewFile()
        then:
            result
        cleanup:
            file.delete()
    }

}
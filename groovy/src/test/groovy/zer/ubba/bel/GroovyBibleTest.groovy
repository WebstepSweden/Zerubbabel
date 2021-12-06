package zer.ubba.bel

import spock.lang.Shared
import spock.lang.Specification

class GroovyBibleTest extends Specification {
    @Shared
    def bibleDictionary = new GroovyBible().readTheBible()

    def "The Bible should contain many different words"() {
        expect:
        bibleDictionary.size() == 9582
    }

    def "God should appear a lot of times"() {
        expect:
        bibleDictionary["god"] == 2302
    }

    def "Jesus should be there too"() {
        expect:
        bibleDictionary["jesus"] == 777
    }

    def "There's more love than hate in the bible"() {
        when:
        def love = bibleDictionary["love"]
        def hate = bibleDictionary["hate"]

        then:
        love > hate
    }

    def "There's more sheep than goats in the bible"() {
        when:
        def sheep = bibleDictionary["sheep"]
        def goats = bibleDictionary["goats"]

        then:
        sheep > goats
    }

    def "Boring words should be removed"() {
        expect:
        bibleDictionary["the"] == null
        bibleDictionary["and"] == null
        bibleDictionary["of"] == null
    }

    def "Oh, and there should be a guy named Zerubbabel"() {
        expect:
        bibleDictionary["zerubbabel"] == 11
    }
}

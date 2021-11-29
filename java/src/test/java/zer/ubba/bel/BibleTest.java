package zer.ubba.bel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BibleTest {

    private static Map<String, Long> bibleDictionary;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        bibleDictionary = new Bible().readTheBible();
    }

    @Test
    void theBibleShouldContainManyDifferentWords() {
        assertEquals(bibleDictionary.size(), 9582);
    }

    @Test
    void godShouldAppearALotOfTimes() {
        assertEquals(bibleDictionary.get("god"), 2303);
    }

    @Test
    void jesusShouldBeThereToo() {
        assertEquals(bibleDictionary.get("jesus"), 777);
    }

    @Test
    void theresMoreLoveThanHateInTheBible() {
        final Long love = bibleDictionary.get("love");
        final Long hate = bibleDictionary.get("hate");
        assertTrue(love > hate);
    }

    @Test
    void theresMoreSheepThanGoatsInTheBible() {
        final Long sheep = bibleDictionary.get("sheep");
        final Long goats = bibleDictionary.get("goats");
        assertTrue(sheep > goats);
    }

    @Test
    void boringWordsShouldBeRemoved() {
        assert (!bibleDictionary.containsKey("the"));
        assert (!bibleDictionary.containsKey("and"));
        assert (!bibleDictionary.containsKey("of"));
    }

    @Test
    void ohAndThereShouldBeAGuyNamedZerubbabel() {
        assertEquals(bibleDictionary.get("zerubbabel"), 11);
    }
}
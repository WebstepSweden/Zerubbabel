package zer.ubba.bel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JavaBibleTest {

    private static Map<String, Long> bibleDictionary;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        bibleDictionary = new JavaBible().readTheBible();
    }

    @Test
    void theBibleShouldContainManyDifferentWords() {
        assertEquals(9582, bibleDictionary.size());
    }

    @Test
    void godShouldAppearALotOfTimes() {
        assertEquals(2303, bibleDictionary.get("god"));
    }

    @Test
    void jesusShouldBeThereToo() {
        assertEquals(777, bibleDictionary.get("jesus"));
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
        assertEquals(11, bibleDictionary.get("zerubbabel"));
    }
}
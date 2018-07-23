import io.kotlintest.matchers.numerics.shouldBeGreaterThan
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import se.webstep.bible.readTheBible

class SimpleTrollNumberTest : StringSpec({

    val bibleDictionary = readTheBible();

    "The Bible should contain many different words" {
        bibleDictionary.size shouldBe 9582
    }

    "God should appear a lot of times" {
        bibleDictionary["god"] shouldBe 2303
    }

    "Jesus should be there too" {
        bibleDictionary["jesus"] shouldBe 777
    }

    "There's more love than hate in the bible" {
        val love = bibleDictionary["love"]!!
        val hate = bibleDictionary["hate"]!!
        love.shouldBeGreaterThan(hate)
    }

    "There's more sheep than goats in the bible" {
        val sheep = bibleDictionary["sheep"]!!
        val goat = bibleDictionary["goat"]!!
        sheep.shouldBeGreaterThan(goat)
    }

    "Boring words should be removed" {
        bibleDictionary["the"] shouldBe null
        bibleDictionary["and"] shouldBe null
        bibleDictionary["of"] shouldBe null
    }

    "Oh, and there should be a guy named Zerubbabel" {
        bibleDictionary["zerubbabel"] shouldBe 11
    }
})
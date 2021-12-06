import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers.{be, contain}
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import zer.ubba.bel.ScalaBible


class ScalaBibleTest extends AnyFunSuite {

  private val bibleDictionary = new ScalaBible().readTheBible();

  test("The Bible should contain many different words") {
    bibleDictionary.size shouldBe 9582
  }

  test("God should appear a lot of times") {
    bibleDictionary("god") shouldBe 2303
  }

  test("Jesus should be there too") {
    bibleDictionary("jesus") shouldBe 777
  }

  test("There's more love than hate in the bible") {
    val love = bibleDictionary("love")
    val hate = bibleDictionary("hate")
    love should be > hate
  }

  test("There's more sheep than goats in the bible") {
    val sheep = bibleDictionary("sheep")
    val goats = bibleDictionary("goats")
    sheep should be > goats
  }

  test("Boring words should be removed") {
    bibleDictionary shouldNot contain("the", "and", "of")
  }

  test("Oh, and there should be a guy named Zerubbabel") {
    bibleDictionary("zerubbabel") shouldBe 11
  }
}

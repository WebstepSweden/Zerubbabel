import org.scalatest.funsuite.AnyFunSuite
import zer.ubba.bel.ScalaBible

class ScalaBibleTest extends AnyFunSuite {

  private val bibleDictionary = new ScalaBible().readTheBible();

  test("The Bible should contain many different words") {
    assert(bibleDictionary.size == 9582)
  }

  test("God should appear a lot of times") {
    assert(bibleDictionary("god") == 2303)
  }

  test("Jesus should be there too") {
    assert(bibleDictionary("jesus") == 777)
  }

  test("There's more love than hate in the bible") {
    val love = bibleDictionary("love")
    val hate = bibleDictionary("hate")
    assert(love > hate)
  }

  test("There's more sheep than goats in the bible") {
    val sheep = bibleDictionary("sheep")
    val goats = bibleDictionary("goats")
    assert(sheep > goats)
  }

  test("Boring words should be removed") {
    assert(!bibleDictionary.contains("the"))
    assert(!bibleDictionary.contains("and"))
    assert(!bibleDictionary.contains("of"))
  }

  test("Oh, and there should be a guy named Zerubbabel") {
    assert(bibleDictionary("zerubbabel") == 11)
  }
}

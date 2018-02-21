import org.scalatest.{FlatSpec, Matchers}

class CalculatorSpec extends FlatSpec with Matchers {
  import Calculator.calculate

  "calculator" should "take in '3-2' and return 1" in {
    val output = calculate("3-2")
    assert(output == 1)
  }

  it should "take 3 + 1 and return 4" in {
    val output = calculate("3 + 1")
    assert(output == 4)
  }

  it should "take 3 * 10 and return 30" in {
    val output = calculate("3 * 10")
    assert(output == 30)
  }

  it should "take 20 / 4 and return 5" in {
    val output = calculate("20 / 4")
    assert(output == 5)
  }

  it should "throw an exception if passed a letter" in {
    assertThrows[Exception] {
      calculate("apple")
    }
  }
}

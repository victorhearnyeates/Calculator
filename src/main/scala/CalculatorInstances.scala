import scala.util.matching.Regex

object CalculatorInstances {

  implicit val stringCalculator: Calculator[String] = new Calculator[String] {
    private def operationPattern(op: String): Regex = s"(.*)$op(.*)".r

    private val bracketsPattern: Regex = ".*\\((.*)\\).*".r
    private val dividePattern: Regex = operationPattern("/")
    private val multiplyPattern: Regex = operationPattern("\\*")
    private val additionPattern: Regex = operationPattern("\\+")
    private val subtractionPattern: Regex = operationPattern("-")
    private val numberPattern: Regex = "(\\d+)".r

    //todo: Fix brackets pattern
    private def loop(input: String): BigDecimal = input match {
      case bracketsPattern(inBrackets) => loop(inBrackets)
      case dividePattern(left, right) => loop(left) / loop(right)
      case multiplyPattern(left, right) => loop(left) * loop(right)
      case additionPattern(left, right) => loop(left) + loop(right)
      case subtractionPattern(left, right) => loop(left) - loop(right)
      case numberPattern(num) => BigDecimal(num)
      case other => throw new Exception(s"$other is not valid")
    }

    def calculate(input: String): BigDecimal = loop(input.replaceAll(" ", ""))
  }
}

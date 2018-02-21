import scala.util.matching.Regex

/**
  * Created by victorhearnyeates on 04/12/2017.
  */
object Calculator {

  val bracketsPattern: Regex = ".*\\((.*)\\).*".r
  def operationPattern(op: String): Regex = s"(.*)$op(.*)".r
  val dividePattern: Regex = operationPattern("/")
  val multiplyPattern: Regex = operationPattern("\\*")
  val additionPattern: Regex = operationPattern("\\+")
  val subtractionPattern: Regex = operationPattern("-")
  val numberPattern: Regex = "(\\d+)".r

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

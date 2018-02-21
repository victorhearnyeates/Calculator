/**
  * Created by victorhearnyeates on 04/12/2017.
  */
trait Calculator[A] {

  def calculate(input: A): BigDecimal

}

object Calculator {
  def calculate[A](input: A)(implicit calculator: Calculator[A]): BigDecimal = {
    calculator.calculate(input)
  }
}

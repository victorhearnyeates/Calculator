object CalculatorSyntax {

  implicit class CalculatorOps[A](input: A) {
    def calculate(implicit calculator: Calculator[A]): BigDecimal = calculator.calculate(input)
  }
}

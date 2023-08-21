object q01 extends App {
  class Rational(nume: Int, deno: Int) {
    if (deno == 0) {
      println("Denominator is equal to zero")
    }

    val num1: Int = nume
    val num2: Int = if (deno != 0) deno else 1

    def neg(): Rational = new Rational(-num1, num2)

    def display(): String = {
      if (num2 != 1) {
        s"$num1/$num2"
      } else {
        num1.toString
      }
    }
  }

  var x = new Rational(4, 5)
  var y = x.neg()
  println(y.display())
}

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

    def sub(that: Rational): Rational = {
      val newNume = num1 * that.num2 - that.num1 * num2
      val newDeno = num2 * that.num2
      new Rational(newNume, newDeno)
    }
  }

  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  val result = x.neg().sub(y).sub(z)
  println(result.display())
}

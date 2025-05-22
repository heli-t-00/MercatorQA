import org.scalatest.flatspec.AnyFlatSpec

import scala.language.postfixOps

class CalculatorSpec extends AnyFlatSpec{

  // first need to access a Class - keyword new to access it again and again

  val calc = new Calculator // make a new object of our Class so that we can access all the methods within it.

  "add" should "add two Int's together" in{
    val input = calc.add(1,2)
    val expectedResult = 3 // 1+3 (breaking it down so you know what is expected)
    assert(input == expectedResult) // asset(calc.add(1,2) ==3 - this is the shorthand that is the same as the val

  }

  "multiply" should "multiply two Int's together" in {
    val input = calc.multiply(1,3)
    val expectedResult = 3
    assert(input == expectedResult)
  }

 "subtract" should "subtract x from y" in {
   val input = calc.subtract(10,5)
   val expectedResult = 5
   assert(input == expectedResult)

 }

  "divide" should "divide x from y" in {
 val input = calc.divide(6,3)
    val expectedResult = 2
    assert(input== expectedResult)

  }
}

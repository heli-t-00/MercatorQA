object MonCodeAlong extends App {
  //  VAL = BEST PRACTISE!!!
  val melons = 5 * 50
  val apples = 2 * 10
  val fizzyDrink = 6 * (100 * 1.20)
  //  val total = melons + apples + fizzyDrink

  //  VAR - mutable (not best practise)
  var total: Double = 0
  (total = total + apples)
  println(total)
  (total = total + melons)
  println(total)
  (total = total + fizzyDrink)
  println(total)

  println(total + melons)
  println(melons)
  println(apples)
  println(fizzyDrink)
  println(total)

  //TYPES
  val wholeNumber: Int = 5400
  val littleNumber: Short = 60 //RARE - Just use INT
  val bigNumber: Long = 589209432492432L //MUST PUT 'L' at the end
  val littleDecimal: Float = 2.345643553f //MUST PUT 'f' at the end
  val decimal: Double = 464664499.49343 //  USE THIS ONE
  val text: String = "Hello world!!"
  val trueFalse: Boolean = true // false
  val falseTrue: Boolean = true

  println(trueFalse == falseTrue)


  //OPERATORS - Arithmetic
  val a: Int = 10
  val b: Int = 5
  val c: Int = 3

  val add: Int = a + b
  val subtract: Int = a - b
  val divide: Double = a / b
  val multiply: Int = a * b
  val modulus: Int = a % c // 10%3 (what is the remainder)
  println(modulus)

  val even: Int = a % 2 //left with 0 = even
  println(even)

  // RELATIONAL OPERATORS
  val equality: Boolean = a == a // true / false
  val inequality: Boolean = a != b // NOT EQUAL TO
  val lessThan: Boolean = b < c
  val lessThanEqualTo: Boolean = b <= c
  val greaterThan: Boolean = b > c
  val greaterThanEqualsTo: Boolean = b >= c

  println(greaterThanEqualsTo)

  //LOGICAL OPERATORS
  //AND (&&) both must be true
  // OR (||) one must be true
  // NOT (!) takes a single

  val and: Boolean = true && true // BOTH must be true to RETURN True, if one is false then it would be
  val or: Boolean = true || false // EITHER side can be true to return true
  val not: Boolean = !false

  //METHODS

  def makeACupOfTea(sugar: Int, milk: Boolean): String = {
    s"You have made a cup of tea with with $sugar spoons of sugar. Your milk selection is: $milk"
  }

  println(makeACupOfTea(7, milk = true))
  println(makeACupOfTea(2, milk = false))


  val vat: Double = 1.2 //function - can't pass in parameters

  // Write me a method that calculates the final price of a product with VAT.
  def priceWithVAT(price: Double): Double = {
    price * vat
  }

  println(priceWithVAT(10.0))

  //CLASSES (think of this like a type)
  // This is my instructions to make future dogs - this does not mean anything on it's own
  class Dog (val name: String, val age: Int, val likesBananas: Boolean) {
    def speak: String = "woof" // declared in advance as it is the same for EVERY dog

  }
  //Use the class to make objects (e.g Dog)
  // Object of type Dog
  val loki: Dog =new Dog("Loki", 5, true)
  // How do I access this?

  println(loki.speak)
  println(loki.name)
  println(loki.age)


}


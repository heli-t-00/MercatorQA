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
 //................................................................................
//AFTERNOON TASK:  19 MAY 2025 STORING VALUES, TYPES AND OPERATORS
  //--------------------------------------------------------------------------------
//  MVP - Qn1 - Before coding, decide if the answer will be true or false. Then store the values in a function that can be printed
  // and use operators evaluate the following:
  // Three plus four, times fifty-seven is less than three-hundred
  val resultA: Boolean = (3+4) *57 < 300
 println(resultA) // OUTPUT: False
//One-hundred and forty four divided by 12 is greater than twelve or equal to twelve
  val resultB: Boolean =(144/12)>=12
  println(resultB) //OUTPUT: True
//cat is less than dog (strings)
  val word1: String ="cat"
  val word2: String = "dog"
  val resultC: Boolean = word1<word2
  println(resultC) //OUTPUT: True
//rabbit is less than hamster (strings)
  val word3: String="rabbit"
  val word4: String="Hamster"
  val resultD: Boolean = word3<word4 // OUTPUT: False
  println(resultD)
// seventeen is odd (modulus)
  val resultE: Boolean = 17 % 2 != 0
  println(resultE) // OUTPUT: True
//seventy five divided by nine is less than thirty AND eighty-nine divided by siz is less than twenty
  val resultF: Boolean = (75/9<30) && (89/6 <20)
  println(resultF) // OUTPUT: True

 //Qn 2 - What is the difference between the 'String' "I love scala already" and print line ("I love scala already")?
 // Ans - The String "I love scala already" is a string value and not displayed until it has been called/used and the
  // println is printed to the terminal/console, but is not meaningful, the val is meaningful as it stores the data.

 //Qn 3- Write a method to calculate the square of an Int. It should have an 'Int' input parameter and 'Int' return type
//NOTES - square of a number is number multiplied by itself.

  def square(n: Int): Int = {n * n} //define a function that takes a number and returns the square
  val n: Int = 4 //define a value n and set it to 4
  println(square(n)) // this calls the square method (square(n) calls the function with number 4 OUTPUT

  println(square(9)) // methods can be called without creating new VAL replace n with Int in the println

  //Qn 4 - write a method to check if a number is odd. it should have Int input parameter and Boolean return type
  def isOdd(num: Int): Boolean ={
    n % 2 !=0

  }
  val num=5
  println(isOdd(n)) // False
  println(isOdd(3)) // True - method is called isOdd(n)
  println(isOdd(30)) // False
  println(isOdd(49)) // True

// Qn 5 - Consider a Library, there are many books. Write a Class called ‘Book’. What class parameters
  //will your book need? Can you include any class methods in the body? Can you consider type
  // Class parameters: title (String), author (String), yearPublished (Int), uniqueId (Int), isAvail (Boolean)

  class Book( val title: String, val author: String, val yearPub: Int, val uniqueId: Int, val isAvail: Boolean)
  val book1 = new Book("pride & prejudice", "jane austen", 1813, 8492891, true)

  println(book1.title)
  println(book1.author)
  println(book1.yearPub)
  println(book1.uniqueId)
  println(book1.isAvail)

  //Method to display book info
  def displayInfo(): Unit ={
    println(book1.title)
    println(book1.author)
    println(book1.isAvail)
  }

  //------------------------------------------------------------------------------
  //EXTENSION
  //Qn - Convert a lowercase 'String' to uppercase
  //Use build method " .toUpperCase "

  val lowerCase = "String"
  val upperCase = lowerCase.toUpperCase()
  println(upperCase) // Output: STRING

  //Qn2 - Convert the first letter of a 'String' to uppercase
val stringCap = "string"
  val capitaliseString = stringCap.capitalize
  println(capitaliseString) //Output: String

  println(stringCap.toLowerCase()) // Output: string (first letter of word is Lower case



  //Qn3 - "STRING" == "string" Is this true or false? Why?
  val str1 ="STRING"
  val str2="string"
  println(str1 == str2) //Output: false
  // String comparison with "==" in Scala is case-sensitive by dafault.
  // The characters don't match therefore are NOT EQUAL (cases are different).
  println(str1.equalsIgnoreCase(str2)) // using " .equalsIgnoreCase " will ignore the case and will OUTPUT True

  //Qn4 - can you convert the 'String' "one" to the 'Int' 1? -CONVERT NUMERIC String into an Int????



  //Qn5 - Can you convert the Int '1' to String "one'?

  //Qn 6 - Convert 'Int' 1 to type 'String' is the results as expected?



}


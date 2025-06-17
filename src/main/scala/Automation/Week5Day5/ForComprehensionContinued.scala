package Automation.Week5Day5

import Automation.Week5Day5.ForComprehensionContinued.num1

object ForComprehensionContinued extends App {
  /**
   * This is a clean and readable way to work with collections - lists/options, it lets you chain operations like map, flatMap and filter in a readable way.
   */

  //EXAMPLE - list of numbers - multiple only the EVEN ones by 2 - NOT using For Comprehension
  val numbers = List(1,2,3,4,5,6) // creates a list of integers and stores in variable numbers
  val result = numbers
    .filter( n => n % 2 == 0) //  .filter(...) this filters the list to KEEP even numbers only
    /* n => n % 2 == 0 is a function that says: take n check if it divides by 2 with NO remainders (ie. is even) then apply it to the List
    */
    .map (n => n*2) // .map(...) transforms each element in the list and multiply by 2
  /* n=> n *2 take each n and multiply by 2 */
  println("Example not using FOR Comprehsion" + result) // OUTPUT: List (4,8,12)


  // EXAMPLE - For Comprehension

  val numbers1 = List(1,2,3,4,5,6)

  val result2 = for {
    n <- numbers1 // Loop through each number
    if n % 2 == 0    // Only keep EVEN numbers
  } yield n*2  // Multiply each number by 2 ( 'yield' keyword collects the results of each loop iteration into a new collection. ie. List Option)
 println("Example FOR Comprehension" + result2) // OUTPUT: List(4,8,12)

  // For-Comprehensions work with more than one Collection, therefore can combine multiple collections to create combinations or nested iterations.
//EXAMPLE - Multi List - FOR Comprehension
  // Create two lists
  val list1 = List(1, 2)
  val list2 = List("a","b")
  // Can create pairs of every element from list1 with every element from list2:

  val listResult = for {
    x <-list1 // loop through each element in list1
    y <-list2 // for each x, loop through all elements in list2
    } yield (x,y) // return the pair of (x,y) for each combination

  println("Example Multi List & For Comp.: " + listResult)
  //OUTPUT: List((1,a), (1,b), (2,a), (2,b))

// Example - add filter
  val listFilteredResult = for {
    x <-list1
    y <- list2
    if x==2
    if y =="b"
  } yield (x,y)

  println("Example add filter - multi list - for Comp: " + listFilteredResult)
  // OUTPUT: List((2,b))

  //EQUIVALENT USING .flatMap and .map ( reduces the length of the code writen

  val listResult1 = list1.flatMap((x => list2.map(y=>(x,y))))
 // this code is the same as val listResult (ln36)
  println("Example using .flatMap and .map: " + listResult1)
  //OUTPUT: List((1,a), (1,b), (2,a), (2,b))

  // .map is used to transform each element into collection

  val nums = List(1,2,3,4)
  val doubled = nums.map (n=> n*2) // map(n => n*2) for each n in list, multiply by 2
  println("Example .map" +doubled) // OUTPUT: List(2,4,6,8)

  // .mkString used to join elements of a collection into a single string

  val fruits = List ("apple", "banana", "cherry")
  val fruitResult = fruits.mkString(", ") // mkString(", ") joins the list items into a string, with ',' in between
  println("Eg. mkString: " + fruitResult) // OUTPUT: apple, banana, cherry

//COMBINE .map and .mkString EXAMPLE
  val names = List ("alpha", "betty", "charlee", "dandan")
  val namesResult = names
    .map(name=> name) // Capitalise each name
    .mkString(("    ")) // Join with " & "

  println("Combined .map and .mkString " + namesResult) //OUTPUT: Alpha & Betty & Charlee & Dandan


  // COMBINE .map and .mkString EXAMPLE - with numbers
  val numbersList = List(1, 2, 3, 4)

  val resultList = numbersList
    .map(n => s"[$n]")           // Wrap each number in brackets
    .mkString(" - ")             // Join with " - "

  println("Example combine .map .mkString -Numbers:" + resultList) // Output: [1] - [2] - [3] - [4]


  val words = List("scala", "is", "fun")
val wordsResult = words
  .map(_.capitalize) // _ is a shorthand for "each item in the list" SAME as word =>word.capitalize
  .mkString(" ")
  println("Eg. words: " +wordsResult) // OUTPUT: Scala Is Fun


  // Used in for-Comprehension '<-' which means "take from" OR "loop over" used to extract elements from a collection in a for-Comp
  // => used in .map functions means "becomes" OR "define logic"


  // EXAMPLES
  val num1 = List(1, 2, 3, 4, 5)

  val resultNum1 = for {
    number <- num1           // loop through each number
    if number % 2 == 1          // filter odd numbers
  } yield number * 3            // multiply by 3

  println(resultNum1) // Output: List(3, 9, 15)


//SAME LOGIC using .filter and .map
val resultNum2 = num1
  .filter(n=> n % 2 == 1)
  .map(n=> n*3)
println(resultNum2) // OUTPUT: List(3,9,15)

  //KEY LEARNINGS:
  // Looping  USE n <- numbers
  // Filtering USE 'if n % 2 == 1' (for ODD numbers) 'if n % 2 == 0' (for EVEN numbers)
  // Mapping USE 'n => n * 3'  or 'yield n * 3'
  // Result Formating USE .mkString(", ") if you want a string




}
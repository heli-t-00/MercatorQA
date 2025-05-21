object TuesCodeAlongCollection extends App {
  //SET - Collections
  val firstSet: Set[Int] = Set(1, 2, 3, 4, 5, 5)
  println("first set: " + firstSet) //OUTPUT: HashSet(5,1,2,3,4) - defaulted to Hashset // NOT ORDERED, does not allow Duplicates, auto strip out Repeated numbers
  val firstSeq: Seq[Int] = Seq(1, 2, 3, 4, 5, 5)
  println("first seq: " + firstSeq) //OUTPUT: List(1,2,3,4,5) - defaulted to List // ORDERED, allows duplicates, values that are repeated
// Seq is an ORDERED collection that can contain duplicates

  // MAP - Collections
  // Maps take 2 parameters ("Key" -> Value). We call these Key Value pairs. Key must be unique (we cannot have two keys the same, values can be SAME but Keys are Unique)

  val firstMap: Map[String, Int] = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "five" -> 5 // Duplicates will be removed when compiled - no error thrown

  )
  println("firstMap: " + firstMap)

  // ACCESSING DATA - Sequence
  val getSeqHead: Int = firstSeq.head //gives index position 0 (first element)
  println("Seq Head: " + getSeqHead) // OUTPUT: Seq Head: 1
  val getSeqTail: Seq[Int] = firstSeq.tail // gives everything but the head
  println("Seq Tail: " + getSeqTail) // OUTPUT: Seq Tail: List(2,3,4,5,5)

  val getSeqIndex: Int = firstSeq(3) // only works with ORDERED collections
  println("Seq Index: " + getSeqIndex) // OUTPUT: Seq Index: 4

  // SET Collections
  val getSetIndex: Boolean = firstSet(3) // check whether the value is CONTAINED in the Set (can also use " .contains(3)")
  println("Exist in Set: " + getSetIndex)
  // often filter for INFO rather than Grabbing a specific value.
  val filterSet: Set[Int] = firstSet.filter(_ < 3) // return a filterset anything UNDER 3
  println("filter set" + filterSet)

  val filterNotSet: Set[Int] = firstSet.filterNot(_ < 3)
  println("filter Not set" + filterNotSet)

  val evenSet: Set[Int] = firstSet.filter(_ % 2 == 0)
  //val evenSet: Set[Int] = firstSet.filterNot(_% 2 != 0) // is the same as the above
  println("even set: " + evenSet)

  // MAP - accessing data
  // easier to grab value than key
  // USE Key to get Value - only useful if you know the Key
  val getMapValue: Int = firstMap("one") // Enter Key to get the value, only works when key is known.
  println("get map value: " + getMapValue)
  val getMapKey: String = firstMap.find(_._2 == 1).get._1 //find the value that is equal to 1 and get the key that matches it.
  println("get map key:" + getMapKey)

  val filterMap: Map[String, Int] = firstMap.filter(Num => Num._2 == 3)

  //TASK 1 ---------------------------------------------------------
  //1. Create a sequence of names
  val alphaSeq: Seq[String] = Seq("a", "b", "c", "d", "e", "f")
  println("task1:" + alphaSeq) // OUTPUT: List(a,b,c,d,e,f)

  //2. Create a Map of 1 -"red", 2 ' -"yellow", 3 - "blue", 4 - "green', 5 - "pink"

  val mapColour: Map[Int, String] = Map(
    1 -> "red", 2 -> "yellow", 3 -> "blue", 4 -> "green", 5 -> "pink"
  )
  println("Map Colour: " + mapColour) // OUTPUT: Map Colour: HashMap(5 -> pink, 1 -> red, 2 -> yellow, 3 -> blue, 4 -> green)
  // Filter this map by color BLUE
  val onlyBlue = mapColour.filter { case (key, value) => value == "blue" } // .filter goes through each (key, value) pair in the map
  // case (key, value) - works through boy the key and value
  // value == "blue" - filter for blue
  println("Filtered for blue: " + onlyBlue) // OUTPUT: Filtered for blue: HashMap(3 -> blue)

  // MORE examples:
  val filteredForBlue: Map[Int, String] = mapColour.filter(num => num._1 == 3)
  println("filtered for Blue: " + filteredForBlue) //
  val filteredForBlueV2: Map[Int, String] = mapColour.filter(num => num._2 == "blue")
  println("filtered for Blue v2: " + filteredForBlueV2)

  //4. Add 1 to all numbers in a collection of Ints
  val randomNum: Set[Int] = Set(11, 22, 33, 44, 55)
  //5. Return true if a Seq has a String that contains the letter "r"
  val words: Seq[String] = Seq("apple", "orange", "banana", "kiwi", "watermelon")

  println("addOne:" + addOne(randomNum))
  val containsR: Boolean = words.exists(_.contains("r")) // words.exisits(....) returns true if ANY element in the sequence satisfies this condition
  //More examples
  val names = Seq("Alice", "Robert", "Carol", "David")
  println("Contains 'r': " + containsR) // OUTPUT: true // as this is a Boolean - it goes though the sequence and check if anything on the list has 'r'
  // .contains("r") return true if "r" is found in the string
  // words.exists (_.contains("r")) = Go through each word in words and check if that word contains the letter 'r' Return true if at least one does.
  val containsLetterU: Boolean = names.exists(name => name.contains("u"))
  //6. Remove all EVEN numbers from a Set of Ints.
  val numbers: Set[Int] = Set(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println("Contains 'u': " + containsLetterU) // OUTPUT: false
  val oddNumbers: Set[Int] = numbers.filter(n => n % 2 != 0)
  //More examples
  val oddNumbersOnly = firstSet.filter {
    number => number % 2 != 0
  } // This removes all even numbers from firstSet, keeping only the odd numbers, and stores the result in oddNumbersOnly
  // .filter(n=>n %2!=0) Keeps only the ODD Numbers. % is the modulo operator (remainder) n%2!=0 means the number is not divisible by 2 therefore this is ODD
  //filter returns a new Set[Int] with only the elements that meet the condition.
  println("Remove Odd Numbers only: " + oddNumbers) // OUTPUT
  //EXTENSION Task
  //flatMap is another cool method we can call on collections. Research what is does and when it could be useful. Write an example.
  val flatMapNames: Seq[Char] = names.flatMap(_.toUpperCase)
  // CAN BE WRITTEN IN OTHER WAYS ( != or == )
  // .filter(number => number % 2 != 0 // keep ODD numbers
  // .filterNot(number => number % 2 == 0 // remove EVEN numbers
  // filter(_%2!=0) is the same as filter(number=>number % 2 !=0
  // This code take a sequence of strings called names, converts each string to uppercase, then flattens all the characters into a single sequence of characters.
  val names1 = Seq("alice", "ben", "caro")
  println("FlatMap: " + flatMapNames) //OUTPUT: FlatMap: List(A, L, I, C, E, R, O, B, E, R, T, C, A, R, O, L, D, A, V, I, D)
  val flatMap: Seq[Char] = names1.flatMap(_.toUpperCase) // for each string in names1 convert to UpperCase - THEN flatten each result string into its characters.
  //map(...) (This is a method - lowercase 'm') used to transform elements in a collection
  // use 'map' to iterate or move through a collection (seq, set, Map).
  // map(lowercase) apply to a function to every element in a collection
  val example = Seq(1, 2, 3).map(_ * 2)
  //flapMap combines them into one Seq[Char]
  println("Flat map eg:" + flatMap) // OUTPUT: Flat map eg:List(A, L, I, C, E, B, E, N, C, A, R, O)
  // _.toUpperCase // converts each string to uppercase: "alice" -> "ALICE"
  // flatMap(...) applies a function to each element and flattens the results


  // -------------------------------------------------------------------------
  // Map (Collection - Capitalised 'M') - Map collection, like a dictionary or key-value store.
  // Map (uppercase) = a specific type of collection (key-value pairs)
  val example2Map = Map("a" -> 1, "b" -> 2, "c" -> 3)
  println("example map: " + example) // example map: List(2, 4, 6)
  val newSeq: Seq[Int] = Seq(6, 7, 8)

  //write them as a method, makes it our methods more universal, parse in the methods
  // Instead of hardcoding logic inline, WRITE reusable methods, then can pass collections into them and apply transformation using map

  //EXAMPLE of Universal Function Using map method:
  //map is used inside the method, that can be reused in any Set[Int] - making it universal
  // Append - add to the end
  val appendedListOne = firstSeq :+ newSeq
  //Further example:
  // def tripleSet(inputSet: Set[Int]): Set[Int] = inputSet.map(_ * 3)
  // _ * 3 //use underscore if you don't care about the value
  println("tripled Set:" + tripleSet(firstSet)) // OUTPUT: tripled Set:HashSet(6, 9, 12, 3, 15)
  val appendedListTwo = firstSeq ++ newSeq

  println("tripled Seq:" + tripleSeq(firstSeq)) // OUTPUT: tripled Seq:List(3, 6, 9, 12, 15, 15)
  // Prepend
  val prependSeqOne = newSeq ++ firstSeq

  println("triple Map:" + tripleMap(firstMap)) // OUTPUT: triple Map:HashMap(two -> 6, five -> 15, one -> 3, four -> 12, three -> 9)

  //OTHER methods
  // .exists This is a method on COLLECTIONS - Returns Boolean: true/false
  // .exists -checks "does at least one element in  the collection satisfy a condition?"
  // .contains - This is a method on a string - Returns Boolean
  // .contains -checks "Does this string contains the letter ' '?"


  //val flatMapNames = Seq[Char] = names.flatMap(_.toUpperCase)
  //  println("Flat Map:" + flatMapNames)
  val prependSeqTwo = newSeq :+ firstSeq
  val prependValue = 6 +: firstSeq
  println("Append :+" + appendedListOne) // OUTPUT: Append :+List(1, 2, 3, 4, 5, 5, List(6, 7, 8))

  def addOne(inputSet: Set[Int]): Set[Int] = {
    inputSet.map(_ + 1)
  }
  println("Append++" + appendedListTwo) // OUTPUT: Append++List(1, 2, 3, 4, 5, 5, 6, 7, 8)

  def tripleSet(inputSet: Set[Int]): Set[Int] = inputSet.map {
    number => number * 3 // this is the same as above
  }
  println("prepend ++" + prependSeqOne) // OUTPUT: Append++List(1, 2, 3, 4, 5, 5, 6, 7, 8)

  def tripleSeq(inputSeq: Seq[Int]): Seq[Int] = inputSeq.map {
    // _ * 3 //use underscore if you don't care about the value
    number => number * 3 // this is the same as above
  }
  println("prepend :+" + prependSeqTwo) //OUTPUT: prepend :+List(6, 7, 8, List(1, 2, 3, 4, 5, 5))

  //Function defined as tripleMap, it takes one parameter inputMap, which is a Map with String keys and Int values
  // =inputMap.map{case (key, value) => (key, value * 3) // .map methods transforms each key-value pair in the map
  // case(key,value) pattern matches each paid in the map. (key,value *3) returns a new pair with the same key BUT value multiplied by 3
  def tripleMap(inputMap: Map[String, Int]): Map[String, Int] = inputMap.map {
    case (key, value) => (key, value * 3) // can also change key eg. key +"s"
  }
  println("Add value 6 to Sequence: " + prependValue) // OUTPUT: Add value 6 to Sequence: List(6, 1, 2, 3, 4, 5, 5)

  //====================================================================
  //MVP AFTERNOON TASK: Collections in Scala
  //Scenario: You are working as part of the development team for HMRC that are building a service that handle self-assessment tax returns
// Qn1. Create a 'Seq' of taxpayers forenames representing multiple submissions, including some duplicates. Store this'Seq' in a val
  val submission: Seq[String] = Seq("Alpha", "Betty","Alpha", "Charlie", "Delta", "Charlie","Charlie", "Betty")
  //Qn2. String interpolation, print the full list of submissions
  println("MVP2: " + submission) // OUTPUT: MVP1: List(Alpha, Betty, Alpha, Charlie, Delta, Charlie, Charlie, Betty) // this shows multiple submission that contains duplicates.
//Qn3. write a method that uses built-in method '.count' to identify how many times a specific taxplayer submitted their tax returns in the 'Seq' from QN1. this method should work for ANY inputted taxplayer.
  def countSubmissionNames(name: String): Int = {
    submission.count(submission => submission == name)
  }
 println("MVP3: "+ countSubmissionNames("Charlie")) //OUTPUT: 3 // this counts the submission for 'Charlie' only
//Qn4. print a sentence that states how many times a specific person submitted their tax returns using the method for qn3.

//Qn5. Using a built-in method (research will be required here), convert the `Seq` to a `Set` to
  //remove duplicates.



  //Qn6.Using string interpolation, print the list of unique taxpayers who submitted.



  //Qn7. Refactor your method from question 3 to work for any inputted collection (HINT: look
  //back at the collection family tree in the PowerPoint).

  //Qn8. Using your method from question 7, print the count of the same taxpayer in both the
  //`Seq` from question 1 and the `Set` from question 5.


  //Qn9. Imagine that the user of this service needs to login however there are 6 users that have
  //failed login attempts.
  //a. Write a Map[String, Int] to represent the number of failed attempts for each
  //user.
  //b. Print the number of failed attempts for the user at index position 0.
  //c. Add a new user to your Map who has 3 failed attempts.
  //d. Update the user at index position 1 to have a further failed attempt.
  //e. Remove the user at index position 5.



}

object TuesCodeAlongCollection extends App {
  //SET - Collections
  val firstSet: Set[Int] = Set(1, 2, 3, 4, 5, 5)
  println("first set: " + firstSet) //OUTPUT: HashSet(5,1,2,3,4) - defaulted to Hashset // NOT ORDERED, does not allow Duplicates, auto strip out Repeated numbers
  val firstSeq: Seq[Int] = Seq(1, 2, 3, 4, 5, 5)
  println("first seq: " + firstSeq) //OUTPUT: List(1,2,3,4,5) - defaulted to List // ORDERED, allows duplicates, values that are repeated


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

  val filterMap: Map[String, Int] = firstMap.filter(Num=> Num._2==3)

  //TASK 1 ---------------------------------------------------------
  //1. Create a sequence of names
  val alphaSeq: Seq[String] = Seq("a", "b", "c", "d", "e", "f")
  println("task1:" + alphaSeq)

  //2. Create a Map of 1 -"red", 2 ' -"yellow", 3 - "blue", 4 - "green', filter map for blue

  val mapColour: Map[Int, String] = Map(


  )
  println("Map Colour: " + mapColour)

  //4.
  def addOne (inputSet: Set[Int]): Set[Int] = inputSet.map {
    _+1
  }
  println(addOne(firstSet))

// ---------------------------------------------
  //map (method - lowercase 'm') Map (Collection - Capitalised 'M')
  // use 'map' to iterate or move through a collection (seq, set, Map).

  //write them as a method, makes it our methods more universal, parse in the methods

  def tripleSet(inputSet: Set[Int]): Set[Int] = inputSet.map {
   // _ * 3 //use underscore if you don't care about the value
    number => number *3 // this is the same as above
  }
  println("tripled Set:" + tripleSet(firstSet))

  def tripleSeq(inputSeq: Seq[Int]): Seq[Int] = inputSeq.map {
    // _ * 3 //use underscore if you don't care about the value
    number => number *3 // this is the same as above
  }
  println("tripled Seq:" + tripleSeq(firstSeq))

  def tripleMap(inputMap: Map[String, Int]): Map [String, Int] =inputMap.map{
    case (key, value) => (key, value * 3) // can also change key eg. key +"s"


  }
  println("triple Map:"+ tripleMap(firstMap))

  //OTHER methods
  // .exists = all that could be (get a collection back)
  // .contains (check - true/false - boolean)


//val flatMapNames = Seq[Char] = names.flatMap(_.toUpperCase)
//  println("Flat Map:" + flatMapNames)

  val newSeq: Seq[Int] = Seq(6,7,8)

  // Append - add to the end
  val appendedListOne = firstSeq :+ newSeq
  println("Append :+" + appendedListOne)
  val appendedListTwo = firstSeq ++ newSeq
  println("Append++" + appendedListTwo)

  // Prepend
  val prependSeqOne = newSeq ++ firstSeq
  println("prepend ++" + prependSeqOne)


  val prependSeqTwo = newSeq :+ firstSeq
  println("prepend :+" + prependSeqTwo)

val prependValue = 6 +: firstSeq
  println("Add value 6 to Sequence: " + prependValue)


}

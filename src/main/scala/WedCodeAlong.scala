object WedCodeAlong extends App { //add 'extends App' to get it runnable

  //CONDITIONAL if/else

  val weather: String = "cold"

  // if/else statements

  if (weather == "rainy") {
    println("Take a coat with a hood")

  } else if (weather == "sunny") { // you can have as many else/if as required
    println("wear sun cream")
  } else if (weather == "cold") {
    println("wear a warm coat")
  } else { // catch for anything / condition that is not defined in the else/if
    println("Not a valid weather option")
  }

  // how many test cases based on the above example? Min. 4 test, as there are 4 distinct paths - in the 'else' there will be edge cases to test too.

  // sometimes there is multiple options.

  val season: String = "winter"
  // how we approach this when we have multiple options:
  // eg. Requirement: if season is winter and it is cold = take a jacket

  if (weather == "cold" || season == "winter") {
    println("take a coat")
  } else {
    println("a light jacket is fine")
  }

  // PATTERN MATCHING - similar to if/else - cleaner if/else statements, only takes up one line of code, account for wild cards - use underscore

  weather match {
    case "rainy" => println("Take a coat with a hood")
    case "sunny" => println("wear sun cream")
    case "cold" => println("wear a warm coat")
    case _ => println("Not a valid weather option") //wildcard underscore _ (when value is not important)
  }

  // when using operators if/else statements are easier,
  // if there is a set finite number . error cases, set things pre-defined, pattern matching is easier.

  (weather, season) match { // if guarding
    case (weather, season) if weather == "cold" || season == "winter" => println("take a coat")
    case _ => println("a light jacket is fine")

  }

  // INT - *BECAREFUL*
  val age: Int = -60
  if (age >= 18) {
    println(s"You are an adult because you are $age")
  } else {
    println(s"you are a child because you are $age")
  }

  // fix the negative
  val age1: Int = 10

  if (age1 < 0) {
    println(s"Invalid age: $age1. Age cannot be negative")
  } else if (age1 >= 18) {
    println(s"You are an adult because you are $age1")
  } else {
    println(s"you are a child because you are $age1")
  }
  // make it a pattern match instead

  age1 match {
    case age if age < 0 => println(s"Invalid age: $age1. Age cannot be negative")
    case age if age <= 18 => println(s"You are an adult because you are $age1")
    case age if age >= 18 => println(s"you are a child because you are $age1")
  }
// NOTES: if/else statements - always start with highest condition first when checking Numeric ranges
  // Use >= for the lower bound and < for the upper bound to avoid overlaps


  //TASK 1 - calculate somebody's grade given the percentage they scored, use if/else statement
  // ensure conditions are exhaustive, any grade will get a response and edge caes are considered eg. 103%

    val grade: Int = 10

    if (grade >=90 && grade <=100){
      println(s"Your grade is A")
    }else if (grade >=80 && grade < 90) {
      println(s"Your grade is B")
    }else if (grade >=70 && grade <80){
      println(s"Your grade is C")
    } else if  (grade >=60 && grade < 70){
      println(s"Your grade is D")
    } else if (grade >=50 && grade <60) {
      println(s"Your grade is E")
    } else if (grade >=0 && grade <50) {
      println(s"Your grade is F")
    } else { println (s"invalid grade: $grade")}

  //Example - can use a FUNCTION and reuse it for CLEANER code

  def getLetterGrade(grade: Int): String ={
    if (grade >=90 && grade <=100) "A"
    else if (grade >=80) "B"
    else if (grade >=70) "C"
    else if (grade >=60) "D"
    else if (grade >=50) "E"
    else if (grade >=0) "F"
    else "Invalid"
  }
  println("task1 example:" + s"Your grade is ${getLetterGrade(grade)}")

  //Pattern-match example for Task 1
  grade match {
    case grade if grade >=90 && grade <=100 => println(s"Your grade is A")
    case grade if grade >=80 && grade <90 => println(s"Your grade is B")
    case grade if grade >=70 && grade <80 => println(s"Your grade is C")
    case grade if grade >=60 && grade <70 => println(s"Your grade is D")
    case grade if grade >=50 && grade <60 => println(s"Your grade is E")
    case grade if grade >=0 && grade <50 => println(s"Your grade is F")
    case _ => println("Invalid grade") // wildcard that matches anything not caught by earlier cases - use for invalid inputs eg. negative numbers
  }
// "case guards" use 'if' keyword to use a condition. In Scala each 'case' in a 'match' block expects a pattern to match against, not a boolean expression

  // TASK 2 - work out for any given age, what film ratings they can see, use Pattern Matching.
  //Exhaustive conditions, any age will get a response and edge cases considered

  val filmAge: Int = 100
  filmAge match {
    case filmAge if filmAge >= 18 => println(s"Film rating suitable U,PG,12A,15,18+")
    case filmAge if filmAge >= 15 => println(s"Film rating suitable U,PG,12A,15+")
    case filmAge if filmAge >= 12 => println(s"Film rating suitable U,PG,12A")
    case filmAge if filmAge >= 8 => println(s"Film rating suitable U,PG")
    case filmAge if filmAge >= 4 => println(s"Film rating suitable U only")
    case _ => println(s"$filmAge is too young to attend the cinema")
  }




  //OPTIONS (getOrElse)
  // optional fields - this is a type, wrap int, string, boolean in
  val name: Option[String] = Some("April")
  val emptyName: Option[String] = None

  println(name)
  println(emptyName)

  // .getOrElse is used when we want to return a default value if the NONE is returned
  // It will also take the Some away, leaving us with just the internals.

  def getName(name: Option[String]): String = name.getOrElse("This user has left the field empty")
  println(getName(name)) // OUTPUT: Some('April)
  println(getName(emptyName)) // OUTPUT: None



  // ERROR CATCHING - Try/Catch
  // handles the code without crashing the computation
//example - enter a number but input is a string

  try{
    //ALL LOGIC - If/Else, pattern match, def, val
    val number ="one".toInt // I want to change the input to a Int from a String
    println(s"the number is $number")
  } catch{
    case error: NumberFormatException => println(s" $error this was not a valid input") // often see error as 'e' this is just a meaningful name
  }

//AFTERNOON TASK  =====  Handling Multiple Options  =================================================
  //MVP 1. John from primary school maths is trying to buy as many watermelons as possible and we need to
  //give him a reality check. John can reasonably carry 3 watermelons without a bag, and 5 with one bag.
  //a) Create a value to store a number of watermelons.
  val NumberOfWatermelon: Int = 5

  //b) Use your Scala knowledge to print appropriate messages based on the criteria above to tell
  println("1.b:" + s"How may watermelon John will buy: $NumberOfWatermelon")
  //John whether he: i. Doesn't need a bag, ii. Needs a bag, iii. Can't carry them (Be sure to consider how you will handle invalid numbers.)
  //c) Use string interpolation to add to each message the number of watermelons John is trying to buy.
  NumberOfWatermelon match {
    case wm if wm <=0 => println(s"John doesn't buy any watermelon")
    case wm if wm <= 1 && wm <=3 => println (s"John can carry $NumberOfWatermelon, NO BAG is required")
    case wm if wm <= 5 => println (s"John can carry $NumberOfWatermelon with ONE bag")
    case wm if wm >6 => println (s" This is too many watermelons for John to carry $NumberOfWatermelon watermelons")
  }

  //d) Create a value to store a `Boolean` that indicates whether John has a bag with him or not.
  val withBag: Boolean = false // indicate whether John has a bag true or false
println(s"Does John have a bag with him $withBag")
  //e) Use an if/else statement and this `Boolean` value to tell John whether he can or cannot by the desired number of watermelons in Task 1.

  if (NumberOfWatermelon <0) {
    println("No watermelon for John today")
  } else if ( withBag && NumberOfWatermelon <=3  ){
    println(s"John can carry the watermelons without bag")
  } else if (NumberOfWatermelon <=6 && withBag){
    println(s"John can carry watermelons with a bag")
  } else { println("John can't buy any watermelons today")}

// MVP 2. A person is paid £0.45 per mile travelled. When they input their miles travelled it goes in as a
  //`String` (e.g. “twenty”). Given the distance inputted, calculate the amount to be paid back being
  //sure to use try/catch to account for errors.

  val distanceTravelled = "10".toInt

  try {
    val miles =distanceTravelled
    val amountToPayBack: Double = distanceTravelled *0.45
    println(s"Amount to be paid back: £$amountToPayBack")
  } catch {
    case e:  NumberFormatException => println(s"invalid entry, $distanceTravelled is not valid")
  }

  //EXTENSION

}

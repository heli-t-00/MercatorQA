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

  //TASK 1 - calculate somebody's grade given the percentage they scored, use if/else statement
  // ensure conditions are exhaustive, any grade will get a response and edge caes are considered eg. 103%

  //  val grade: Int = 90
  //
  //  if (grade <=90){
  //    println(s"Your grade is A")
  //  }else if (grade <=80 && grade >= 89) {
  //    println(s"Your grade is B")
  //  }else if (grade <=70 && grade >= 79){
  //    println(s"Your grade is c")
  //  } else if  (grade <=60 && grade >= 69){
  //    println(s"Your grade is D")
  //  } else if (grade <=50 && grade >=59) {
  //    println(s"Your grade is E")
  //  } else (grade >=0 && grade >=49) {
  //    println(s"Your grade is F")
  //  }

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





}

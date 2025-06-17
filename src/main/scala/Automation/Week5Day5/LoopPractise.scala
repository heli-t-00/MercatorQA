package Automation.Week5Day5

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import java.util
import scala.jdk.CollectionConverters.CollectionHasAsScala


object LoopPractise extends App {

  //FOR Comprehension
  /**
   * allowing scala to write a function 'do something with the collection'
   * for the item in this collection do something to it, based on what we put in the brackets
   * for( item <- collection){
   * // DO SOMETHING TO EVERY ITEM
   *
   * }
   *
   */
  //SCALA
  val fruits: List[String] = List("Apple", "Banana", "Cherry", "Melon")
  // i in this case is called fruit
  for (fruit <- fruits) {
    println(fruit)
  }
  //TURN INTO SELENIUM
  /**
   * .asScala turns code from Java into Scala
   *
   * for (fruit <- fruits.asScala) {
   * println(fruit.getText) // code without .getText will only bring out the cell, add .getText turn it into text
   * }
   *
   */

  //EXAMPLE - WON"T RUN
  //Syntax is always the same
  val driver = new ChromeDriver()
  driver.get("https://example.com")
  // loop through list of elements

  val items: util.List[WebElement] = driver.findElements(By.id("i")) // Elements with S -it is a list Find element by id. using inspect tool.

  for (item <- items.asScala) { // Loop over each web element in the items collection (but this is a java list - currently can't use <- until we turn it into Scala = use .asScala)
    println(item.getText) // Get the text, and print

  }

  // Click ALL buttons within a selection

  val buttons = driver.findElements(By.cssSelector(".my-buttons"))
  for (button <- buttons.asScala) {
    button.click()
  }

  // Find a specific element (within a LOOP - collection of a types/things)
  // NEED to use if statement within a FOR Comprehension

  val links = driver.findElements(By.tagName("a")) // find all the links on the URL from ln43
  // I want to find the 'contact us' link
  // if link contains contact, then find it and do something to it hence use the if statement

  for (link <- links.asScala) {
    if (link.getText.contains("Contact".toLowerCase())){ // use built in methods
      link.click()
    } else
      println("no links containing 'contact' were found")
  }
  // scala does not break out of Loops
  // recursion is not a thing in selenium
  // recursion calls a method again in Scala code

  //TABLES
 /* <table>
    <tr>
     <td>Apple</td><td>Red</td>
    </tr>
    <tr>
  <td>Banana</td><td>Yellow</td>
    </tr>
    </table>

  */
// loop through table rows
  val rows = driver.findElements(By.tagName("tr")) // find all elements contained with 'tr' tags (rows)

  // find row and index position
  for ((row, index) <- rows.asScala.zipWithIndex){
    val cells = row.findElements(By.tagName("td")) // this is taking all of the rows that has been found and going INSIDE the rows and Pull out every "td" tag ie. Apple, Red, Banana, Yellow
    // cell = List("Apple", "Red", "0", "Banana", "Yellow", "1")
    // .map Method - get to the content and jump through it(iterate) instead of using for comprehension
    val makeString = cells.asScala.map(_.getText).mkString(" ".trim) //call cells as Scala code
    println(makeString)


  }

// .zipWithIndex method
  // Pair each row with its index (starting from 0)
  // OUTPUT
  // Row 0: Apple | Red
  // Row 1: Banana | Yellow

  // .mkString () Formats the output

// DOES A VALUE EXIST?
  // make for comprehension exist in a val so that it can be called in the future
  val doesBananaExist = rows.asScala.exists{
    row => val cells = row.findElements(By.tagName("td")).asScala
      cells.exists(_.getText == "Banana")
  }
assert(doesBananaExist, "Yay bananas!")

}

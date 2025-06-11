package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object ExtensionTaskWk4day4 extends App{
  val driver: WebDriver = new ChromeDriver()
  driver.get("https://www.w3schools.com/html/html_examples.asp")

  // a) Identify Button Elements
  val buttons = driver.findElements(By.tagName("button"))
  println(s"1a. Number of button elements: ${buttons.size()}")

  // b) Identify Image Elements
  val images = driver.findElements(By.tagName("img"))
  println(s"1b. Number of image elements: ${images.size()}")

  // c) Count how many of a specific element (e.g., <h1> or <a>) exist on the page
  val h1Count = driver.findElements(By.tagName("h1")).size()
  println(s"1c. Number of <h1> elements: $h1Count")

  // d) Use a loop to identify multiple types of tags (like p, a, h1, button
  val tagsToCheck = List("a", "h1", "button")
  tagsToCheck.foreach { tag =>
    val elements = driver.findElements(By.tagName(tag))
    println(s"1d. Number of <$tag> elements: ${elements.size()}")
  }

  // e) Use a loop to find the count of hyperlinks on a page?
  val links = driver.findElements(By.tagName("a"))
  println(s"1e. Total hyperlinks on page: ${links.size()}")

  driver.quit()
}

package Automation.Week5Day4

import org.openqa.selenium._
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui._
import java.time.Duration
import java.util.function.Function


object pmTaskStaticTableWaitCOMPLETE extends App {

  //  MVP:
  //1. Navigate to the Practice Table URL: https://cosmocode.io/automation-practice-webtable/
  //2. Static Table Handling
  //• Locate the table containing country data.
  //• Extract and print all country names from the first column.
  //• Use JavaScript Executor to highlight each row as it’s read.
  //3. Implicit Wait
  //• Set a global implicit wait of 10 seconds.
  //4. Explicit Wait
  //• Wait for a specific country row (e.g., "Germany") to be visible.
  //• Once visible, extract its capital and currency.

  // Setup WebDriver
  val driver = new ChromeDriver()

  // Set Implicit Wait
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
  println("Finished implicitly waiting...")

  // Navigate to the practice table
  driver.get("https://cosmocode.io/automation-practice-webtable/")

  // Locate the table rows
  val rows = driver.findElements(By.cssSelector("table#countries tbody tr"))

  println("Rows located.\nCountry Names:")
  for (row <- rows.toArray.map(_.asInstanceOf[WebElement])) { // converts list of table rows into WebElement, loop through each row 'for (row <-...)
    val countryCell = row.findElement(By.cssSelector("td:nth-child(1)")) // row.findElement(...) gets the first <td> (country name)
    println(s"- ${countryCell.getText}") // print and extract visible text .getText

    // Highlight the row using JavaScript
    //uses JS to visually highlight a table row <tr> in the browser by drawing a blue border around it, useful for debugging or test demos
    val js = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("arguments[0].style.border='2px solid blue'", row) // runs JS inside browser to change the border style of an HTML element
    // "argument[0]" refers to the first parameter you pass to executeScript eg. row
    // .style.border='....' modifies the elements border using JS to show 2 pixel wide solid blue border
    //RESULT: Whole row gets a blue outline in the browser, making it visible and stand out
    println("Rows highlighted.")
  }

  //NB: Why use this? Highlight rows - to see which element is being interacted with, Debugging, useful for visual confirmation your code is selecting a row, Presentation - used during demos/automated testing videos

  // Explicit Wait for a specific country (e.g., Germany)
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  val germanyRow = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath("//*[@id=\"countries\"]/tbody/tr[66]/td[2]/strong")
  ))
  println("Explicitly waited and found Germany.")

  val capital = germanyRow.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[66]/td[3]")).getText
  val currency = germanyRow.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[66]/td[4]")).getText
  println(s"\nGermany's Capital: $capital, Currency: $currency")

  //EXTENSION

  // 1.	JavaScript Executor
  // Scroll to bottom using JavaScript
  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("window.scrollTo(0, document.body.scrollHeight)")

  // Change background color of the "Country" header
  val header = driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[1]/td[2]/h3/strong"))
  js.executeScript("arguments[0].style.backgroundColor='yellow'", header)

  // Print page title using JavaScript
  val title = js.executeScript("return document.title").toString
  println(s"\nPage Title: $title")

  // 2. Fluent Wait

  // Fluent Wait setup
  val fluentWait = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(15))
    .pollingEvery(Duration.ofSeconds(5))
    .ignoring(classOf[NoSuchElementException])
  println("Fluently waiting...")

  // Define the condition to find the "India" row
  val indiaRow = fluentWait.until(new Function[WebDriver, WebElement] {
    override def apply(driver: WebDriver): WebElement = {
      val row = driver.findElement(By.xpath("//*[@id=\"countries\"]/tbody/tr[78]/td[2]/strong"))
      if (row.isDisplayed) {
        println("'India' row found.")
        row
      } else {
        null
      }
    }
  })


  // 3. Table validation
  // Find all rows in the table
  val tableRows = driver.findElements(By.cssSelector("table#countries tbody tr"))

  var found = false
  for (row <- rows.toArray.map(_.asInstanceOf[WebElement])) {
    val languageCell = row.findElement(By.cssSelector("td:nth-child(5)"))
    if (languageCell.getText.trim.equalsIgnoreCase("French")) {
      println("Language 'French' found in the table.")
      // Highlight the row
      val js = driver.asInstanceOf[JavascriptExecutor]
      js.executeScript("arguments[0].style.backgroundColor='lightgreen'", row)
      found = true
    }
  }

  if (!found) {
    println("Language 'French' not found in the table.")
  }


  driver.quit()

}

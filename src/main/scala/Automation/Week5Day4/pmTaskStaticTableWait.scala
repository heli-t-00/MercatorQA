package Automation.Week5Day4

import Automation.Week5Day4.HandlingStaticTables.tableRows
import Automation.Week5Day4.JavaScriptExecutor.{driver, login}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object pmTaskStaticTableWait extends App {

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

  val driver: WebDriver = new ChromeDriver()

  //1. Navigate to the Practice Table URL: https://cosmocode.io/automation-practice-webtable/
  driver.get("https://cosmocode.io/automation-practice-webtable/")

  //Locate table rows
  val countries = driver.findElement(By.id("countries"))
  val tableRows = countries.findElements(By.tagName("tr"))

  //iterate over the row - Locate the table containing country data.

  for (i <- 1 until tableRows.size()) {
    val cols = tableRows.get(i).findElements(By.tagName("td"))
    println(cols.get(1).getText)

  }

  // Use JavaScript Executor to highlight each row as it’s read.

  //  val rows = countries.findElements(By.tagName("tr"))
  //  val js = driver.asInstanceOf[JavascriptExecutor]
  //  js.executeScript("arguments[0].style.backgroundColor ='red'", tableRows.get(i))
  ////  println(cols.get(1).getText)}


  driver.quit()

}

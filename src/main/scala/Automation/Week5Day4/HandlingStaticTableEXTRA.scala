package Automation.Week5Day4

//Import the necessary Selenium classes
import Automation.Week5Day4.HandlingStaticTables.tableRows
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

//define Object with main method
object HandlingStaticTableEXTRA extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
val driver: WebDriver = new ChromeDriver()
//navigate to webpg containing Static HTML table

driver.get("https://www.w3schools.com/html/html_tables.asp")
//driver.manage().window().maximize()

  //==== STATIC TABLE EXTRA=====

  val rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[position() >1]"))

  // USE FOR LOOP
  // how many rows we have - in this example there is data in 6 rows out of 7 (first row is header)

  for (i <- 0  until  rows.size()) { // picking up the data from each colomn using this Loop

    val columns = rows.get(i).findElements(By.tagName("td")) // each column

    //convert to text and print

    val rowText = columns.toArray.map(_.asInstanceOf[org.openqa.selenium.WebElement].getText).mkString(" | ")

    println("Row " + (i + 1) + ": " + rowText)



 }
println("test")
//close ALL browser after process
driver.quit()

}

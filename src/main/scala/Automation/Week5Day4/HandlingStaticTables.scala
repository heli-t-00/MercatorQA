package Automation.Week5Day4

//Import the necessary Selenium classes
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}
//define Object with main method
object HandlingStaticTables extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
val driver: WebDriver = new ChromeDriver
//navigate to webpg containing Static HTML table

driver.get("https://www.w3schools.com/html/html_tables.asp")
driver.manage().window().maximize()
  //    Locate all data rows in the table with id 'customers', skipping the header row
  // XPath explained:
  // //table[@id='customers']      → Locate the table with id 'customers'
  // /tbody/tr[position() > 1]    → Get all rows (tr) inside tbody, excluding the first one (usually the header)
val tableRows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[position() > 1]")) // finds all matching elements on the page.
  //This gives the data rows.

  //Iterate through each row - this starts a loop that runs once for every row in the table

for (i <- 0  until  tableRows.size()) {

  val cols = tableRows.get(i).findElements(By.tagName("td")) // for the current row i, this finds the cells in that row.
  //Gets all the columns (td elements) inside the current row.

  val rowText = cols.toArray().map(_.asInstanceOf[org.openqa.selenium.WebElement].getText) // converts the list of cells into an array. then it maps each cell to it's text content using .getText (convert column elements to text)


  println(s"Row ${i + 1}: ${rowText.mkString("", " | ", "")}") // prints the row data and joins all the column text with | in between



}

//close ALL browser after process
driver.quit()

}

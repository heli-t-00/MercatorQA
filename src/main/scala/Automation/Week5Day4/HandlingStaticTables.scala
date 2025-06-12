package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}
//
object HandlingStaticTables extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
val driver: WebDriver = new ChromeDriver
driver.get("https://www.w3schools.com/html/html_tables.asp")
driver.manage().window().maximize()

val tableRows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[position() > 1]"))

for (i <- 0  until  tableRows.size()) {

  val cols = tableRows.get(i).findElements(By.tagName("td"))
  val rowText = cols.toArray().map(_.asInstanceOf[org.openqa.selenium.WebElement].getText)


  println(s"Row ${i + 1}: ${rowText.mkString("", " | ", "")}")



}


driver.quit()

}

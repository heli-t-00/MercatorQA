package Automation.Week6Day1

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object pmTaskW6D1extension extends App {
  //Set up WebDriver
  val driver: WebDriver = new ChromeDriver()

  //Navigate to URL
  driver.get("https://the-internet.herokuapp.com/tables")

// Locate Table 1 and column header
  val table1: WebElement = driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[1]"))
  table1.click()




  driver.quit()

}

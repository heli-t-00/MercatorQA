package Automation.Week5Day1

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object BycssSelector extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

//  val emailAddress: WebElement = driver.findElement(By.id ("email"))
//    val emailAddress: WebElement = driver.findElement(By.cssSelector ("#email"))
      val emailAddress: WebElement = driver.findElement(By.xpath("//*[@id=\"email\"]"))

  driver.quit()





}

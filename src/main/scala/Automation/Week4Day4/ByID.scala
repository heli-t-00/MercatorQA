package Automation.Week4Day4

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import scala.reflect.internal.NoPhase.id

object ByID extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  // INSPECT ELEMENT IN WEBPAGE TO FIND THE NAMES YOU NEED TO SEARCH FOR
  val emailAddress: WebElement = driver.findElement(By.id ("email")) //FIND ELEMENT THROUGH By.id (checked on inspect webpage)

emailAddress.sendKeys("test@gmail.com")
  // sendKeys is used for inputting text on any field - example above 'test@gmail.com' is inputted
println("email address entered: Passed")
  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("Password123")
println("password entered: Passed")

  val login: WebElement = driver.findElement(By.id("login"))
  login.click()
  println("login entered: successful")

  driver.quit()





}

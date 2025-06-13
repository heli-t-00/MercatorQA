package Automation.Week5Day1

import Automation.Week5Day2.Task3.{checkedBox, driver, submit}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration


object xPath extends App {
  //Instantiating the ChromeDriver for interacting with the Chrome browser
  val driver: WebDriver = new ChromeDriver()

//  // Add implicit wait
//  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

  //Accessing the web url for testing
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  driver.manage().window().maximize()
  //  val emailAddress: WebElement = driver.findElement(By.id("email"))

  //Use the xPath for the locator present in the HTML code
  val emailAddress: WebElement = driver.findElement(By.xpath("//*[@id=\"email\"]"))
  emailAddress.sendKeys("test@gmail.com")
  println("Email address entered - Passed")

  // val password: WebElement =driver.findElement(By.id("password"))
  //val password: WebElement =driver.findElement(By.cssSelector("input[type='password']"))

  val password: WebElement =driver.findElement(By.xpath("//*[@id=\"password\"]"))
  password.sendKeys("Password123")
  println("Password entered - Passed")


  val submit = driver.findElement(By.xpath("//*[@id='login']"))
  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", submit)
  Thread.sleep(500)

  // Click using JS to avoid interception
  js.executeScript("arguments[0].click();", submit)

  println("Submit Button clicked")

  driver.quit()
}

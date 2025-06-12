package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingTextBox extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  val text = driver.findElement(By.id("my-text-id"))
  text.sendKeys("Welcome to Mercator")
  println("The value has been entered")

  val text1 = text.getAttribute("value")
  println(("The attribute value has been entered" + text1))

  val text2 = text.getText
  println(("The attribute value" + text2))

  text.clear()
  println(("The value has been cleared down" + text))




  driver.quit()





}

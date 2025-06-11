package Automation.Week5Day3

import Automation.Week5Day3.HandlingButtonsLinks.driver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingButtonsLinks extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  //Button - inspect the Page, find the element / attributes/values
  driver.manage().window().maximize()

  val button: WebElement = driver.findElement((By.cssSelector("[type=\"submit\"]")))
    if (button.isEnabled) {

    println("Button text  " + button.getText)
      button.click()
    }else {
      println("Button is NOT enabled")
    }

// Find hyperlink on the webpage - Handling Hyperlinks
  driver.get("https://www.selenium.dev/")
  val myLink = driver.findElement((By.linkText("Documentation")))



val myLink1 = myLink.getAttribute("href")

println("Destination URL" +myLink1)





  driver.quit()

}

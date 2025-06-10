package Automation.Week5Day2

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object BrowserMethods extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.selenium.dev/selenium/web/web-form.html") // .get() navigates to URL
driver.manage().window().maximize() // maximises windows
  driver.navigate().to("https://the-internet.herokuapp.com") // same as .get()

  driver.navigate().back() // navigate BACK to browser history
 driver.navigate().forward() // navigate FORWARD to browser history

  driver.navigate().refresh() // refresh current page

  driver.close() // close current window NB can't be used at same time as driver.quit() will throw up error as there's nothing to close if already used driver.quit()

//  driver.quit() // close ALL window





}

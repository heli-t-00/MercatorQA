package Automation.Week5Day2

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object BrowserMethods extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.selenium.dev/selenium/web/web-form.html") // .get() navigates to URL


  // ======== Commonly Used WebDriver 'browser control' Methods ========

  // Maximize the browser window
  driver.manage().window().maximize()

  // Navigate to the first URL using .navigate().to()
  driver.navigate().to("https://example.com")

  // Navigate to a second URL
  driver.navigate().to("https://the-internet.herokuapp.com")

  // Go back in browser history
  driver.navigate().back()

  // Move forward in browser history
  driver.navigate().forward()

  // Refresh the current page
  driver.navigate().refresh()

  // Close the current browser window
  driver.close()

  // Optionally quit the WebDriver session completely if multiple windows were opened
  // driver.quit()





}

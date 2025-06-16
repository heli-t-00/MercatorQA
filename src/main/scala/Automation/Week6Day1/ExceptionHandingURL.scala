package Automation.Week6Day1

import Automation.Week6Day1.ExceptionHandling.driver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, NoSuchElementException, WebDriver, WebElement}
import java.time.Duration



object ExceptionHandingURL extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()

  // INSIDE the try block, run test actions, where you tell the browser what to do. In this example, it will open the Chrome teset webpages, that loading the animation and hidden messages.

  try {
    //ACCESSING THE WEB URL FOR TESTING
    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1")

    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3)) // Creates Explicit Wait, Wait 3 seconds, for something to happen on page before giving up( timing out)
    explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish"))) // .until tells Selenium What to wait for ie. wait till element with ID finish becomes visible on page
    println("Element became visible: Test passed")
    assert(driver.findElement(By.id("finish")).isDisplayed)

    //CATCH block - handling errors - this is the safety net, if anything goes wrong in the TRY block, eg. website fails to load, element not found, the program will print error message. PRINT ERROR trace useful for debugging)
  } catch {


  case e: Exception => // USE THIS WHEN YOU DON"T KNOW WHAT TYPE OF EXCEPTION IS EXPECTED
      println("===Test failed===: " +e.getMessage )
      e.printStackTrace() // get log for debugging

      // FINAL blick - always run this, This block will always run, even if there's an error
  } finally {
    if(driver !=null) {
      driver.quit()
    }
  }





}

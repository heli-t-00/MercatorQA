package Automation.Week5Day4

import org.openqa.selenium.{By, JavascriptExecutor}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object ExplicitWait extends App {

  // instantiating the ChromeDriver with Chrome browser
  
  val driver = new ChromeDriver
  
  // access URL for testing
  driver.get("https://www.w3schools.com/howto/howto_css_custom_checkbox.asp")
  driver.manage().window().maximize()


    //EXPLICIT WAIT - waits for a certain condition to occur before proceeding further in code
  val explicitWait = new WebDriverWait(driver, Duration.ofMinutes(1))

// waits for this element to be clickable.
  val checkBox = explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/label[1]")))
  println("Checkbox found.")

  // ADD JavaScript execution to interact with a web element ie. checkbox when a standard .click() method might not work.


  val js = driver.asInstanceOf[JavascriptExecutor] // casts the driver to a JavaScriptExecutor so that you can execute raw JS commands in browser
  // This is used, because methods like element.click() fails eg. element is off screen/hidden/blocked by other elements. JS can bypass these issues.
  js.executeScript("arguments[0].scrollIntoView(true);", checkBox) //Scrolls the browser window to bring the checkBox element into view
  // Elements must be in viewport to interact with them, especially if they are off screen or in a scrollable container
  js.executeScript("arguments[0].click();", checkBox) //Clicks the checkBox using JS
  // EXAMPLE(uncomment to see .click() NOT WORK  - comment out the JSExecutor)
//    checkBox.click()
  println("Checkbox clicked.")

  driver.quit()

  // NB: Explicit wait is GOOD for better control compared to implicit waits as it would wait for specific element/conditions to become visible/clickable
  // Ideal for elements that may take time to load or takes time to become visible /clickable
  // JSExecutor is used when .click() doesn't work due to element not being clickable/overlay issues/dynamic rendering delays.

}

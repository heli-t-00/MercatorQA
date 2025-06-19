package Automation.Week5Day4
import org.openqa.selenium._
import org.openqa.selenium.chrome.ChromeDriver

import java.time.Duration
// =====IMPLICIT WAIT ===== applies globally to ALL elements, once set, it stays in place for the life of the WebDriver object
// Therefore can slow down the test, if overused, Selenium will wait the full time for EVERY ELEMENT

object ImplicitWait extends App{

  // Create ChromeDriver instance
  val driver: WebDriver = new ChromeDriver()

  // ===== Apply IMPLICITLY wait of 10 seconds =====
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))  // new syntax after Selenium4.0+

  // Navigate to the Selenium test page
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // Maximize the window
  driver.manage().window().maximize()

  // Locate the text box by name
  val textBox = driver.findElement(By.name("my-text"))

  // Enter text into the text box
  textBox.sendKeys("Testing text input in Scala.")

  // Clear the text box
  textBox.clear()

  // Enter a new value
  textBox.sendKeys("Final input done.")

  // Optionally close the browser
  driver.quit()

}

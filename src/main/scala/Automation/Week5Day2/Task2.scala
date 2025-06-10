package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Task2 extends App {

//  Task 2:
  //Use this link: https://demoqa.com/automation-practice-form
  //Create a simple automation script that demonstrates usage of key WebDriver browserlevel
  //methods.
  //1. Launch the browser using WebDriver.
  //2. Navigate to the test URL.
  //3. Navigate:
  //o to "https://example.com"
  //o back
  //o forward
  //o refresh
  //4. Using built in methods, maximise and minimise the browser window.
  //5. Print part of the page source.
  //6. Close current window.
  //7. End the session.

  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //Launch the browser using WebDriver
  //Navigate to test URL
  driver.get("https://demoqa.com/automation-practice-form")
  // Navigate to new window used navigate().to()
  driver.navigate().to("https://example.com")
  // Navigates back to previous window in back history
  driver.navigate().back()
  // Navigates forward to window in history
  driver.navigate().forward()
  // refreshes the window
  driver.navigate().refresh()
  // Used built in methods to maximise the browser window
  driver.manage().window().maximize()
  // Used build in methods to minimise the browser window
  driver.manage().window().minimize()
  // Print part of the page source
  driver.getPageSource.take(300)
 // Close current window
  driver.close()
//  driver.quit()



}

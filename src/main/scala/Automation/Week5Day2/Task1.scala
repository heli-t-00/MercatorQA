package Automation.Week5Day2

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Task1 extends App {


//  Task 1:
//    Use this link: https://demoqa.com/browser-windows
//  Create a simple automation script that demonstrates usage of key WebDriver browserlevel
//    methods.
//  1. Launch the browser using WebDriver.
//  2. Navigate to the test URL.
//  3. Fetch and print:
//      o Page title
//      o Current URL
//  4. Close current window.
//  5. End the session.

  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //Launch the browser using WebDriver
  //Navigate to test URL
  driver.navigate().to("https://demoqa.com/browser-windows")

  // Fetch and Print: Title Page & Current URL
  driver.getTitle()
  println("Title Page: ")
  driver.getCurrentUrl()
  println("Current URL")

//  // Close current window
//  driver.close()

//End the session
  driver.quit()
}



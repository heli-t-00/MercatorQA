package Automation.Week5Day2

import Automation.Week5Day2.Task2.driver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object CloseQuitDifference extends App{
  //What is the difference between .close() and .quit() in different scenarios?
  //Try closing one tab vs closing the entire session.
  //Research how they behave when multiple windows/tabs are open.

  // driver.quit() - closes all browser windows opened during the session and ends the WebDriver session completely. It kills the browser process and cleans up everything related to that webdriver. USE this at end of the script to ensure proper cleanup and avoid memory leaks.

  // driver.close() - closes the CURRENT browser window that the WebDriver is controlling. It does not end the entire WebDriver session if multiple browser windows or tabs are open. USEFUL when you want to close a specific tab or window BUT continue using the browser in your automation.

  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //Launch the browser using WebDriver
  //Navigate to test URL
  driver.navigate().to("https://demoqa.com/browser-windows")
  driver.navigate().to("https://example.com")
  // Fetch and Print: Title Page & Current URL

  driver.getTitle()
  println("Title Page: " + driver.getTitle)
  driver.getCurrentUrl()
  println("Current URL" + driver.getCurrentUrl)

// Close current window
  driver.close()


}

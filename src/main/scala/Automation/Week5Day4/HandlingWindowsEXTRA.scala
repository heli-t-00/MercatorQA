package Automation.Week5Day4

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandlingWindowsEXTRA extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/windows") // PARENT WINDOW - a HandleID is created
driver.manage().window().maximize() // window will maximise in parent window

  //======HANDLING WINDOWS EXTRA==========

  val parentWindow = driver.getWindowHandle
  println("Window handle for PARENT window" + parentWindow)

  // CLICK Link
driver.findElement(By.linkText("Click Here")).click()
  // this opens a NEW window
  // we can now check how many windows are open and can use the handle

  // .getWindowHandles - returns MULTIPLE window

  val allWindows: List[String] = driver.getWindowHandles.asScala.toList // GETS ALL THE WINDOWS

  val it = allWindows.iterator // THIS WILL MOVE through the windows and the iterator has methods to check every window

  while (it.hasNext) { // it will go through and iterate through ALL WINDOWS - this will start with the first one
    // WHAT CONDITIONS will it give

    val handle = it.next()
    if (handle != parentWindow) { // This checks whether the current handle, is not the same as the original window, which is stored in parentWindow, find window newly open that is different from the main

      driver.switchTo().window(handle) // this tells Selenium to switch focus
      print("title of page" +driver.getTitle)
      driver.close()

    }

  }
  driver.switchTo()window(parentWindow)

  driver.quit()
// this script, open a website with a link that opens a new window. click the link to open the new window. get the list of all windows open. Loop through them. If it is not the original window, switch to it. Print that window Id and Title.


  // Look at how it works when in DEBUG mode

}

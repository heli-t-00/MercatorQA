package Automation.Week5Day4

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandlingWindows extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/windows")
driver.manage().window().maximize() // window will maximise in parent window

  //getWindowHandle() gets the unique ID of the current browser window (the "parent window").
  //This ID helps us remember which window we started with.
  val parentWindow = driver.getWindowHandle()
  println("Handle for parent window" + parentWindow)

  //INSPECT page and check the element / use linkText to find the element

  //This finds the link on the page that says "Click Here" and clicks it.
  //This link opens a new browser window or tab.
driver.findElement(By.linkText("Click Here")).click()


  val allWindows: List[String] = driver.getWindowHandles.asScala.toList
  //.getWindowHandles gets a list of all open windows (their unique ID) It runs a Set, so we convert .asScala.toList so we can work with it easily

  val it =allWindows.iterator // iterate through each window one by one


  // LOOP to Switch Windows

  while(it.hasNext) { // loops/iterate through each open window
    val handle = it.next() // handle will hold the ID of the current window we're checking

    if (handle != parentWindow) { // this checks if this is NOT the parent/original window, we only want to switch to the new window that just opened.

      driver.switchTo().window(handle) // switch control to new window.
      println("The current window" + handle) // print the ID of new window

      println("Page title is - " + driver.getTitle()) // prints the title of the web page in the new window
    }

  }

  driver.quit()
// this script, open a website with a link that opens a new window. click the link to open the new window. get the list of all windows open. Loop through them. If it is not the original window, switch to it. Print that window Id and Title.

}

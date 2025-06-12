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
  val it =allWindows.iterator // iterate through each window handles

  while(it.hasNext) {
    val handle = it.next()

    if (handle != parentWindow) { // if window is not the parent handle - switch to the window to current window
      driver.switchTo().window(handle)
      println("The current window" + handle)

      println("Page title is - " + driver.getTitle())

    }


  }


  driver.quit()

}

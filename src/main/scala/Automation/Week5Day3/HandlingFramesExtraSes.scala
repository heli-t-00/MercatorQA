package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

/* This code opens Chrome, goes to website with nested Frames (tiny pages inside pages) switches into different frames (middle, bottom, left, Extracts and prints text inside*/

object HandlingFramesExtraSes extends App {
  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/nested_frames")
  //  check the locator of Webpage - INSPECT page


  // ========STEPS to MOVE between frames ====== TODO write notes
  driver.switchTo().frame("frame-top") // used name to find the frame
  println("you are on top frame")
  driver.switchTo().frame(1) // use index to find the frame
  println("you are on middle frame of the top frame")

  driver.switchTo().defaultContent() // go back to the initial frame

  // driver.switchTo().frame("frame-bottom") // take name or use webElement

  // when you want to validate what's the name of frame or retrieve data is use .getText method

  // Create a val called frameBottom and this can be called - example of using Web Element
  val frameBottom = driver.findElement(By.name("frame-bottom"))
  driver.switchTo().frame(frameBottom)


  driver.quit()

  //NB: Always switchTo().frame(...) before interacting with elements inside that frame
  //USE defaultContent() to go back to main page
  // CANNOT access elements inside frame until you SWITCH to it

}

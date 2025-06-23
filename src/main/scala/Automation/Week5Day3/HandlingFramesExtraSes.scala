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

  //Switch from frame-top first BEFORE accessing frame-middle
driver.switchTo().frame("frame-top") // Move to top container

driver.switchTo().frame("frame-middle") // Move to middle frame

  val middleText = driver.findElement((By.id("content"))).getText
  println("Middle Text = " + middleText) //OUTPUT Middle Text MIDDLE

// Go back to Main Page (Default Frame)
driver.switchTo().defaultContent() // brings you back to the default frame, exits all frames.

// Switch to Bottom Frame (by Index)
  driver.switchTo().frame(1) // SWITCHING FRAME USING INDEX

  val bottomText = driver.findElement(By.tagName("body")).getText

  println("Bottom text = " +bottomText)

// Go back to Main Frame Again
driver.switchTo().defaultContent() // takes you back to the MAIN frame

  // use web element to do the switching
  // go to top frame from main page

  // Switch to Left Frame using WebElement - using frame element

  val frameTop = driver.findElement((By.name("frame-top")))
  driver.switchTo().frame(frameTop)

  // Go to Left frame
  driver.switchTo().frame("frame-left")

  val leftText = driver.findElement((By.tagName("body"))).getText
  println("Left text =  "+ leftText) // OUTPUT: Left text = LEFT

  driver.quit()

  //NB: Always switchTo().frame(...) before interacting with elements inside that frame
  //USE defaultContent() to go back to main page
  // CANNOT access elements inside frame until you SWITCH to it

}

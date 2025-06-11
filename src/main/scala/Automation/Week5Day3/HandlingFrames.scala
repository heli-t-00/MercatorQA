package Automation.Week5Day3

import Automation.Week5Day3.HandlingDropdownList.driver
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingFrames extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/nested_frames")

driver.switchTo().frame("frame-top")
  // check the locator from INSPECT
driver.switchTo().frame("frame-middle")

  val middleText = driver.findElement((By.id("content"))).getText
  println("Middle Text = " + middleText)


driver.switchTo().defaultContent() // brings you back to the default frame


  driver.switchTo().frame(1) // SWITCHING FRAME USING INDEX

  val bottomText = driver.findElement(By.tagName("body")).getText

  println("Bottom text = " +bottomText)


driver.switchTo().defaultContent() // takes you back to the MAIN frame

  // use web element to do the switching
  // go to top frame from main page

  val frameTop = driver.findElement((By.name("frame-top")))
  driver.switchTo().frame(frameTop)

  driver.switchTo().frame("frame-left")

  val leftText = driver.findElement((By.tagName("body"))).getText
  println("Left text =  "+ leftText)



  driver.quit()

}

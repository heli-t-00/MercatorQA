package Automation.Week5Day3

import Automation.Week5Day3.HandlingDropdownList.driver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object HandlingFrames extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/nested_frames")








  driver.quit()

}

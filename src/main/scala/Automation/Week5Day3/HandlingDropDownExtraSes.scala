package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver}

object HandlingDropDownExtraSes extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")

  // ==== SELECT BASED / STATIC DROPDOWN ======
// Handling Drop down
  // STEPS: First find LOCATOR use INSPECT
// CHECK where the locator is Located - in this example the locator is in a FRAME therefore need an added step to switch to the correct frame BEFORE it works

  driver.switchTo().frame("iframeResult")

  //find the dropdown - <select> tag
  //declare a val so can be used again
  val dropDown = driver.findElement((By.name("cars")))
//create one object for the dropDown
  val select = new Select(dropDown)

  //THREE METHODS
  // 1. Use ".selectByVisibleText"
  select.selectByVisibleText("Opel") // enter the text you want to select

  // 2. Use " .selectByIndex()
  select.selectByIndex(3)

  // 3. Use .selectByValue()
  select.selectByValue("volvo") // see inspect, check the value

  //Use any methods to perform testing


  driver.quit()

}

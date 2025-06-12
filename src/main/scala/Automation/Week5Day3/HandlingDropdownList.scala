package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object HandlingDropdownList extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")

// Handling Drop down
  // STEPS: First find LOCATOR use INSPECT
// CHECK where the locator is Located - in this example the locator is in a FRAME therefore need an added step to switch to the correct frame BEFORE it works

  driver.switchTo().frame("iframeResult")
  val dropDown = driver.findElement(By.name("cars"))

  //in dropdown there's a list to allow for items to be selected
  // create obj

  val select = new Select(dropDown)
  select.selectByVisibleText("Opel")

  println("selected by Visible Text - " + select.getFirstSelectedOption.getText)


select.selectByValue("volvo")
  println("selected by Value - " + select.getFirstSelectedOption.getText)

  select.selectByIndex(3)
  println("select by Index  - " +select.getFirstSelectedOption.getText)

  // TRY DROPDOWN none select



  driver.quit()

}

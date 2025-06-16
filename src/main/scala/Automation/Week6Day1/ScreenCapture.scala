package Automation.Week6Day1

import org.openqa.selenium.{By, OutputType, TakesScreenshot, WebDriver}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

// NEED THESE IMPORTS SO CAN CALL A SCREENSHOT WITH DATES
import org.openqa.selenium.io.FileHandler
import java.io.File
import java.util.Date
import java.text.SimpleDateFormat


object ScreenCapture extends App {

  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()

  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  /*----------- SCREEN SHOTS----------------*/
// create a variable - file type

  val srcFull: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
  FileHandler.copy(srcFull, new File("/Users/helen.to/Documents/screenshotAutomation/TestResult.png")) // CREATE FILE MANUALLY screenshotAutomation

//--------- CAPTURE SCREENSHOT with timestamp

  val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
  val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
  FileHandler.copy(srcTimestamp, new File(s"/Users/helen.to/Documents/screenshotAutomation/TestResult_$timeStamp.png")) // TIMESTAMP so that a new file is created

  //---- CAPTURE A SPECIFIC ELEMENT
  val element = driver.findElement(By.name("my-disabled")) // Locate the element by its name (update if needed)
  val srcElement: File = element.getScreenshotAs(OutputType.FILE) // Capture only that element// Save the screenshot of the element
  FileHandler.copy(srcElement, new File("/Users/helen.to/Documents/screenshotAutomation/TestResult_Specific.png"))

//RE-USE THIS code time and time again!

// BEST PRACTISE -- any file extensions .png, .jpeg, .txt, .pdf, csv, .json

  driver.quit()

}

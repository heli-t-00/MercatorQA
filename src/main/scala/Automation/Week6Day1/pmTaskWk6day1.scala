package Automation.Week6Day1



import org.openqa.selenium.{By, NoSuchElementException, OutputType, TakesScreenshot, TimeoutException, WebDriver, WebElement}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.io.FileHandler
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.io.File
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.Date


/* Automate the following scenario:
  Headless Login with Screenshot Capture and exception handling.
1. Use ChromeDriver with `--headless=new option`
2. Navigate to the login URL - https://the-internet.herokuapp.com/login
  a. Username: tomsmith
  b. Password: SuperSecretPassword!
  3. Submit the login form.
  4. Wait for the result message (success or failure).
  5. Take a screenshot [Wrap key steps in a utility function that takes a screenshot].
  6. Save as screenshots/YYYY-MM-DD-success-<timestamp>.png or screenshots/YYYY-MMDD-
    failure-<timestamp>.png
  7. Use try / catch / finally:
  a. catch Selenium exceptions (e.g., NoSuchElementException, TimeoutException)
  8. Finally, call driver.quit().
*/
object pmTaskWk6day1 extends App {
  //============HEADLESS MODE=============
  val options = new ChromeOptions() // SET THIS UP FOR HEADLESS MODE
  options.addArguments("--headless") // Pass the argument for Headless Mode

  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver(options) // need to pass options in the webdriver

  try {
    //ACCESSING THE WEB URL FOR TESTING
    driver.get("https://the-internet.herokuapp.com/login")

    /*2. Navigate to the login URL - https://the-internet.herokuapp.com/login
  a. Username: tomsmith
  b. Password: SuperSecretPassword!*/
    val userName: WebElement = driver.findElement(By.id("username"))
    val passWord: WebElement = driver.findElement(By.id("password"))
    userName.sendKeys("tomsmith")
    passWord.sendKeys("SuperSecretPassword")
    println("MVP2 Username: " + userName)
    println("MVP Password: " + passWord)


    //explicit wait
    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))

    //3. Submit the login form.
//    val login: WebElement = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"))
//   explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/button/i"))).click()
   explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginbutton"))).click()


    //    login.click()
    println("login entered: successful")



    // 5. Take a screenshot [Wrap key steps in a utility function that takes a screenshot].
    //6. Save as screenshots/YYYY-MM-DD-success-<timestamp>.png or screenshots/YYYY-MMDD-failure-<timestamp>.png

    val srcFull: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    FileHandler.copy(srcFull, new File("/Users/helen.to/Documents/screenshotAutomation/Wk6D1pmtask.png")) // CREATE FILE MANUALLY screenshotAutomation


    val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
    val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    FileHandler.copy(srcTimestamp, new File(s"/Users/helen.to/Documents/screenshotAutomation/Wk6D1pmtask_$timeStamp.png")) // TIMESTAMP so that a new file is created
    println("Screenshot TimeStamp: " + timeStamp)

    //7. Use try / catch / finally:
    // a. catch Selenium exceptions (e.g., NoSuchElementException, TimeoutException)


  }
  catch {
//    case e: NoSuchElementException =>
//      println("element not found" + e.getMessage)
    //    e.printStackTrace()

    case e: TimeoutException =>
      println("Timeout Exception")

    //
    case e: Exception => // USE THIS WHEN YOU DON"T KNOW WHAT TYPE OF EXCEPTION IS EXPECTED
      println("Print any exception: " + e.getMessage)
      e.printStackTrace() // get log for debugging


    // 8. Finally, call driver.quit().

  } finally {
    if (driver != null) {
      driver.quit()
    }


  }
}

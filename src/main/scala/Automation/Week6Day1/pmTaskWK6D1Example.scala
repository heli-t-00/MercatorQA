package Automation.Week6Day1
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import Automation.Utilities.ScreenshotUtil.takeScreenshot

import java.io.File
import java.time.format.DateTimeFormatter
import java.time.{Duration, LocalDateTime}

object pmTaskWK6D1Example  extends App {

  // Configure ChromeOptions for headless mode
  val chromeOptions = new ChromeOptions() // creates new settings object in Chrome
  chromeOptions.addArguments("--headless=new") // runs Chrome in headless mode, no browser window opens ie. runs in background only, this is useful for testing and automation ( "--headless=new" is new version of headless mode by Chrome.)
  chromeOptions.addArguments("--disable-gpu") // turns off GPU (graphics card) acceleration
  chromeOptions.addArguments("--window-size=1920,1080") // sets browser size - even in headless mode, this is required for 'virtual' screen size for page to render properly.

  var driver: WebDriver = null // Declare driver outside try for finally block access (sets to null ="no value yet"
  val timestamp: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss")) // creates timestamp string, getting date and time, this helps tracks when screenshots are taken
  val screenshotsDir = new File("screenshots") // creates file object poinitng to a folder called screenshots in directory (NB: this does not create folder, only a place where it will be stored)
  if (!screenshotsDir.exists()) screenshotsDir.mkdirs() // Create screenshots directory after checking whether it Exist, if no then .mkdirs() creates this.
  // NEED folder first, if no folder exist, the screenshot will crash when it tries to save a file. This code allows it to be made first.

  try { // wrapping the TRY block around the WHOLE code, if anything goes wrong ie. an error, it jumps to CATCH block.
    driver = new ChromeDriver(chromeOptions) // opens up Chrome using ChromeOptions (headless mode)
    val wait = new WebDriverWait(driver, Duration.ofSeconds(10)) // Max 10-second wait - setting up WAIT rule

    // Navigate to the login page
    driver.get("https://the-internet.herokuapp.com/login")
    println("Navigated to login page.")

    // Enter credentials, wait for the input boxes to appear and then type in the username and password
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("tomsmith")
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("SuperSecretPassword!")
    println("Entered credentials.")

    // Click login button - WAIT until button is clickable, then click
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginbutton"))).click()
    println("Clicked login button.")

    // Check login status and take screenshot - WAIT until message at the top appears after login
    val flashMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).getText
    // Determines success or failure - this message includes the success phrase, either saves as success or failure in status variable
    val status = if (flashMessageText.contains("You logged into a secure area!")) "success" else "failure"
    println(s"Login status: $status - Message: $flashMessageText")

    // Takes a screenshot, using custom function takeScreenshot
    takeScreenshot (driver, s"screenshots/login-$status-$timestamp.png")
    println(s"Screenshot saved for $status.")

  } catch { //  CATCH block - Handle Errors - this will run if TRY Block fails
    case e: Exception =>
      println(s"An error occurred: ${e.getClass.getSimpleName} - ${e.getMessage}")
      // Take a screenshot on any exception
      takeScreenshot(driver, s"screenshots/error-exception-$timestamp.png")
      println("Screenshot saved for error.")
      e.printStackTrace() // Print stack trace for debugging

  } finally {
    // Always close the browser
    if (driver != null) {
      println("Closing browser.")
      driver.quit()
    }
  }




}

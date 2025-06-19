package Automation.Week5Day4
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}

import java.time.Duration

object JavaScriptExecutor extends App {

  // Create ChromeDriver instance
  val driver: WebDriver = new ChromeDriver()

//  //SYNCHRONISATION - implicit wait - apply globally
//  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((10)))

  // Navigate to the website
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

    driver.manage().window().maximize()

  val emailAddress: WebElement = driver.findElement(By.id("email")) //find the element by id (find through inspecting webpage
  emailAddress.sendKeys("test@gmail.com") //this is allowing us to enter an input (text) to a field (the email box in this case)
  println("Email address entered")


  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("TestPassword")
  println("Password entered")

  //Not working currently - don't know enough yet. (Might need to wait.)
  val login: WebElement = driver.findElement(By.id("login")) //find submit button through id
  //  login.click() //click the button

  // Casts the WebDriver instance to JavascriptExecutor so you can execute custom JavaScript in the browser.
  // This is necessary because not all WebDriver instances directly expose JavaScript execution.
  val js = driver.asInstanceOf[JavascriptExecutor]
  // Scrolls the `login` element into the visible area of the browser window using JavaScript.
  // This helps ensure the button is visible before interacting with it (prevents ElementNotInteractableException).
  js.executeScript("arguments[0].scrollIntoView(true);", login)
  // Clicks on the `login` element using JavaScript instead of the usual WebDriver `.click()` method.
  // Useful when the normal `.click()` fails due to overlays, hidden elements, or other UI issues.
  js.executeScript("arguments[0].click();", login)
  println("Clicked using JS Executor - Login successful")


  // USING ASSERTION FOR VALIDATION
  //should now go to a heading that says "Thank you" on the next page.
  val header = driver.findElement(By.tagName("h2")).getText
  println("Header: " + header)
  assert(header == "Thank You!")

  // Close browser
  driver.quit()
}
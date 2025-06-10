package Automation.Week4Day4
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
object pmTaskAutomationLocatorID  extends App {
  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

// TASK
  //Find By ID
  //1. Locate the text input field using id locator and enter any name (e.g., "Alice").
 val textInput = driver.findElement(By.id("my-text-id"))
  textInput.sendKeys("Helen")
  println("Task 1. Text Input: Helen")

  //2.Find By Name
  //Locate the password field using name locator and enter any password (e.g., "12345").
  val passwordInput = driver.findElement(By.name("my-password"))
  passwordInput.sendKeys("Password1223")
  println("Task 2. Password: 1223")

  //3.Find By Class Name
  //Locate the text area using class name locator and enter text like "This is a test comment."
val textarea = driver.findElement(By.className("form-control"))
  textarea.sendKeys("This is a test comment")
  println("Task 3. This is a test comment")


  //4.Find By Tag Name
  //Locate all <input> elements and print how many are present on the page.

val inputElements = driver.findElements(By.tagName("input"))
  println(s"number of input elements: ${inputElements.size}")
  println(s"Task 4. Number of <input> elements: ${inputElements.size()}")

  //5.By LinkText
  //Click on the link with full text "Return to index" (at the bottom of the form).

val linkTextn= driver.findElement(By.linkText("Return to index"))
  linkTextn.click()
  println("Task 5. Clicked 'Return to index' ")

  //6.By PartialLinkText
  //Navigate back to the form page and locate the same link using "Return" (partial text), then click it again.

  driver.navigate().back()
  val partialLink = driver.findElement(By.partialLinkText("Return"))
  partialLink.click()
  println("Task 6. Clicked link using partial link text 'Return'")




  driver.quit()


}

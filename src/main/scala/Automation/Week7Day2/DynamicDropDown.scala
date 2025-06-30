package Automation.Week7Day2

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object DynamicDropDown extends App {
  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://demoqa.com/automation-practice-form")


  // APPLY WAIT
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  driver.manage().window().maximize()

  val stateField = driver.findElement((By.id("state")))

  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", stateField)

  stateField.click() //  CLICKED on field for the list to appear

  // Find value and click the state (ADD explicitWait.until to wait for the options to be appear)
  val stateOption = explicitWait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'NCR')]")))

  stateOption.click()


  val cityField = driver.findElement(By.id("city"))

  cityField.click()

  val cityOption = explicitWait.until(  ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Delhi')]")))


  cityOption.click()

  //use assertion to check that this is selected

  val chosenState = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,'-singleValue')]")).getText
  val chosenCity  = driver.findElement(By.xpath("//div[@id='city']//div[contains(@class,'-singleValue')]")).getText
  assert(chosenState == "NCR",  s"State was <$chosenState>")
  assert(chosenCity  == "Delhi", s"City  was <$chosenCity>")

println("State and City selected successfully!")

  //NB: USE xpath to find the exact locator for the element especially in dynamic dropdown



}
